package org.edu.academic.repository;

import org.edu.academic.model.Role;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface RoleRepository extends MongoRepository<Role, String> {    
}
