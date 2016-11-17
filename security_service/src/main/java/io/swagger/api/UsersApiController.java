package io.swagger.api;

import io.swagger.model.Error;
import io.swagger.model.User;
import io.swagger.annotations.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
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

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;


@javax.annotation.Generated(value = "class io.swagger.codegen.languages.SpringCodegen", date = "2016-10-20T14:40:13.830Z")

@RestController
public class UsersApiController{
	
	@Autowired
	private UsersApi usersApi;

	@RequestMapping(value = "/users/{username}", method = RequestMethod.GET)
    public ResponseEntity<Object> GetUserByUsername(@ApiParam(value = "The username of the user",required=true) @PathVariable("username") String username) {
        User user = usersApi.findOneByUsername(username);
        
        if(user != null){
        	return new ResponseEntity<Object>(user, HttpStatus.OK);
        } else {
        	return new ResponseEntity<Object>(HttpStatus.NO_CONTENT);
        }
    }
	
	@RequestMapping(value = "/users/{username}", method = RequestMethod.DELETE)
    public ResponseEntity<Object> DeleteUserByUsername(@ApiParam(value = "The username of the user",required=true) @PathVariable("username") String username) {
		usersApi.deleteByUsername(username);
        
        return new ResponseEntity<Object>(HttpStatus.OK);
    }
	
	@RequestMapping(value = "/users", produces = { "application/json" }, consumes = { "application/json" }, method = RequestMethod.POST)
    public ResponseEntity<Void> AddUser(@ApiParam(value = "The user that will be added") @RequestBody User user) {
		
		// Da gibt's irgendwie Probleme mit der id, da kann man ihm komischerweise immer nur 0 mitgeben sonst ist es kein "default value" und er meckert
		usersApi.save(user);
		
        return new ResponseEntity<Void>(HttpStatus.OK);
    }

}
