package com.myservice.web;

import com.myservice.security.SessionUser;
import com.myservice.service.KeywordService;
import com.myservice.web.dto.KeyWordAddRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.SessionAttribute;

@Controller
@RequiredArgsConstructor
public class KeyWordController {
  private final KeywordService keywordService;

  @GetMapping("/keyword/view/add")
  public String keyWordAddView(@SessionAttribute SessionUser user, Model model){
    if(user != null){
      model.addAttribute("user",user);
    }
    KeyWordAddRequest keyWordAddRequest = keywordService.getKeyWordsByUserId(user);
    model.addAttribute("keyWordAddRequest",keyWordAddRequest);

    return "keyword/addView";
  }
}
