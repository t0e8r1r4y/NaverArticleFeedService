package com.myservice.domain.api.repository;

import com.myservice.domain.api.entity.ApiResponse;
import com.myservice.domain.api.entity.ComposedKey;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ApiResponseRepository extends JpaRepository<ApiResponse, ComposedKey> {

}
