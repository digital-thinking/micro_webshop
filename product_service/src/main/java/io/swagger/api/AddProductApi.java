package io.swagger.api;

import io.swagger.model.Product;

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

@javax.annotation.Generated(value = "class io.swagger.codegen.languages.SpringCodegen", date = "2016-10-24T14:07:33.320Z")

@Api(value = "addProduct", description = "the addProduct API")
public interface AddProductApi {

    @ApiOperation(value = "Add a new product", notes = "", response = Void.class, tags={  })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "sucess", response = Void.class),
        @ApiResponse(code = 500, message = "failed", response = Void.class) })
    @RequestMapping(value = "/addProduct",
        produces = { "application/json" }, 
        consumes = { "application/json" },
        method = RequestMethod.POST)
    ResponseEntity<Void> addProductPost(

@ApiParam(value = "Product that will be added"  ) @RequestBody Product product

);

}
