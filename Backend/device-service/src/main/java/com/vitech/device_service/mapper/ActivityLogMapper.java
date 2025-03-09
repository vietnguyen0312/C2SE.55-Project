package com.vitech.device_service.mapper;

import com.vitech.device_service.dto.request.ActivityLogCreationRequest;
import com.vitech.device_service.dto.request.CategoryCreationRequest;
import com.vitech.device_service.dto.response.ActivityLogResponse;
import com.vitech.device_service.dto.response.CategoryResponse;
import com.vitech.device_service.entity.ActivityLog;
import com.vitech.device_service.entity.Category;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ActivityLogMapper {
    ActivityLog toActivityLog(ActivityLogCreationRequest request);

    ActivityLogResponse toActivityLogResponse(ActivityLog activityLog);
}
