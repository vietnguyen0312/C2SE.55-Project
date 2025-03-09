package com.vitech.device_service.entity;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.List;

@Entity
@Table(name = "device")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Device {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    String id;

    @Column(nullable = false, unique = true)
    String name;

    @ManyToOne
    @JoinColumn(name = "category_id")
    Category category;

    @Column(nullable = false)
    String image;

    @Column(nullable = false)
    int quantity;

    @OneToMany
    List<Component> components;
}
