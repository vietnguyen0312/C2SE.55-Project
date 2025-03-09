package com.vitech.device_service.mapper;

import com.vitech.device_service.dto.request.MaintainSchedule.MaintainScheduleCreationRequest;
import com.vitech.device_service.dto.request.MaintainSchedule.MaintainScheduleUpdateRequest;
import com.vitech.device_service.dto.response.MaintainScheduleResponse;
import com.vitech.device_service.entity.MaintainSchedule;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface MaintainScheduleMapper {
    MaintainSchedule toMaintainSchedule(MaintainScheduleCreationRequest request);

    void updateMaintainSchedule(@MappingTarget MaintainSchedule maintainSchedule, MaintainScheduleUpdateRequest request);

    MaintainScheduleResponse toMaintainScheduleResponse(MaintainSchedule maintainSchedule);
}
