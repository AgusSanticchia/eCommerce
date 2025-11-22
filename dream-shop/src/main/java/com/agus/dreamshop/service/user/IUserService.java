package com.agus.dreamshop.service.user;

import com.agus.dreamshop.dto.UserDto;
import com.agus.dreamshop.model.Order;
import com.agus.dreamshop.model.User;
import com.agus.dreamshop.request.CreateUserRequest;
import com.agus.dreamshop.request.UserUpdateRequest;

public interface IUserService {
    User getUserById(Long userId);
    User createUser(CreateUserRequest request);
    User updateUser(Long userId, UserUpdateRequest request);
    void deleteUser(Long userId);

    UserDto convertUserToDto(User user);
}
