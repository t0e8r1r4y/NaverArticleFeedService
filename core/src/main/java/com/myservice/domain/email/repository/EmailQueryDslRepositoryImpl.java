package com.myservice.domain.email.repository;

import static com.myservice.domain.email.entity.QEmail.email;

import com.myservice.domain.email.entity.Email;
import com.querydsl.jpa.impl.JPAQueryFactory;
import java.util.List;
import java.util.UUID;
import lombok.RequiredArgsConstructor;


@RequiredArgsConstructor
public class EmailQueryDslRepositoryImpl implements EmailQueryDslRepository{

  private final JPAQueryFactory jpaQueryFactory;
  @Override
  public List<Email> findEmailListByUserId(UUID userId) {
    return jpaQueryFactory
        .selectFrom(email)
        .where(email.createdBy.eq(userId))
        .fetch();
  }

  @Override
  public Long getEmailCount(UUID userId) {
    return jpaQueryFactory
        .select(email.count())
        .from(email)
        .fetchOne();
  }


}
