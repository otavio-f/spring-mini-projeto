package org.edu.academic.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.security.core.GrantedAuthority;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@Document(collection = "roles")
public class Role implements GrantedAuthority {
	
	private static final long serialVersionUID = 6402814530474505187L;

	@Id
    private String id;
    
    @Indexed(unique=true)
    private String name;
    
    private String description;

	@Override
	public String getAuthority() {
		return this.name;
	}

}
