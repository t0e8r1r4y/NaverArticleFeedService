package com.myservice.domain.keyword.entity;

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

@Entity(name = "KEYWORD")
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class KeyWord extends BaseEntity {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column(length = 256, nullable = false)
  private String keyword;

  public static KeyWord of(final String keyword, final UUID userId) {
    return new KeyWord(keyword, userId);
  }

  private KeyWord(final String keyword, final UUID userId) {
    this.keyword = keyword;

    this.createdBy = userId;
    this.updatedBy = userId;
  }
}
