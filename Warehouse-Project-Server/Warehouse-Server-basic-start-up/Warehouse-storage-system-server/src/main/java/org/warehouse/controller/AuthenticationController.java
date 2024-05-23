package org.warehouse.controller;

import org.warehouse.model.request.AuthenticationRequest;
import org.warehouse.model.request.RegistrationRequest;
import org.warehouse.model.responce.AuthenticationResponse;
import org.warehouse.service.AuthenticationService;
import org.warehouse.service.RegisterService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/vi/auth")
@RequiredArgsConstructor
public class AuthenticationController {

    private final AuthenticationService authenticationService;
    private final RegisterService registerService;

    @PostMapping("/authenticate")
    public ResponseEntity<AuthenticationResponse> authenticate(
            @RequestBody AuthenticationRequest request
    ) {
        return ResponseEntity.ok(authenticationService.authenticate(request));
    }

    @PostMapping("/register")
    public ResponseEntity<AuthenticationResponse> registerUser(
            @RequestBody RegistrationRequest request
    ) {
        AuthenticationResponse response = registerService.registerUser(request);
        if(response == null){
            return ResponseEntity.status(HttpStatus.SEE_OTHER).body(null);
        }
        return ResponseEntity.ok(response);
    }
}