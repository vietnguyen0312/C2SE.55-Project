package com.vitech.device_service.entity;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;
import org.springframework.util.StringUtils;

import java.time.Instant;

@Entity
@Table(name = "maintain_schedule")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class MaintainSchedule {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    String id;

    @ManyToOne
    @JoinColumn(name = "device_detail_id")
    DeviceDetail deviceDetail;

    @Column(nullable = false)
    Instant createdAt;

    @Column(nullable = false)
    Instant maintainAt;

    @Column(nullable = false)
    String userId;

    @Column(nullable = false)
    String status;

    @PrePersist
    public void prePersist() {
        if (!StringUtils.hasLength(status)) {
            status = "Chưa hoàn thành";
        }
    }
}
