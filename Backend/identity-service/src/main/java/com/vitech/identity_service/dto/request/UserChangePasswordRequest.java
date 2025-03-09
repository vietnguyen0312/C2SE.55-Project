package com.vitech.identity_service.dto.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.*;
import lombok.experimental.FieldDefaults;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class UserChangePasswordRequest {

    @NotBlank(message = "NOT_BLANK")
    String currentPassword;

    @NotBlank(message = "NOT_BLANK")
    @Size(min = 8, message = "MIN_SIZE")
    String newPassword;
}
