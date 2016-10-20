package io.swagger.api;

import io.swagger.model.Category;
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

@javax.annotation.Generated(value = "class io.swagger.codegen.languages.SpringCodegen", date = "2016-10-20T13:50:47.978Z")

@Api(value = "categories", description = "the categories API")
public interface CategoriesApi {

    @ApiOperation(value = "List of Categories", notes = "List of all Categories from the webshop ", response = Category.class, responseContainer = "List", tags={  })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "A Category", response = Category.class),
        @ApiResponse(code = 200, message = "Unexpected error", response = Category.class) })
    @RequestMapping(value = "/categories",
        method = RequestMethod.GET)
    ResponseEntity<List<Category>> categoriesGet(@ApiParam(value = "Searches for all products with the given name.") @RequestParam(value = "name", required = false) String name



);


    @ApiOperation(value = "Category", notes = "A Category of the shop ", response = Object.class, tags={  })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "A category", response = Object.class),
        @ApiResponse(code = 200, message = "Unexpected error", response = Object.class) })
    @RequestMapping(value = "/categories/{id}",
        method = RequestMethod.GET)
    ResponseEntity<Object> categoriesIdGet(
@ApiParam(value = "ID of Category.",required=true ) @PathVariable("id") Integer id


);


    @ApiOperation(value = "", notes = "Update Category ", response = Object.class, tags={  })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "Category deleted", response = Object.class),
        @ApiResponse(code = 200, message = "Unexpected error", response = Object.class) })
    @RequestMapping(value = "/categories/{id}",
        method = RequestMethod.POST)
    ResponseEntity<Object> categoriesIdPost(
@ApiParam(value = "ID of Category.",required=true ) @PathVariable("id") Integer id


,@ApiParam(value = "Delete Category.") @RequestParam(value = "delete", required = false) Integer delete



);

}
