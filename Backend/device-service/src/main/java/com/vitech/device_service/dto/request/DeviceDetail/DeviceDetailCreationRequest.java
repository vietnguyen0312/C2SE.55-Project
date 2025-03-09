package com.vitech.device_service.dto.request.DeviceDetail;

import com.vitech.device_service.entity.Device;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.PastOrPresent;
import lombok.*;
import lombok.experimental.FieldDefaults;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class DeviceDetailCreationRequest {
    @NotBlank(message = "NOT_BLANK")
    String deviceId;

    @NotBlank(message = "NOT_BLANK")
    String barCode;

    String location;

    @NotBlank(message = "NOT_BLANK")
    String buyAt;
}
