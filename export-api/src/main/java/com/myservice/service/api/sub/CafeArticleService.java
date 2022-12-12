package com.myservice.service.api.sub;

import com.myservice.domain.article.dto.CafeResultSaveDto;
import com.myservice.domain.article.entity.ApiComposedKey;
import com.myservice.domain.article.repository.CafeArticleRepository;
import com.myservice.domain.article.util.CafeArticleItemParser;
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
public class CafeArticleService {
  private final CafeArticleRepository cafeArticleRepository;

  @Transactional
  public int saveCafeItemList(ApiComposedKey apiComposedKey, JSONArray cafeItem){
    List<CafeResultSaveDto> cafeList = new ArrayList<>();

    Iterator<JSONObject> iter = cafeItem.iterator();
    if(iter == null) return 0;

    while(iter.hasNext()){
      JSONObject itemEach = iter.next();
      CafeResultSaveDto dto = CafeResultSaveDto.of(apiComposedKey,
          CafeArticleItemParser.parser(itemEach));
      cafeList.add(dto);
    }

    cafeArticleRepository.saveAll(
        cafeList.stream()
            .map(CafeResultSaveDto::toEntity)
            .collect(Collectors.toList())
    );

    return cafeList.size();
  }
}
