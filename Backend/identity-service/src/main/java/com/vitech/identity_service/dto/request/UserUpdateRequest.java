package com.vitech.identity_service.dto.request;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.*;
import lombok.experimental.FieldDefaults;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class UserUpdateRequest {

    @NotBlank(message = "NOT_BLANK")
    @Size(min = 3, max = 50, message = "USERNAME_SIZE")
    String username;

    @NotBlank(message = "NOT_BLANK")
    @Email(message = "INVALID")
    String email;

    String role;

    String status;
}
