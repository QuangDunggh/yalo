package com.pqd.yalo.domain.mapper;

import com.pqd.yalo.domain.request.UserRequest;
import com.pqd.yalo.model.User;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface UserMapper {

    User userRequestToUser(UserRequest userRequest);

    UserRequest userToUserRequest(User user);
}
