package com.vitech.device_service.dto.request.MaintainSchedule;

import jakarta.validation.constraints.FutureOrPresent;
import jakarta.validation.constraints.NotBlank;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.time.Instant;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class MaintainScheduleCreationRequest {
    @NotBlank(message = "NOT_BLANK")
    String deviceDetailId;

    @NotBlank(message = "NOT_BLANK")
    Instant createdAt;

    @NotBlank(message = "NOT_BLANK")
    @FutureOrPresent(message = "DATE_FUTURE_OR_PRESENT")
    Instant maintainAt;

    @NotBlank(message = "NOT_BLANK")
    String userId;
}
