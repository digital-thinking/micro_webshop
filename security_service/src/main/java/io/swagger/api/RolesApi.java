package io.swagger.api;

import io.swagger.annotations.Api;
import io.swagger.model.Role;

@javax.annotation.Generated(value = "class io.swagger.codegen.languages.SpringCodegen", date = "2016-10-20T14:40:13.830Z")

@Api(value = "roles", description = "the roles API")
public interface RolesApi extends org.springframework.data.repository.CrudRepository<Role, Integer> {

	Role findOneByLevel(Integer roleLevel);
}
