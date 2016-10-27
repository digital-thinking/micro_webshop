package io.swagger.api;

import io.swagger.model.Product;
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

@javax.annotation.Generated(value = "class io.swagger.codegen.languages.SpringCodegen", date = "2016-10-24T14:07:33.320Z")

@Api(value = "products", description = "the products API")
public interface ProductsApi {

    @ApiOperation(value = "List of Products", notes = "List of all Products from the webshop ", response = Product.class, responseContainer = "List", tags={  })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "A product", response = Product.class),
        @ApiResponse(code = 200, message = "Unexpected error", response = Product.class) })
    @RequestMapping(value = "/products",
        method = RequestMethod.GET)
    ResponseEntity<List<Product>> productsGet(@ApiParam(value = "Searches for all products with the given string contained in the product descrption.") @RequestParam(value = "searchstring", required = false) String searchstring



,@ApiParam(value = "Searches for all products which are more expencive than given value.") @RequestParam(value = "searchmin", required = false) Integer searchmin



,@ApiParam(value = "Searches for all products which are less expencive than given value.") @RequestParam(value = "searchmax", required = false) Integer searchmax



,@ApiParam(value = "Lists all products with this name.") @RequestParam(value = "name", required = false) String name



);


    @ApiOperation(value = "", notes = "Altering product ", response = Object.class, tags={  })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "product deleted", response = Object.class),
        @ApiResponse(code = 200, message = "Unexpected error", response = Object.class) })
    @RequestMapping(value = "/products/{id}",
        method = RequestMethod.DELETE)
    ResponseEntity<Object> productsIdDelete(
@ApiParam(value = "ID of Product.",required=true ) @PathVariable("id") Integer id


);


    @ApiOperation(value = "Product", notes = "A Product of the shop ", response = Object.class, tags={  })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "A product", response = Object.class),
        @ApiResponse(code = 200, message = "Unexpected error", response = Object.class) })
    @RequestMapping(value = "/products/{id}",
        method = RequestMethod.GET)
    ResponseEntity<Object> productsIdGet(
@ApiParam(value = "ID of Product.",required=true ) @PathVariable("id") Integer id


);

}
