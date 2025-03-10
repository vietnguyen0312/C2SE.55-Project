package com.vitech.device_service.controller;

import com.vitech.device_service.dto.request.ActivityLogCreationRequest;
import com.vitech.device_service.dto.response.ActivityLogResponse;
import com.vitech.device_service.dto.response.ApiResponse;
import com.vitech.device_service.dto.response.PageResponse;
import com.vitech.device_service.service.ActivityLogService;
import jakarta.validation.Valid;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import java.util.Date;

@RestController
@RequestMapping("/activity-logs")
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@Slf4j
public class ActivityLogController {
    ActivityLogService activityLogService;

    @GetMapping
    ApiResponse<PageResponse<ActivityLogResponse>> getActivityLogs(
            @RequestParam(value = "page", required = false, defaultValue = "1") int page,
            @RequestParam(value = "size", required = false, defaultValue = "6") int size,
            @RequestParam(value = "search", required = false, defaultValue = "") String search,
            @RequestParam(value = "startDate", required = false) @DateTimeFormat(pattern = "dd/MM/yyyy") Date startDate,
            @RequestParam(value = "endDate", required = false) @DateTimeFormat(pattern = "dd/MM/yyyy") Date endDate,
            @RequestParam(value = "scheduleMaintainId", required = false, defaultValue = "") String scheduleMaintainId
    ){
        return ApiResponse.<PageResponse<ActivityLogResponse>>builder()
                .result(activityLogService.getActivityLog(search, startDate.toInstant(),
                        endDate.toInstant(), scheduleMaintainId, page, size))
                .build();
    }

    @GetMapping("/{id}")
    ApiResponse<ActivityLogResponse> getActivityLogById(@PathVariable("id") String id) {
        return ApiResponse.<ActivityLogResponse>builder()
                .result(activityLogService.getActivityLogById(id))
                .build();
    }

    @PostMapping
    ApiResponse<ActivityLogResponse> createActivityLog(@RequestBody @Valid ActivityLogCreationRequest request) {
        return ApiResponse.<ActivityLogResponse>builder()
                .result(activityLogService.createActivityLog(request))
                .build();
    }

    @DeleteMapping("/{id}")
    ApiResponse<String> deleteActivityLog(@PathVariable("id") String id) {
        activityLogService.deleteActivityLog(id);
        return ApiResponse.<String>builder()
                .result("Xóa thành công")
                .build();
    }

}
