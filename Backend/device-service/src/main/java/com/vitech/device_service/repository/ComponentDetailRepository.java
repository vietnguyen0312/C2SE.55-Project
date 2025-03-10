package com.vitech.device_service.repository;

import com.vitech.device_service.entity.ComponentDetail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ComponentDetailRepository extends JpaRepository<ComponentDetail, String> {
}
