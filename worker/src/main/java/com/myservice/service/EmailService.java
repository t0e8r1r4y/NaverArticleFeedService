package com.myservice.service;

import com.myservice.domain.email.entity.Email;
import com.myservice.domain.email.repository.EmailRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class EmailService {

  private final EmailRepository emailRepository;
  @Transactional
  public Long saveEmail(Email email){
    return emailRepository.save(email).getId();
  }
}
