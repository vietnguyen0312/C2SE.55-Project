package com.vitech.device_service.mapper;

import com.vitech.device_service.dto.request.Component.ComponentCreationRequest;
import com.vitech.device_service.dto.request.Component.ComponentUpdateRequest;
import com.vitech.device_service.dto.response.ComponentResponse;
import com.vitech.device_service.entity.Component;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface ComponentMapper {
    Component toComponent(ComponentCreationRequest request);

    void updateComponent(@MappingTarget Component component, ComponentUpdateRequest request);

    ComponentResponse toComponentResponse(Component component);
}
