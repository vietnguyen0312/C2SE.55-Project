package com.vitech.device_service.dto.request.ComponentDetail;

import jakarta.validation.constraints.NotBlank;
import lombok.*;
import lombok.experimental.FieldDefaults;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class ComponentDetailUpdateRequest {
    @NotBlank(message = "NOT_BLANK")
    String deviceDetailId;
}
