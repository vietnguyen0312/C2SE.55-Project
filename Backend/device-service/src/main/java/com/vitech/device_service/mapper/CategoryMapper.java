package com.vitech.device_service.mapper;

import com.vitech.device_service.dto.request.CategoryCreationRequest;
import com.vitech.device_service.dto.request.ComponentDetail.ComponentDetailCreationRequest;
import com.vitech.device_service.dto.request.ComponentDetail.ComponentDetailUpdateRequest;
import com.vitech.device_service.dto.response.CategoryResponse;
import com.vitech.device_service.dto.response.ComponentDetailResponse;
import com.vitech.device_service.entity.Category;
import com.vitech.device_service.entity.ComponentDetail;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface CategoryMapper {
    Category toCategory(CategoryCreationRequest request);

    CategoryResponse toCategoryResponse(Category category);
}
