package com.vitech.device_service.repository;

import com.vitech.device_service.entity.DeviceDetail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DeviceDetailRepository extends JpaRepository<DeviceDetail, String> {
}
