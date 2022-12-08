package com.myservice.web;

import com.myservice.security.SessionUser;
import com.myservice.service.KeywordService;
import com.myservice.web.dto.KeyWordAddRequest;
import java.net.URI;
import java.net.URISyntaxException;
import javax.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.SessionAttribute;

@RestController
@RequestMapping("/keyword")
@RequiredArgsConstructor
@Slf4j
public class KeyWordRestController {
  private final KeywordService keywordService;

  @PostMapping("/add")
  public ResponseEntity<String> addKeyWord(@SessionAttribute SessionUser user
      , @Valid KeyWordAddRequest keyWordAddRequest, BindingResult bindingResult) throws URISyntaxException {
    if(bindingResult.hasErrors()){
      return ResponseEntity.badRequest().body("키워드입력 최대 개수 초과");
    }
    keywordService.addKeyword(keyWordAddRequest, user);
    return ResponseEntity.created(new URI("")).body("성공");
  }
}
