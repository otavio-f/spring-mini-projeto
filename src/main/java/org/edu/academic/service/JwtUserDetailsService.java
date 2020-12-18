package org.edu.academic.service;

import java.util.ArrayList;
import java.util.List;

import org.edu.academic.model.Role;
import org.edu.academic.model.Usuario;
import org.edu.academic.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class JwtUserDetailsService implements UserDetailsService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Usuario user = usuarioRepository.findByUsername(username);
		
		if(user==null)
			throw new UsernameNotFoundException("Cannot find any user named <" + username + "> in the database!");
		
		if (user.getUsername().equals(username)) {
			return new User(username, user.getPassword(), new ArrayList<GrantedAuthority>(user.getRoles()));
			//return new User(username, user.getPassword(), new ArrayList<>());
		} else {
			throw new UsernameNotFoundException("User not found with username: " + username);
		}
	}
    
}
