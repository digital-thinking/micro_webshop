package io.swagger.api;

import javax.transaction.Transactional;

import io.swagger.annotations.Api;
import io.swagger.model.User;

@javax.annotation.Generated(value = "class io.swagger.codegen.languages.SpringCodegen", date = "2016-10-20T14:40:13.830Z")

@Api(value = "users", description = "the users API")
public interface UsersApi extends org.springframework.data.repository.CrudRepository<User, Integer>{

	User findOneByUsername(String username);
	
	@Transactional
	Long deleteByUsername(String username);
}