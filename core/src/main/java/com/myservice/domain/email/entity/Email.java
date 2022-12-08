package com.myservice.domain.email.entity;

import com.myservice.domain.base.entity.BaseEntity;
import java.util.UUID;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity(name = "EMAIL")
public class Email extends BaseEntity {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "id", nullable = false)
  private Long id;

  @Column(length = 256, nullable = false)
  private String address;

  @Column(length = 256, nullable = false)
  private String title;

  @Column(length = 4096, nullable = false)
  private String body;

  @Column(nullable = false)
  private Boolean sendResult;

  public static Email of(final String address, final String title, final String body,
      final UUID userId, final Boolean sendResult) {
    return new Email(address, title, body, userId, sendResult);
  }

  private Email(final String address, final String title, final String body, final UUID userId,
      final Boolean sendResult){
    this.address = address;
    this.title = title;
    this.body = body;

    this.createdBy = userId;
    this.updatedBy = userId;

    this.sendResult = sendResult;
  }

}
