package com.vitech.device_service.dto.request.Device;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;
import lombok.*;
import lombok.experimental.FieldDefaults;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class DeviceCreationRequest {
    @NotBlank(message = "NOT_BLANK")
    @Size(min = 3, max = 50, message = "BETWEEN_SIZE")
    String name;

    @NotBlank(message = "NOT_BLANK")
    String categoryId;

    String image;

    @Positive(message = "POSITIVE")
    int quantity;
}
