package com.myservice.domain.user.dto;

import com.myservice.domain.user.entity.Role;
import com.myservice.domain.user.entity.User;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Optional;
import java.util.UUID;
import lombok.Builder;
import lombok.Getter;

@Getter
public class UserResultDto {
  private UUID id;
  private String name;
  private String email;
  private String picture;
  private Role role;

  public User toEntity(){
    return new User(id,name,email,picture,role);
  }

  @Builder
  public UserResultDto(User user) {
    this.id = user.getId();
    this.name = user.getName();
    this.email = user.getEmail();
    this.picture = user.getPicture();
    this.role = user.getRole();
  }

  private String toStringDateTime(LocalDateTime localDateTime){
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
    return Optional.ofNullable(localDateTime)
        .map(formatter::format)
        .orElse("");
  }
}
