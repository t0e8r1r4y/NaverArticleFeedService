package com.myservice.web.dto;

import com.myservice.domain.keyword.entity.KeyWord;
import com.myservice.security.SessionUser;
import com.myservice.web.validation.MaxKeyword;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class KeyWordAddRequest {
  @MaxKeyword
  private String userKeyWordList;
  private static final String TOKEN_SEPARATOR = ",";

  public KeyWordAddRequest(String userKeyWordList) {
    this.userKeyWordList = userKeyWordList;
  }

  public List<KeyWord> toKeyWordList(SessionUser user) {
    return Arrays.stream(userKeyWordList.split(","))
        .map((token) -> KeyWord.of(token,user.getId()))
        .collect(Collectors.toList());
  }
}
