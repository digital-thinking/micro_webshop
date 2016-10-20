package io.swagger.api;

import io.swagger.model.Products;
import io.swagger.model.Error;

import io.swagger.annotations.*;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;


@javax.annotation.Generated(value = "class io.swagger.codegen.languages.SpringCodegen", date = "2016-10-20T14:33:20.613Z")

@Controller
public class ProductsApiController implements ProductsApi {

    public ResponseEntity<List<Products>> productsGet(@ApiParam(value = "Searches for all products with the given string contained in the product descrption.") @RequestParam(value = "searchstring", required = false) String searchstring



,
        @ApiParam(value = "Searches for all products which are more expencive than given value.") @RequestParam(value = "searchmin", required = false) Integer searchmin



,
        @ApiParam(value = "Searches for all products which are less expencive than given value.") @RequestParam(value = "searchmax", required = false) Integer searchmax



,
        @ApiParam(value = "Lists all products with this name.") @RequestParam(value = "name", required = false) String name



) {
        // do some magic!
        return new ResponseEntity<List<Products>>(HttpStatus.OK);
    }

    public ResponseEntity<Object> productsIdGet(
@ApiParam(value = "ID of Product.",required=true ) @PathVariable("id") Integer id


) {
        // do some magic!
        return new ResponseEntity<Object>(HttpStatus.OK);
    }

    public ResponseEntity<Object> productsIdPost(
@ApiParam(value = "ID of Product.",required=true ) @PathVariable("id") Integer id


,
        @ApiParam(value = "Delete product.") @RequestParam(value = "delete", required = false) Integer delete



) {
        // do some magic!
        return new ResponseEntity<Object>(HttpStatus.OK);
    }

}
