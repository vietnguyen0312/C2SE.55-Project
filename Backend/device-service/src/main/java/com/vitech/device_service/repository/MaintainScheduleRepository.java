package com.vitech.device_service.repository;

import com.vitech.device_service.entity.MaintainSchedule;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import java.time.Instant;

public interface MaintainScheduleRepository extends JpaRepository<MaintainSchedule, String> {

    @Query("SELECT m FROM MaintainSchedule m " +
            "WHERE (:createdStartDate IS NULL OR :createdEndDate IS NULL OR m.createdAt BETWEEN :createdStartDate AND :createdEndDate) " +
            "AND (:maintainStartDate IS NULL OR :maintainEndDate IS NULL OR m.maintainAt BETWEEN :maintainStartDate AND :maintainEndDate) " +
            "AND (:deviceDetailId IS NULL OR m.deviceDetail.id = :deviceDetailId) " +
            "AND (:userId IS NULL OR m.userId = :userId) " +
            "AND (:status IS NULL OR m.status = :status)")
    Page<MaintainSchedule> searchMaintainSchedules(
            @Param("createdStartDate") Instant createdStartDate,
            @Param("createdEndDate") Instant createdEndDate,
            @Param("maintainStartDate") Instant maintainStartDate,
            @Param("maintainEndDate") Instant maintainEndDate,
            @Param("deviceDetailId") String deviceDetailId,
            @Param("userId") String userId,
            @Param("status") String status,
            Pageable pageable);
}

