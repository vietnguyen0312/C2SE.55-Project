package com.vitech.device_service.dto.response;

import com.vitech.device_service.entity.Component;
import com.vitech.device_service.entity.DeviceDetail;
import lombok.*;
import lombok.experimental.FieldDefaults;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class ComponentDetailResponse {
    String id;
    Component component;
    DeviceDetail deviceDetail;
    String buyAt;
}
