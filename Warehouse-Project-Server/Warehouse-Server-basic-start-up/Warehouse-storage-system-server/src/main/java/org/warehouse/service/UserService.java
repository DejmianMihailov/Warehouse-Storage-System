package org.warehouse.service;

import lombok.RequiredArgsConstructor;
import org.springframework.data.convert.ReadingConverter;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.warehouse.model.responce.UserResponse;
import org.warehouse.persistence.User;
import org.warehouse.repository.UserRepository;

@Service
@Transactional
@RequiredArgsConstructor
@ReadingConverter
public class UserService {
    private final UserRepository userRepostory;
    public UserResponse getUserbyemail(final String email)
    {
        User user =  userRepostory.findByEmail(email).get();
        return new UserResponse(user.getId(),user.getFirstname(),user.getLastname(),user.getEmail());
    }
}
