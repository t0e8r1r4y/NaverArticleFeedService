package com.myservice.domain.email.repository;

import com.myservice.domain.email.entity.Email;
import com.myservice.domain.email.repository.EmailQueryDslRepository;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmailRepository extends JpaRepository<Email, Long>, EmailQueryDslRepository {

}
