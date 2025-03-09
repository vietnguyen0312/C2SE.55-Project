package com.vitech.device_service.entity;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;
import org.springframework.util.StringUtils;

@Entity
@Table(name = "device_detail")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class DeviceDetail {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    String id;

    @ManyToOne
    @JoinColumn(name = "device_id")
    Device device;

    @Column(nullable = false)
    String barCode;

    String location;

    @Column(nullable = false)
    String buyAt;

    @Column(nullable = false)
    String status;

    @PrePersist
    public void prePersist() {
        if (!StringUtils.hasLength(status)) {
            if (StringUtils.hasLength(location))
                status = "Đang được sử dụng";
            else
                status = "Chưa được sử dụng";
        }
    }
}
