package io.swagger.api;

import io.swagger.model.Category;

import io.swagger.annotations.*;
import io.swagger.manager.CategoryManager;
import io.swagger.manager.CategoryManagerImpl;

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


@javax.annotation.Generated(value = "class io.swagger.codegen.languages.SpringCodegen", date = "2016-10-25T10:28:45.312Z")

@Controller
public class AddCategoryApiController implements AddCategoryApi {

    public ResponseEntity<Void> addCategoryPost(

@ApiParam(value = "Category that will be added"  ) @RequestBody Category category

) {        
    	CategoryManager categoryManager = CategoryManagerImpl.getSingletonMockSuperUgly();    	
    	categoryManager.addCategory(category);    	
        return new ResponseEntity<Void>(HttpStatus.OK);
    }

}
