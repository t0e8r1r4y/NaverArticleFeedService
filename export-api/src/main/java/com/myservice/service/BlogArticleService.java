package com.myservice.service;

import com.myservice.domain.article.dto.BlogResultSaveDto;
import com.myservice.domain.article.entity.ApiComposedKey;
import com.myservice.domain.article.repository.BlogArticleRepository;
import com.myservice.domain.article.util.BlogArticleItemParser;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Slf4j
@RequiredArgsConstructor
public class BlogArticleService {

  private final BlogArticleRepository blogArticleRepository;

  @Transactional
  public void saveBlogItemList(ApiComposedKey apiComposedKey, JSONArray blogItem) {

    List<BlogResultSaveDto> blogList = new ArrayList<>();

    Iterator<JSONObject> iter = blogItem.iterator();
    while(iter.hasNext()) {
      JSONObject itemEach = (JSONObject) iter.next();
      BlogResultSaveDto dto = BlogResultSaveDto.of( apiComposedKey,
          BlogArticleItemParser.parser(itemEach));
      blogList.add(dto);
      log.info(dto.getBloggerName() + " " +dto.getTitle());
    }

    return;
  }
}
