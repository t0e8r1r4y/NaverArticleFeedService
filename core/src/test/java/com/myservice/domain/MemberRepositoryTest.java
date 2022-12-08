package com.myservice.domain;


import com.myservice.domain.test.Member;
import com.myservice.domain.test.MemberRepository;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@DataJpaTest
public class MemberRepositoryTest {
  @Autowired
  private MemberRepository memberRepository;

  @Test
  public void add(){
    memberRepository.save(new Member("testser", "test@naver.com"));
    Member saved = memberRepository.findById(1L).get();
    Assertions.assertEquals("testser", saved.getName());
  }
}