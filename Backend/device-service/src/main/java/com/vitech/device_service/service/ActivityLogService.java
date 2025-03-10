package com.vitech.device_service.service;

import com.vitech.device_service.dto.request.ActivityLogCreationRequest;
import com.vitech.device_service.dto.response.ActivityLogResponse;
import com.vitech.device_service.dto.response.PageResponse;
import com.vitech.device_service.entity.ActivityLog;
import com.vitech.device_service.enums.ErrorCode;
import com.vitech.device_service.exception.AppException;
import com.vitech.device_service.mapper.ActivityLogMapper;
import com.vitech.device_service.repository.ActivityLogRepository;
import com.vitech.device_service.repository.DeviceDetailRepository;
import com.vitech.device_service.repository.httpClient.IdentityClient;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.List;

@Service
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@Slf4j
public class ActivityLogService {
    ActivityLogRepository activityLogRepository;
    DeviceDetailRepository deviceDetailRepository;
    IdentityClient identityClient;
    ActivityLogMapper activityLogMapper;

    public ActivityLogResponse createActivityLog(ActivityLogCreationRequest request) {
        ActivityLog activityLog = activityLogMapper.toActivityLog(request);

        activityLog.setDeviceDetail(deviceDetailRepository.findById(request.getDeviceDetailId())
                .orElseThrow(() -> new AppException(ErrorCode.NOT_EXISTED)));

        return activityLogMapper.toActivityLogResponse(activityLogRepository.save(activityLog));
    }

    public void deleteActivityLog(String id) {
        activityLogRepository.deleteById(id);
    }

    public ActivityLogResponse getActivityLogById(String id) {
        return activityLogMapper.toActivityLogResponse(activityLogRepository.findById(id)
                .orElseThrow(() -> new AppException(ErrorCode.NOT_EXISTED)));
    }

    public PageResponse<ActivityLogResponse> getActivityLog(String search, Instant startDate,
                                                            Instant endDate,String maintainScheduleId, int page, int size) {
        Pageable pageable = PageRequest.of(page - 1, size,
                Sort.by("createdAt").descending());

        Page<ActivityLog> activityLogs = activityLogRepository.searchActivityLogs(search,
                startDate, endDate, identityClient.getMyInfo().getId(), maintainScheduleId, pageable);

        List<ActivityLogResponse> activityLogResponses = activityLogs.stream()
                .map(activityLogMapper :: toActivityLogResponse)
                .toList();

        return PageResponse.<ActivityLogResponse>builder()
                .currentPage(page)
                .pageSize(size)
                .totalPages(activityLogs.getTotalPages())
                .totalElements(activityLogs.getTotalElements())
                .data(activityLogResponses)
                .build();
    }
}
