package com.vitech.device_service.dto.request;

import jakarta.validation.constraints.NotBlank;
import lombok.*;
import lombok.experimental.FieldDefaults;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class ComponentDeviceCreationRequest {
    @NotBlank(message = "NOT_BLANK")
    String deviceId;

    @NotBlank(message = "NOT_BLANK")
    String componentId;
}
