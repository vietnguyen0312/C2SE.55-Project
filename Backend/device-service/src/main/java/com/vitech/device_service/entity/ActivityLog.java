package com.vitech.device_service.entity;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.time.Instant;

@Entity
@Table(name = "activity_log")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class ActivityLog {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    String id;

    @Column(nullable = false)
    String userId;

    @ManyToOne
    @JoinColumn(name = "device_detail_id")
    DeviceDetail deviceDetail;

    @ManyToOne
    @JoinColumn(name = "maintain_schedule_id")
    MaintainSchedule maintainSchedule;

    @Column(nullable = false)
    String description;

    @Column(nullable = false)
    Instant createdAt;
}
