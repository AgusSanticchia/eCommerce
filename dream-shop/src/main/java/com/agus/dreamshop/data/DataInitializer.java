package com.agus.dreamshop.data;

import com.agus.dreamshop.model.Role;
import com.agus.dreamshop.model.User;
import com.agus.dreamshop.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.Set;

@Transactional
@Component
@RequiredArgsConstructor
public class DataInitializer implements ApplicationListener<ApplicationReadyEvent> {
    private final UserRepository userRepository;
    private final RoleRepository roleRepository;
    private final PasswordEncoder passwordEncoder;

    @Override

    public void onApplicationEvent(ApplicationReadyEvent event){
        Set<String> defaultRoles = Set.of("ROLE_USER", "ROLE_ADMIN");
        createDefaultRoleIfNotExist(defaultRoles);
        createDefaultUserIfNotExist();
        createDefaultAdminIfNotExist();
    }

    private void createDefaultUserIfNotExist() {
        Role userRole = roleRepository.findByName("ROLE_USER")
                .orElseThrow(() -> new RuntimeException("Role USER not found"));

        for(int i = 1; i <= 5; i++) {
            String defaultEmail = "user" + i + "@email.com";
            if (userRepository.existsByEmail(defaultEmail)) {
                continue;
            }
            User user = new User();
            user.setFirstName("The User");
            user.setLastName("User " + i);
            user.setEmail(defaultEmail);
            user.setPassword(passwordEncoder.encode("123456"));
            user.setRoles(Set.of(userRole));
            userRepository.save(user);
            System.out.println("Default user: " + i + " created.");
        }
    }

    private void createDefaultAdminIfNotExist() {
        Role adminRole = roleRepository.findByName("ROLE_ADMIN")
                .orElseThrow(() -> new RuntimeException("Role ADMIN not found"));

        for(int i = 1; i <= 2; i++) {
            String defaultEmail = "admin" + i + "@email.com";
            if (userRepository.existsByEmail(defaultEmail)) {
                continue;
            }
            User user = new User();
            user.setFirstName("The Admin");
            user.setLastName("Admin " + i);
            user.setEmail(defaultEmail);
            user.setPassword(passwordEncoder.encode("123456"));
            user.setRoles(Set.of(adminRole));
            userRepository.save(user);
            System.out.println("Default admin: " + i + " created.");
        }
    }

    private void createDefaultRoleIfNotExist(Set<String> roles) {
        roles.stream()
                .filter(role -> roleRepository.findByName(role).isEmpty())
                .map(Role::new)
                .forEach(roleRepository::save);
    }
}