package com.vitech.device_service.dto.response;

import com.vitech.device_service.entity.Device;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class ComponentResponse {
    String id;
    String name;
    String image;
    int quantity;
    List<Device> devices;
}
