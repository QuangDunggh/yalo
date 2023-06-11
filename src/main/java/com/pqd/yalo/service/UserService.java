package com.pqd.yalo.service;

import java.util.List;
import java.util.Optional;

import com.pqd.yalo.domain.request.UserRequest;
import com.pqd.yalo.model.User;

public interface UserService {

    List<User> findAll();

    Optional<User> findById(Integer id);

    User save(UserRequest user);

}
