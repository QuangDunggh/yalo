package com.pqd.yalo.controller;

import java.util.List;

import com.pqd.yalo.domain.request.UserRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.pqd.yalo.model.User;
import com.pqd.yalo.repository.UserRepository;
import com.pqd.yalo.service.UserService;

import lombok.RequiredArgsConstructor;

import javax.validation.Valid;

@RestController
@RequestMapping("api/v1/user")
@RequiredArgsConstructor
public class UserController {
     
    private final UserService userService;


    @GetMapping
    public ResponseEntity<?> getListUser() {
        List<User> listUser = userService.findAll();
        return ResponseEntity.status(HttpStatus.OK).body(listUser);
    }

    @PostMapping("/save")
    public ResponseEntity<?> save(@Valid @RequestBody UserRequest userRequest) {
        return ResponseEntity.status(HttpStatus.CREATED).body(userService.save(userRequest));
    }
}
