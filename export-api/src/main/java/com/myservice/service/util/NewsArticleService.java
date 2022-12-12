package com.myservice.service.util;

import com.myservice.domain.article.dto.NewsResultSaveDto;
import com.myservice.domain.article.entity.ApiComposedKey;
import com.myservice.domain.article.repository.NewsArticleRepository;
import com.myservice.domain.article.util.NewsArticleItemParser;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Slf4j
@RequiredArgsConstructor
public class NewsArticleService {

  private final NewsArticleRepository newsArticleRepository;

  @Transactional
  public int saveNewsItemList(ApiComposedKey apiComposedKey, JSONArray newsItem){
    List<NewsResultSaveDto> newsList = new ArrayList<>();

    Iterator<JSONObject> iter = newsItem.iterator();
    while(iter.hasNext()){
      JSONObject itemEach = iter.next();
      NewsResultSaveDto dto = NewsResultSaveDto.of(apiComposedKey,
          NewsArticleItemParser.parser(itemEach));
      newsList.add(dto);
    }

    newsArticleRepository.saveAll(
        newsList.stream()
            .map(NewsResultSaveDto::toEntity)
            .collect(Collectors.toList())
    );

    return newsList.size();
  }

}
