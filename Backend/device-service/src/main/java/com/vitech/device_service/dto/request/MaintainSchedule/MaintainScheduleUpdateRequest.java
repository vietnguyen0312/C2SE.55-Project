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
public class MaintainScheduleUpdateRequest {
    @NotBlank(message = "NOT_BLANK")
    Instant maintainAt;

    @NotBlank(message = "NOT_BLANK")
    String userId;

    @NotBlank(message = "NOT_BLANK")
    String status;
}
