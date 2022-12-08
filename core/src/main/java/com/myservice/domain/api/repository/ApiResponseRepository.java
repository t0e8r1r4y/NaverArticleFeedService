package com.myservice.domain.api.repository;

import com.myservice.domain.api.entity.ApiResponse;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ApiResponseRepository extends JpaRepository<ApiResponse, Long> {

}
