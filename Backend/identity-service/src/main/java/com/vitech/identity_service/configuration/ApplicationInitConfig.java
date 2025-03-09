package com.vitech.identity_service.configuration;

import com.vitech.identity_service.entity.User;
import com.vitech.identity_service.enums.RoleEnum;
import com.vitech.identity_service.repository.UserRepository;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.ApplicationRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@Slf4j
public class ApplicationInitConfig {

    private PasswordEncoder passwordEncoder;

    @Bean
    ApplicationRunner applicationRunner(UserRepository userRepository) {
        return args -> {
            if (userRepository.findByUsername("facility").isEmpty()) {
                log.info("Add FACILITY_MANAGER account");

                User user = User.builder()
                        .email("facility_manager@gmail.com")
                        .username("facility")
                        .password(passwordEncoder.encode("facility"))
                        .role(RoleEnum.ROLE_FACILITY_MANAGER.getName())
                        .build();

                userRepository.save(user);
                log.warn("FACILITY_MANAGER user has been created with default password: facility, please change it.");
            }
        };
    }

}
