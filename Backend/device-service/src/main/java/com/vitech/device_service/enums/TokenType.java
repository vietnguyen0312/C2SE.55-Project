package com.vitech.device_service.enums;

import lombok.Getter;

@Getter
public enum TokenType {
    ACCESS_TOKEN("access"),
    REFRESH_TOKEN("refresh");

    TokenType(String name) {
        this.name = name;
    }

    private final String name;
}
