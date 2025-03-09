package com.vitech.identity_service.service;

import com.vitech.identity_service.dto.request.UserChangePasswordRequest;
import com.vitech.identity_service.dto.request.UserCreationRequest;
import com.vitech.identity_service.dto.request.UserUpdateRequest;
import com.vitech.identity_service.dto.response.PageResponse;
import com.vitech.identity_service.dto.response.UserResponse;
import com.vitech.identity_service.entity.User;
import com.vitech.identity_service.enums.ErrorCode;
import com.vitech.identity_service.exception.AppException;
import com.vitech.identity_service.mapper.UserMapper;
import com.vitech.identity_service.repository.UserRepository;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.security.access.prepost.PostAuthorize;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.HashSet;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@Slf4j
public class UserService {
    UserRepository userRepository;
    UserMapper userMapper;
    PasswordEncoder passwordEncoder;

    public UserResponse createUser(UserCreationRequest request, String role) {

        User user = userMapper.toUser(request);

        try {
            user = userRepository.save(user);
        } catch (DataIntegrityViolationException exception) {
            throw new AppException(ErrorCode.EXISTED);
        }

        return userMapper.toUserResponse(user);
    }

    public UserResponse getMyInfo() {
        var context = SecurityContextHolder.getContext();
        String email = context.getAuthentication().getName();

        User user = userRepository.findByEmail(email).orElseThrow(
                () -> new AppException(ErrorCode.NOT_EXISTED));

        return userMapper.toUserResponse(user);
    }

    @PreAuthorize("hasRole('EMPLOYEE')")
    public PageResponse<UserResponse> getUsers(int page, int size, String search, String role) {
        Sort sort = Sort.by(Sort.Direction.ASC, "username").ascending();

        Pageable pageable = PageRequest.of(page - 1, size, sort);

        Page<User> pageData;

        var priorityRole = getPriorityRole(role.toLowerCase());

        if (StringUtils.hasLength(search))
            pageData = userRepository.findByRoles_SizeAndSearch(priorityRole, search, pageable);
        else
            pageData = userRepository.findByRoles_Size(priorityRole, pageable);
        return PageResponse.<UserResponse>builder()
                .currentPage(page)
                .totalPages(pageData.getTotalPages())
                .pageSize(size)
                .totalElements(pageData.getTotalElements())
                .data(pageData.getContent().stream().map(userMapper::toUserResponse).toList())
                .build();
    }

    private int getPriorityRole(String role) {
        return switch (role) {
            case "employer" -> 4;
            case "manager" -> 3;
            case "employee" -> 2;
            case "customer" -> 1;
            default -> throw new IllegalArgumentException("Invalid role: " + role);
        };
    }

    public boolean existedUserByEmail(String email) {
        return userRepository.existsByEmail(email);
    }

    public UserResponse getUser(String id) {
        return userMapper.toUserResponse(userRepository.findById(id).orElseThrow(() -> new AppException(ErrorCode.NOT_EXISTED)));
    }

    public UserResponse getUserByGmail(String email) {
        return userRepository.findByEmail(email)
                .map(userMapper::toUserResponse)
                .orElse(null);
    }

    @PostAuthorize("returnObject.email == authentication.name or hasRole('EMPLOYEE')")
    public UserResponse updateUser(String id, UserUpdateRequest request) {
        User user = userRepository.findById(id).orElseThrow(() -> new AppException(ErrorCode.NOT_EXISTED));

        userMapper.updateUser(user, request);

        return userMapper.toUserResponse(userRepository.save(user));
    }

    @PostAuthorize("returnObject.email == authentication.name or hasRole('EMPLOYEE')")
    public UserResponse changePassword(String id, UserChangePasswordRequest request) {
        User user = userRepository.findById(id).orElseThrow(() -> new AppException(ErrorCode.NOT_EXISTED));

        if (!passwordEncoder.matches(request.getCurrentPassword(), user.getPassword()))
            throw new AppException(ErrorCode.PASSWORD_INCORRECT);

        user.setPassword(passwordEncoder.encode(request.getNewPassword()));

        return userMapper.toUserResponse(userRepository.save(user));
    }
}
