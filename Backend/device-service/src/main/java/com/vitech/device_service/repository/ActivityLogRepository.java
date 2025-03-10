package com.vitech.device_service.repository;

import com.vitech.device_service.entity.ActivityLog;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.Instant;

@Repository
public interface ActivityLogRepository extends JpaRepository<ActivityLog, String> {
    @Query("SELECT a FROM ActivityLog a " +
            "WHERE (:search IS NULL OR a.description LIKE %:search%) " +
            "AND (:startDate IS NULL OR :endDate IS NULL OR a.createdAt BETWEEN :startDate AND :endDate) " +
            "AND (:userId IS NULL OR a.userId = :userId) " +
            "AND (:maintainScheduleId IS NULL OR a.maintainSchedule.id = :maintainScheduleId)")
    Page<ActivityLog> searchActivityLogs(@Param("search") String search,
                                         @Param("startDate") Instant startDate,
                                         @Param("endDate") Instant endDate,
                                         @Param("userId") String userId,
                                         @Param("maintainScheduleId") String maintainScheduleId,
                                         Pageable pageable);
}
