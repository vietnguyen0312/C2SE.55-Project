package com.vitech.device_service.controller;

import com.vitech.device_service.dto.request.MaintainSchedule.MaintainScheduleCreationRequest;
import com.vitech.device_service.dto.request.MaintainSchedule.MaintainScheduleUpdateRequest;
import com.vitech.device_service.dto.response.ApiResponse;
import com.vitech.device_service.dto.response.MaintainScheduleResponse;
import com.vitech.device_service.dto.response.PageResponse;
import com.vitech.device_service.service.MaintainScheduleService;
import jakarta.validation.Valid;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import java.util.Date;

@RestController
@RequestMapping("/maintain-schedules")
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@Slf4j
public class MaintainScheduleController {
    MaintainScheduleService maintainScheduleService;

    @GetMapping
    ApiResponse<PageResponse<MaintainScheduleResponse>> getMaintainSchedule(
            @RequestParam(value = "page", required = false, defaultValue = "1") int page,
            @RequestParam(value = "size", required = false, defaultValue = "6") int size,
            @RequestParam(value = "search", required = false, defaultValue = "") String search,
            @RequestParam(value = "createdStartDate", required = false) @DateTimeFormat(pattern = "dd/MM/yyyy") Date createdStartDate,
            @RequestParam(value = "createdEndDate", required = false) @DateTimeFormat(pattern = "dd/MM/yyyy") Date createdEndDate,
            @RequestParam(value = "maintainStartDate", required = false) @DateTimeFormat(pattern = "dd/MM/yyyy") Date maintainStartDate,
            @RequestParam(value = "maintainEndDate", required = false) @DateTimeFormat(pattern = "dd/MM/yyyy") Date maintainEndDate,
            @RequestParam(value = "deviceDetailId", required = false, defaultValue = "") String deviceDetailId,
            @RequestParam(value = "userId", required = false, defaultValue = "") String userId,
            @RequestParam(value = "status", required = false, defaultValue = "") String status
    ) {
        return ApiResponse.<PageResponse<MaintainScheduleResponse>>builder()
                .result(maintainScheduleService.getMaintainSchedule(page, size,
                        createdStartDate.toInstant(), createdEndDate.toInstant(),
                        maintainStartDate.toInstant(), maintainEndDate.toInstant(),
                        deviceDetailId, userId, status))
                .build();
    }

    @DeleteMapping("/{id}")
    ApiResponse<String> deleteMaintainSchedule(@PathVariable("id")String id) {
        maintainScheduleService.deleteMaintainSchedule(id);
        return ApiResponse.<String>builder()
                .result("Xóa thành công")
                .build();
    }

    @PutMapping("/{id}")
    ApiResponse<MaintainScheduleResponse> updateMaintainSchedule(
            @PathVariable("id")String id,
            @RequestBody @Valid MaintainScheduleUpdateRequest request){
        return ApiResponse.<MaintainScheduleResponse>builder()
                .result(maintainScheduleService.updateMaintainSchedule(id, request))
                .build();
    }

    @PostMapping
    ApiResponse<MaintainScheduleResponse> createMaintainSchedule(
            @RequestBody @Valid MaintainScheduleCreationRequest request) {
        return ApiResponse.<MaintainScheduleResponse>builder()
                .result(maintainScheduleService.createMaintainSchedule(request))
                .build();
    }
}
