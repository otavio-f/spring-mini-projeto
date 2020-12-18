package org.edu.academic.dto;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@EqualsAndHashCode
public class UsuarioDTO {
    private String id;
    private String username;
    private String password;
    
	public String getUsername() {
		return this.username;
	}
}
