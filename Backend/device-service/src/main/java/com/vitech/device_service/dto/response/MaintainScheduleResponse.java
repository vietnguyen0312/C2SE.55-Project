package com.vitech.device_service.dto.response;

import com.vitech.device_service.entity.DeviceDetail;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.time.Instant;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class MaintainScheduleResponse {
    String id;
    DeviceDetail deviceDetail;
    Instant createdAt;
    String userId;
    String status;
}
