package com.example.EC3_sachez_andanaque.service.impl;

import com.example.EC3_sachez_andanaque.service.IUsuarioService;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import com.example.EC3_sachez_andanaque.model.Rol;
import com.example.EC3_sachez_andanaque.model.Usuario;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Service
public class DetalleUsuarioService implements UserDetailsService {
    private final IUsuarioService iUsuarioService;

    public DetalleUsuarioService(IUsuarioService iUsuarioService) {
        this.iUsuarioService = iUsuarioService;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Usuario usuario = iUsuarioService
                .obtenerUsuarioxNomusuario(username);
        return getUserDetails(usuario,
                getAuthorities(usuario.getRoles()));
    }

    public List<GrantedAuthority> getAuthorities(Set<Rol> roles){
        List<GrantedAuthority> authorities = new ArrayList<>();
        for (Rol rol : roles){
            authorities.add(new SimpleGrantedAuthority(
                    "ROLE_"+rol.getNomrol()));
        }
        return  authorities;
    }
    private UserDetails getUserDetails(Usuario usuario,
                                       List<GrantedAuthority>
                                               authorities){
        return new User(
                usuario.getNomusuario(),
                usuario.getPassword(),
                usuario.getActivo(),
                true,
                true,
                true, authorities);
    }
}