package io.swagger.api;

import io.swagger.model.Error;

import io.swagger.annotations.*;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@javax.annotation.Generated(value = "class io.swagger.codegen.languages.SpringCodegen", date = "2016-10-20T14:40:13.830Z")

@Api(value = "deleteUser", description = "the deleteUser API")
public interface DeleteUserApi {

    @ApiOperation(value = "", notes = "Delete a user by ID ", response = Object.class, tags={  })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "User deleted", response = Object.class),
        @ApiResponse(code = 500, message = "Unexpected error", response = Object.class) })
    @RequestMapping(value = "/deleteUser/{id}",
        method = RequestMethod.POST)
    ResponseEntity<Object> deleteUserIdPost(
@ApiParam(value = "ID of User.",required=true ) @PathVariable("id") Integer id


);

}
