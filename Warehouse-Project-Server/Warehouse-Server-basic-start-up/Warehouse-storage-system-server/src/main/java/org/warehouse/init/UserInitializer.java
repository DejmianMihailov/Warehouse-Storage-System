package org.warehouse.init;

import org.warehouse.persistence.User;
import org.warehouse.repository.UserRepository;
import org.warehouse.type.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@Component
public class UserInitializer implements CommandLineRunner {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    @Autowired
    public UserInitializer(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public void run(String... args) throws Exception {
        User user = new User();
        user.setEmail("damyanmihailov@mail.com");
        user.setPassword(passwordEncoder.encode("damyan123456789"));
        user.setRole(Role.USER);
        user.setFirstname("Damyan");
        userRepository.save(user);

        User userAdmin = new User();
        userAdmin.setEmail("DamyanAdmin@mail.com");
        userAdmin.setPassword(passwordEncoder.encode("12345678"));
        userAdmin.setRole(Role.ADMIN);
        userAdmin.setFirstname("DamyanAdmin");
        userRepository.save(userAdmin);

        User userSuperAdmin = new User();
        userSuperAdmin.setEmail("DamyanSuperAdmin@mail.com");
        userSuperAdmin.setPassword(passwordEncoder.encode("12345678"));
        userSuperAdmin.setRole(Role.SUPERADMIN);
        userSuperAdmin.setFirstname("DamyanSupperAdmin");
        userRepository.save(userSuperAdmin);
    }
}
