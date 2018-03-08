package com.a2r2.api.rest.persistence;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.a2r2.api.rest.model.User;


@Repository(value= "userRepository")
public interface IUserRepository extends JpaRepository<User, String>,
		JpaSpecificationExecutor<User> {

	
	@Query("SELECT f FROM User f WHERE LOWER(f.username) = LOWER(:username)")
	User findByUsername(@Param("username") String username);

}
