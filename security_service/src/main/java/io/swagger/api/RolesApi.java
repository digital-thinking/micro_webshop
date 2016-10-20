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

@Api(value = "roles", description = "the roles API")
public interface RolesApi {

    @ApiOperation(value = "Role", notes = "A Role of the shop ", response = Object.class, tags={  })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "A role", response = Object.class),
        @ApiResponse(code = 500, message = "Unexpected Error", response = Object.class) })
    @RequestMapping(value = "/roles/{rolelevel}",
        method = RequestMethod.GET)
    ResponseEntity<Object> rolesRolelevelGet(
@ApiParam(value = "The level of the role",required=true ) @PathVariable("rolelevel") Integer rolelevel


);

}
