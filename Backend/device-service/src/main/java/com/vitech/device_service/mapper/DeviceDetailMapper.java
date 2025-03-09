package com.vitech.device_service.mapper;

import com.vitech.device_service.dto.request.DeviceDetail.DeviceDetailCreationRequest;
import com.vitech.device_service.dto.request.DeviceDetail.DeviceDetailUpdateRequest;
import com.vitech.device_service.dto.response.DeviceDetailResponse;
import com.vitech.device_service.entity.DeviceDetail;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface DeviceDetailMapper {
    DeviceDetail toDeviceDetail(DeviceDetailCreationRequest request);

    void updateDeviceDetail(@MappingTarget DeviceDetail deviceDetail, DeviceDetailUpdateRequest request);

    DeviceDetailResponse toDeviceDetailResponse(DeviceDetail deviceDetail);
}
