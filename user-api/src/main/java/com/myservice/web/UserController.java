package com.myservice.web;

import com.myservice.security.SessionUser;
import javax.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/user")
@Slf4j
@RequiredArgsConstructor
public class UserController {
  private final HttpSession httpSession;

  @GetMapping
  public String index(Model model)
  {
    SessionUser user = (SessionUser) httpSession.getAttribute("user");
    if(user != null){
      model.addAttribute("user",user);
    }
    return "user/index";
  }
}
