package com.myservice.domain.email.repository;

import com.myservice.domain.email.entity.Email;
import java.util.List;
import java.util.UUID;

public interface EmailQueryDslRepository {
  List<Email> findEmailListByUserId(UUID userId);

  Long getEmailCount(UUID userId);
}
