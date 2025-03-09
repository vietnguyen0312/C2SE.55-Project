package com.vitech.identity_service.dto.request;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.*;
import lombok.experimental.FieldDefaults;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class UserCreationRequest {

    @NotBlank(message = "NOT_BLANK")
    @Size(min = 3, max = 50, message = "BETWEEN_SIZE")
    String username;

    @Email(message = "INVALID")
    @NotBlank(message = "NOT_BLANK")
    String email;

    @Size(min = 8, message = "MIN_SIZE")
    String password;

    String role;
}
