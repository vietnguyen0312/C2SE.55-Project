package com.vitech.device_service.dto.request.DeviceDetail;

import jakarta.validation.constraints.NotBlank;
import lombok.*;
import lombok.experimental.FieldDefaults;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class DeviceDetailUpdateRequest {
    @NotBlank(message = "NOT_BLANK")
    String barCode;

    String location;

    @NotBlank(message = "NOT_BLANK")
    String status;
}
