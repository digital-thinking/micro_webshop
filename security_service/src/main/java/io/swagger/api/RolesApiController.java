package io.swagger.api;

import io.swagger.model.Error;
import io.swagger.model.Role;
import io.swagger.annotations.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;


@javax.annotation.Generated(value = "class io.swagger.codegen.languages.SpringCodegen", date = "2016-10-20T14:40:13.830Z")

@RestController
public class RolesApiController {

	@Autowired 
	private RolesApi rolesApi;
	
	@RequestMapping(value = "/roles/{rolelevel}", method = RequestMethod.GET)
    public ResponseEntity<Object> GetRoleByLevel(@ApiParam(value = "The level of the role",required=true) @PathVariable("rolelevel") Integer rolelevel) {
        
		Role role = rolesApi.findOneByLevel(rolelevel);
		
        return new ResponseEntity<Object>(role, HttpStatus.OK);
    }

}
