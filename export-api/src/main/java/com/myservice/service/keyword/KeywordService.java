package com.myservice.service.keyword;

import com.myservice.domain.keyword.dto.KeyWordDto;
import com.myservice.domain.keyword.repository.KeyWordRepository;
import java.util.List;
import java.util.stream.Collectors;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Slf4j
@RequiredArgsConstructor
public class KeywordService {

  private final KeyWordRepository keyWordRepository;

  @Transactional(readOnly = true)
  public List<KeyWordDto> findKeyWordAll(){
    List<KeyWordDto> list = keyWordRepository.findAll()
        .stream()
        .map(KeyWordDto::new)
        .collect(Collectors.toList());
    return list;
  }

}
