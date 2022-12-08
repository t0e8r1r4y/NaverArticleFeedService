package com.myservice.service;

import com.myservice.domain.keyword.entity.KeyWord;
import com.myservice.domain.keyword.repository.KeyWordRepository;
import com.myservice.security.SessionUser;
import com.myservice.web.dto.KeyWordAddRequest;
import java.util.List;
import java.util.stream.Collectors;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
@RequiredArgsConstructor
public class KeywordService {

  private final KeyWordRepository keyWordRepository;

  public void addKeyword(KeyWordAddRequest keyWordAddRequest, SessionUser user){
    List<KeyWord> userKeywords = keyWordAddRequest.toKeyWordList(user);
    keyWordRepository.deleteByCreatedBy(user.getId());
    keyWordRepository.saveAll(userKeywords);
  }

  public KeyWordAddRequest getKeyWordsByUserId(SessionUser user) {
    List<KeyWord> userKeyWords = keyWordRepository.findByCreatedBy(user.getId());
    return new KeyWordAddRequest(joinedKeywords(userKeyWords));
  }

  private String joinedKeywords(List<KeyWord> keyWords){
    return keyWords.stream().map(KeyWord::getKeyword).collect(Collectors.joining(","));
  }
}
