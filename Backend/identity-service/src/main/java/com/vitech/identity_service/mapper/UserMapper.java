package com.vitech.identity_service.mapper;


import com.vitech.identity_service.dto.request.UserCreationRequest;
import com.vitech.identity_service.dto.request.UserUpdateRequest;
import com.vitech.identity_service.dto.response.UserResponse;
import com.vitech.identity_service.entity.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface UserMapper {
    User toUser(UserCreationRequest request);

    void updateUser(@MappingTarget User user, UserUpdateRequest request);

    UserResponse toUserResponse(User user);
}
