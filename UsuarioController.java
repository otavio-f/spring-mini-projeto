package org.edu.academic.controller;

import java.util.ArrayList;

import org.edu.academic.dto.UsuarioDTO;
import org.edu.academic.model.Role;
import org.edu.academic.model.Usuario;
import org.edu.academic.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin
public class UsuarioController {
    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
	PasswordEncoder encoder;

    @PostMapping("/signup")
    @ResponseBody
    public ResponseEntity<Usuario> createUsuario(@RequestBody UsuarioDTO usuario) {
        try {
            return ResponseEntity
                .ok(usuarioRepository.save(
                    new Usuario(usuario.getId(), 
                    usuario.getUsername(), 
                    encoder.encode(usuario.getPassword()), new ArrayList<Role>())
                    )
                );
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
    
}
