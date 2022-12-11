package com.myservice.domain.api.entity;

import com.myservice.domain.base.entity.BaseEntity;
import java.util.UUID;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity(name = "APIRESPONSE")
public class ApiResponse extends BaseEntity {

  @EmbeddedId
  private ComposedKey id;

  @Column(length = 256, nullable = true)
  private String lastBuildDate;

  @Column(length = 256)
  private Long total;

  public static ApiResponse of( final String keyword, final UUID userId ,
      final String lastBuildDate, final Long total, final String requestUrl) {
    return new ApiResponse( keyword, userId ,lastBuildDate, total, requestUrl);
  }

  private ApiResponse( final String keyword, final UUID userId ,final String lastBuildDate,
      final Long total, final String requestUrl) {
    this.id = new ComposedKey(userId, keyword, requestUrl);
    this.lastBuildDate = lastBuildDate;
    this.total = total;

    this.createdBy = userId;
    this.updatedBy = userId;
  }
}
