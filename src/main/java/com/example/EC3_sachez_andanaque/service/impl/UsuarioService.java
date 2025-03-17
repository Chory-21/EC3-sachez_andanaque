package com.example.EC3_sachez_andanaque.service.impl;

import com.example.EC3_sachez_andanaque.service.IUsuarioService;
import org.springframework.stereotype.Service;
import com.example.EC3_sachez_andanaque.model.Usuario;
import com.example.EC3_sachez_andanaque.repository.UsuarioRepository;

@Service
public class UsuarioService implements IUsuarioService {
    private final UsuarioRepository usuarioRepository;
    public UsuarioService(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }
    @Override
    public Usuario obtenerUsuarioxNomusuario(String nomusuario) {
        return usuarioRepository.findByNomusuario(nomusuario);
    }
}
