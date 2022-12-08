package com.myservice.domain.base.entity;

import java.time.LocalDateTime;
import java.util.UUID;
import javax.persistence.Column;
import javax.persistence.EntityListeners;
import javax.persistence.MappedSuperclass;
import lombok.Getter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@Getter
@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
public class BaseEntity {
  @Column(columnDefinition = "BINARY(16)", nullable = false, updatable = false)
  protected UUID createdBy;

  @CreatedDate
  @Column(nullable = false, updatable = false)
  protected LocalDateTime createdAt;

  @Column(columnDefinition = "BINARY(16)", nullable = false)
  protected UUID updatedBy;

  @LastModifiedDate
  @Column(nullable = false)
  protected LocalDateTime updatedAt;
}
