package com.vitech.device_service.repository.httpClient;

import com.vitech.device_service.dto.response.UserResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(name = "identity-service", url = "${app.services.identity}")
public interface IdentityClient {
    @GetMapping(value = "/myInfo", produces = MediaType.APPLICATION_JSON_VALUE)
    UserResponse getMyInfo();
}
