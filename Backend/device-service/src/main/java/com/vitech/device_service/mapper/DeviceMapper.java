package com.vitech.device_service.mapper;

import com.vitech.device_service.dto.request.Device.DeviceCreationRequest;
import com.vitech.device_service.dto.request.Device.DeviceUpdateRequest;
import com.vitech.device_service.dto.response.DeviceResponse;
import com.vitech.device_service.entity.Device;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface DeviceMapper {
    Device toDevice(DeviceCreationRequest request);

    void updateDevice(@MappingTarget Device device, DeviceUpdateRequest request);

    DeviceResponse toDeviceResponse(Device device);
}
