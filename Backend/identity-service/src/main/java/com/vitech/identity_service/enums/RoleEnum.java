package com.vitech.identity_service.enums;

import lombok.Getter;

@Getter
public enum RoleEnum {
    ROLE_MANAGER("MANAGER", "MANAGER"),
    ROLE_CUSTOMER("CUSTOMER", "CUSTOMER"),
    ROLE_EMPLOYEE("EMPLOYEE", "EMPLOYEE"),
    ROLE_EMPLOYER("EMPLOYER", "EMPLOYER");

    RoleEnum(String name, String description) {
        this.name = name;
        this.description = description;
    }

    private final String name;
    private final String description;
}
