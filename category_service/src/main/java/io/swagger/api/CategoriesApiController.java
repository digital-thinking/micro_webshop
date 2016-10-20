package io.swagger.api;

import io.swagger.model.Category;
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


@javax.annotation.Generated(value = "class io.swagger.codegen.languages.SpringCodegen", date = "2016-10-20T13:50:47.978Z")

@Controller
public class CategoriesApiController implements CategoriesApi {

    public ResponseEntity<List<Category>> categoriesGet(@ApiParam(value = "Searches for all products with the given name.") @RequestParam(value = "name", required = false) String name



) {
        // do some magic!
        return new ResponseEntity<List<Category>>(HttpStatus.OK);
    }

    public ResponseEntity<Object> categoriesIdGet(
@ApiParam(value = "ID of Category.",required=true ) @PathVariable("id") Integer id


) {
        // do some magic!
        return new ResponseEntity<Object>(HttpStatus.OK);
    }

    public ResponseEntity<Object> categoriesIdPost(
@ApiParam(value = "ID of Category.",required=true ) @PathVariable("id") Integer id


,
        @ApiParam(value = "Delete Category.") @RequestParam(value = "delete", required = false) Integer delete



) {
        // do some magic!
        return new ResponseEntity<Object>(HttpStatus.OK);
    }

}
