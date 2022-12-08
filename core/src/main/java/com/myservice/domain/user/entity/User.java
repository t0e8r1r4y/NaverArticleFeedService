package com.myservice.domain.user.entity;

import com.myservice.domain.base.entity.BaseEntity;
import java.util.UUID;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@Entity(name = "GL_USER")
public class User extends BaseEntity {

  @Id
  @Column(columnDefinition = "BINARY(16)", name = "USER_ID")
  private UUID id;

  @Column(nullable = false)
  private String name;

  @Column(nullable = false)
  private String email;

  @Column
  private String picture;

  @Enumerated(EnumType.STRING)
  @Column(nullable = false)
  private Role role;

  public User(final UUID id, final String name, final String email, final String picture, final Role role) {
    this.id = id;
    this.name = name;
    this.email = email;
    this.picture = picture;
    this.role = role;

    this.createdBy = id;
    this.updatedBy = id;
  }

  public User update(String name, String picture){
    this.name = name;
    this.picture = picture;
    return this;
  }

  public String getRoleKey(){
    return this.role.getKey();
  }
}
