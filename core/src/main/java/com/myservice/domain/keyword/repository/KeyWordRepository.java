package com.myservice.domain.keyword.repository;

import com.myservice.domain.keyword.entity.KeyWord;
import java.util.List;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;

public interface KeyWordRepository extends JpaRepository<KeyWord, Long> {
  List<KeyWord> findByCreatedBy(UUID userId);
  void deleteByCreatedBy(UUID userId);
}
