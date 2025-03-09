package com.vitech.device_service.dto.response;

import com.vitech.device_service.entity.Device;
import lombok.*;
import lombok.experimental.FieldDefaults;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class DeviceDetailResponse {
    String id;
    Device device;
    String barCode;
    String location;
    String buyAt;
    String status;
}
