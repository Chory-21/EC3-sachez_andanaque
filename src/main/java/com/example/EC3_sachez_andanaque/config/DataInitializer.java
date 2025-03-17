package com.example.EC3_sachez_andanaque.config;

import com.example.EC3_sachez_andanaque.model.Rol;
import com.example.EC3_sachez_andanaque.model.Usuario;
import com.example.EC3_sachez_andanaque.repository.RolRepository;
import com.example.EC3_sachez_andanaque.repository.UsuarioRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.util.HashSet;
import java.util.Set;

@Configuration
public class DataInitializer {

    private final BCryptPasswordEncoder passwordEncoder;

    public DataInitializer(BCryptPasswordEncoder passwordEncoder) {
        this.passwordEncoder = passwordEncoder;
    }

    @Bean
    public CommandLineRunner initData(UsuarioRepository usuarioRepository,
                                      RolRepository rolRepository) {
        return args -> {
            // Check if we already have roles
            if (rolRepository.count() == 0) {
                // Create roles
                Rol rolAdmin = new Rol();
                rolAdmin.setNomrol("ADMIN");
                rolRepository.save(rolAdmin);

                Rol rolSupervisor = new Rol();
                rolSupervisor.setNomrol("SUPERVISOR");
                rolRepository.save(rolSupervisor);

                Rol rolJefe = new Rol();
                rolJefe.setNomrol("JEFE");
                rolRepository.save(rolJefe);

                System.out.println("Created roles: ADMIN, SUPERVISOR, JEFE");

                // Create admin user
                createUser(usuarioRepository, "admin", rolAdmin);

                // Create supervisor user
                createUser(usuarioRepository, "supervisor", rolSupervisor);

                // Create jefe user
                createUser(usuarioRepository, "jefe", rolJefe);
            }
        };
    }

    private void createUser(UsuarioRepository usuarioRepository, String username, Rol rol) {
        Usuario user = new Usuario();
        user.setNomusuario(username);
        user.setNombres(capitalize(username));
        user.setApellidos("Usuario");
        user.setEmail(username + "@example.com");
        // Password is username + "123"
        user.setPassword(passwordEncoder.encode(username + "123"));
        user.setActivo(true);

        Set<Rol> roles = new HashSet<>();
        roles.add(rol);
        user.setRoles(roles);

        usuarioRepository.save(user);

        System.out.println("Created user: " + username + " / " + username + "123");
    }

    private String capitalize(String str) {
        if (str == null || str.isEmpty()) {
            return str;
        }
        return str.substring(0, 1).toUpperCase() + str.substring(1);
    }
}