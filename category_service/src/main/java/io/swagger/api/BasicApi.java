package io.swagger.api;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import io.swagger.model.Category;

@Api(value = "status", description = "the status API")
public interface BasicApi {

	    @ApiOperation(value = "get status", notes = "", response = Void.class, tags={  })
	    @ApiResponses(value = { 
	        @ApiResponse(code = 200, message = "sucess", response = Void.class),
	        @ApiResponse(code = 500, message = "failed", response = Void.class) })
	    @RequestMapping(value = "/status",
	        method = RequestMethod.GET)
	    ResponseEntity<Void> status(
	);

}
