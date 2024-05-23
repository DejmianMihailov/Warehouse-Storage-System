package org.warehouse.service;

import org.warehouse.config.SecurityConfig;
import org.warehouse.model.request.AuthenticationRequest;
import org.warehouse.model.responce.AuthenticationResponse;
import org.warehouse.persistence.User;
import org.warehouse.repository.UserRepository;
import org.warehouse.type.Role;
import lombok.RequiredArgsConstructor;
import org.springframework.data.convert.ReadingConverter;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.warehouse.model.request.RegistrationRequest;

@Service
@Transactional
@ReadingConverter
@RequiredArgsConstructor
public class RegisterService {

    private final UserRepository userRepository;
    private final AuthenticationService authenticationService;
    private final SecurityConfig securityConfig;
    public AuthenticationResponse registerUser(RegistrationRequest request) {

        var user = userRepository.findByEmail(request.getEmail());
        if(user.isPresent()){
            //email already taken
            return null;
        }

        User toRegister = new User();
        toRegister.setEmail(request.getEmail());
        toRegister.setPassword(securityConfig.passwordEncoder().encode(request.getPassword()));
        toRegister.setFirstname(request.getFirstName());
        toRegister.setLastname(request.getLastName());
        toRegister.setRole(Role.USER);
        userRepository.save(toRegister);

        return authenticationService.authenticate(
                new AuthenticationRequest(request.getEmail(),request.getPassword()));
    }
}
