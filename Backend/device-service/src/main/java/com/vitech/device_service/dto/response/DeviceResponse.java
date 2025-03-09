package com.vitech.device_service.dto.response;

import com.vitech.device_service.entity.Category;
import com.vitech.device_service.entity.Component;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class DeviceResponse {
    String id;
    String name;
    Category category;
    String image;
    int quantity;
    List<Component> components;
}
