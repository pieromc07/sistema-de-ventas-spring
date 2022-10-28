package com.app.sellingsystem.database;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.app.sellingsystem.persistence.model.Role;
import com.app.sellingsystem.persistence.model.User;
import com.app.sellingsystem.persistence.repository.RoleRepository;
import com.app.sellingsystem.persistence.repository.UserRepository;
import com.app.sellingsystem.security.PasswordEncoder;

import lombok.extern.java.Log;

@Log
@Configuration
public class Seeder {
    private static final String ADMIN_EMAIL = "admin@admin.com";
    private static final String ADMIN_PASSWORD = "abcd1234#";

    @Autowired
    protected PasswordEncoder passwordEncoder;

    @Autowired
    protected UserRepository userRepository;

    @Autowired
    protected RoleRepository roleRepository;

    @Bean
    CommandLineRunner initData(){
        return args -> {
            log.info("Cargando los roles en la base de datos");
            createRoles();
            log.info("Cargando Usuario administrador en la base de datos\n" +
                    "\nEMAIL : "+ADMIN_EMAIL+"\n\tPASSWORD : "+ADMIN_PASSWORD);
            createAdminUser();

        };
    }

    private void createAdminUser() {
        if (userRepository.count() == 0) {
            userRepository.save(
                    buildUser(ADMIN_EMAIL, ERole.ADMIN));
            log.info("Usuario administrador creado ....");
        }

    }

    private User buildUser(String email, ERole role) {
        Role roleEntity = roleRepository.findByDescription(role.getFullRoleName());
        if (roleEntity == null) {
           System.out.println("No se encontro el rol");
        }else{
            System.out.println("Se encontro el rol");
        }

        return User.builder()
                .email(email)
                .password(passwordEncoder.encoder().encode(ADMIN_PASSWORD))
                .roles(List.of(roleRepository.findByDescription(role.getFullRoleName())))
                .build();
    }

    private void createRoles(){
        if(roleRepository.count() == 0)
            roleRepository.saveAll(List.of(buildRole(ERole.ADMIN.getFullRoleName()),buildRole(ERole.VENTA.getFullRoleName())));
        log.info("roles creados ....");
    }

    private com.app.sellingsystem.persistence.model.Role buildRole(String role) {
        return com.app.sellingsystem.persistence.model.Role.builder()
                .description(role)
                .build();
    }
}
