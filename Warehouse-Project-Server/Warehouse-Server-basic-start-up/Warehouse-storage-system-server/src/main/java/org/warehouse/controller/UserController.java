package org.warehouse.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.annotation.CurrentSecurityContext;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.warehouse.model.request.UserRequest;
import org.warehouse.model.responce.UserDataResponse;
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

    @GetMapping("data")
    public ResponseEntity<UserDataResponse> getUserData(@CurrentSecurityContext(expression = "authentication") Authentication authentication) {
        return ResponseEntity.ok(userService.getUserData(authentication.getName()));//In this case the name is the email of the use
    }
}
