package com.vitech.device_service.dto.request.ComponentDetail;

import jakarta.validation.constraints.FutureOrPresent;
import jakarta.validation.constraints.NotBlank;
import lombok.*;
import lombok.experimental.FieldDefaults;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class ComponentDetailCreationRequest {
    @NotBlank(message = "NOT_BLANK")
    String componentId;

    @NotBlank(message = "NOT_BLANK")
    String deviceDetailId;

    @NotBlank(message = "NOT_BLANK")
    String buyAt;
}
