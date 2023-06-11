package com.pqd.yalo.service.impl;

import java.util.List;
import java.util.Optional;

import com.pqd.yalo.domain.mapper.UserMapper;
import com.pqd.yalo.domain.request.UserRequest;
import org.springframework.stereotype.Service;

import com.pqd.yalo.model.User;
import com.pqd.yalo.repository.UserRepository;
import com.pqd.yalo.service.UserService;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    private final UserMapper userMapper;

    @Override
    public List<User> findAll() {
        return userRepository.findAll();
    }

    @Override
    public Optional<User> findById(Integer id) {
       return userRepository.findById(id);
    }

    @Override
    public User save(UserRequest userRequest) {
        User user = userMapper.userRequestToUser(userRequest);
        System.out.println(userRequest);
        userRepository.save(user);

        return user;
    }

}
