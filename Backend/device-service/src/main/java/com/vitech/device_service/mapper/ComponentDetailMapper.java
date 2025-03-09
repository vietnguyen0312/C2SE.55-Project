package com.vitech.device_service.mapper;

import com.vitech.device_service.dto.request.ComponentDetail.ComponentDetailCreationRequest;
import com.vitech.device_service.dto.request.ComponentDetail.ComponentDetailUpdateRequest;
import com.vitech.device_service.dto.response.ComponentDetailResponse;
import com.vitech.device_service.entity.ComponentDetail;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface ComponentDetailMapper {
    ComponentDetail toComponentDetail(ComponentDetailCreationRequest request);

    void updateComponentDetail(@MappingTarget ComponentDetail componentDetail, ComponentDetailUpdateRequest request);

    ComponentDetailResponse toComponentDetailResponse(ComponentDetail componentDetail);
}
