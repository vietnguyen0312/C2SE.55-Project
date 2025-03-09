package com.vitech.device_service.entity;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;
import org.springframework.util.StringUtils;

@Entity
@Table(name = "component_detail")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class ComponentDetail {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    String id;

    @ManyToOne
    @JoinColumn(name = "component_id")
    Component component;

    @ManyToOne
    @JoinColumn(name = "device_detail_id")
    DeviceDetail deviceDetail;

    @Column(nullable = false)
    String buyAt;
}
