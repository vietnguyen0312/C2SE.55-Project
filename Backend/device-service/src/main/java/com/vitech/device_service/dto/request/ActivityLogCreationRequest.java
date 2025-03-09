package com.vitech.device_service.dto.request;

import com.vitech.device_service.entity.DeviceDetail;
import jakarta.validation.constraints.FutureOrPresent;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.PastOrPresent;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.time.Instant;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class ActivityLogCreationRequest {
    @NotBlank(message = "NOT_BLANK")
    String deviceDetailId;

    @NotBlank(message = "NOT_BLANK")
    String description;

    @NotBlank(message = "NOT_BLANK")
    Instant createdAt;
}
