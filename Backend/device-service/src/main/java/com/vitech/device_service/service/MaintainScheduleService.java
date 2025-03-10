package com.vitech.device_service.service;

import com.vitech.device_service.dto.request.MaintainSchedule.MaintainScheduleCreationRequest;
import com.vitech.device_service.dto.request.MaintainSchedule.MaintainScheduleUpdateRequest;
import com.vitech.device_service.dto.response.MaintainScheduleResponse;
import com.vitech.device_service.dto.response.PageResponse;
import com.vitech.device_service.entity.MaintainSchedule;
import com.vitech.device_service.enums.ErrorCode;
import com.vitech.device_service.exception.AppException;
import com.vitech.device_service.mapper.MaintainScheduleMapper;
import com.vitech.device_service.repository.DeviceDetailRepository;
import com.vitech.device_service.repository.MaintainScheduleRepository;
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
public class MaintainScheduleService {
    MaintainScheduleRepository maintainScheduleRepository;
    DeviceDetailRepository deviceDetailRepository;
    MaintainScheduleMapper maintainScheduleMapper;

    public MaintainScheduleResponse createMaintainSchedule(MaintainScheduleCreationRequest request){
        MaintainSchedule maintainSchedule = maintainScheduleMapper.toMaintainSchedule(request);

        maintainSchedule.setDeviceDetail(deviceDetailRepository.findById(request.getDeviceDetailId())
                .orElseThrow(()->new AppException(ErrorCode.NOT_EXISTED)));

        return maintainScheduleMapper.toMaintainScheduleResponse(maintainScheduleRepository.save(maintainSchedule));
    }

    public MaintainScheduleResponse updateMaintainSchedule(String id,
                                                           MaintainScheduleUpdateRequest request) {
        MaintainSchedule maintainSchedule = maintainScheduleRepository.findById(id)
                .orElseThrow(()-> new AppException(ErrorCode.NOT_EXISTED));

        maintainScheduleMapper.updateMaintainSchedule(maintainSchedule, request);

        return maintainScheduleMapper.toMaintainScheduleResponse(maintainScheduleRepository.save(maintainSchedule));
    }

    public void deleteMaintainSchedule(String id){
        maintainScheduleRepository.deleteById(id);
    }

    public PageResponse<MaintainScheduleResponse> getMaintainSchedule(
            int page, int size,
            Instant createdStartDate, Instant createdEndDate,
            Instant maintainStartDate, Instant maintainEndDate,
            String deviceDetailId, String userId, String status) {
        Pageable pageable = PageRequest.of(page - 1, size,
                Sort.by("createdAt").descending());

        Page<MaintainSchedule> maintainSchedule = maintainScheduleRepository.searchMaintainSchedules(
                createdStartDate, createdEndDate,
                maintainStartDate, maintainEndDate,
                deviceDetailId, userId, status, pageable);

        List<MaintainScheduleResponse> maintainScheduleResponses = maintainSchedule.stream()
                .map(maintainScheduleMapper :: toMaintainScheduleResponse)
                .toList();

        return PageResponse.<MaintainScheduleResponse>builder()
                .currentPage(page)
                .pageSize(size)
                .totalPages(maintainSchedule.getTotalPages())
                .totalElements(maintainSchedule.getTotalElements())
                .data(maintainScheduleResponses)
                .build();
    }
}
