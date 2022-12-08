package com.myservice.domain.user.repository;


import com.myservice.domain.user.entity.User;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Stream;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface UserRepository extends JpaRepository<User, UUID> {
  Optional<User> findByEmail(String email);

  @Query("SELECT u " +
      "FROM GL_USER u " +
      "ORDER BY u.id DESC")
  Stream<User> findAllDesc();
}
