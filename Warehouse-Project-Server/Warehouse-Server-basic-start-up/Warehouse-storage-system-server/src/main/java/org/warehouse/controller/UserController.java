package org.warehouse.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.warehouse.model.request.UserRequest;
import org.warehouse.model.responce.UserResponse;
import org.warehouse.service.UserService;

@RestController
@RequestMapping("/api/vi/user")
@RequiredArgsConstructor

public class UserController {
    final UserService userService;
    @GetMapping
    public ResponseEntity<UserResponse>getUserData(@RequestBody UserRequest request) {
    return ResponseEntity.ok(userService.getUserbyemail(request.getEmail()));
    }

}
