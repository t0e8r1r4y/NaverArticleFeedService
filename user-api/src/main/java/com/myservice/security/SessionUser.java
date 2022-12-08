package com.myservice.security;

import com.myservice.domain.user.entity.User;
import java.io.Serializable;
import java.util.UUID;
import lombok.Getter;

@Getter
public class SessionUser implements Serializable {
  private UUID id;
  private String name;
  private String email;
  private String picture;

  public SessionUser(User user){
    this.id = user.getId();
    this.name = user.getName();
    this.email = user.getEmail();
    this.picture = user.getPicture();
  }
}
