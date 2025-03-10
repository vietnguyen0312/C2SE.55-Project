package com.vitech.device_service.service;

import com.vitech.device_service.dto.request.CategoryCreationRequest;
import com.vitech.device_service.dto.response.CategoryResponse;
import com.vitech.device_service.mapper.CategoryMapper;
import com.vitech.device_service.repository.CategoryRepository;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@Slf4j
public class CategoryService {
    CategoryRepository categoryRepository;
    CategoryMapper categoryMapper;

    public List<CategoryResponse> getCategory() {
        return categoryRepository.findAll().stream().map(categoryMapper :: toCategoryResponse).toList();
    }

    public CategoryResponse createCategory(CategoryCreationRequest request) {
        return categoryMapper.toCategoryResponse(categoryRepository
                .save(categoryMapper.toCategory(request)));
    }
}
