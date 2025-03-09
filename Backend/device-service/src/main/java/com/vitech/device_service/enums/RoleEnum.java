package com.vitech.device_service.enums;

import lombok.Getter;

@Getter
public enum RoleEnum {
    ROLE_FACILITY_MANAGER("FACILITY_MANAGER", "FACILITY_MANAGER"),
    ROLE_DEPARTMENT_MANAGER("DEPARTMENT_MANAGER", "DEPARTMENT_MANAGER"),
    ROLE_TECHNICIAN("TECHNICIAN", "TECHNICIAN");

    RoleEnum(String name, String description) {
        this.name = name;
        this.description = description;
    }

    private final String name;
    private final String description;
}
