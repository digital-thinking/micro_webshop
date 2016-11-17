package io.swagger.api;

import io.swagger.model.Category;
import io.swagger.model.Error;
import io.swagger.annotations.*;
import io.swagger.manager.CategoryManager;
import io.swagger.manager.CategoryManagerImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
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
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.util.List;


@javax.annotation.Generated(value = "class io.swagger.codegen.languages.SpringCodegen", date = "2016-10-25T10:28:45.312Z")

@Controller
public class CategoriesApiController {
	
	@Autowired
	private CategoriesApi categoriesApi;
	
	@RequestMapping(value = "/categories/{id}", method = RequestMethod.GET)
    public ResponseEntity<Object> GetCategoryById(@ApiParam(value = "The id of the category",required=true) @PathVariable("id") Integer id) {
		
		categoriesApi.findOne(id);
		
		return new ResponseEntity<Object>(HttpStatus.OK);
	}
	
	@RequestMapping(value = "/categories/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Object> DeleteCategoryById(@ApiParam(value = "The id of the category",required=true) @PathVariable("id") Integer id) {
		categoriesApi.delete(id);
		
		return new ResponseEntity<Object>(HttpStatus.OK);
	}
	
	@RequestMapping(value = "/categories", method = RequestMethod.POST)
    public ResponseEntity<Object> AddCategory(@ApiParam(value = "The id of the category",required=true) @RequestBody Category category) {
		
		// TODO Implementierung
		
		return new ResponseEntity<Object>(HttpStatus.OK);
	}
	
	
	@RequestMapping(value = "/categories", method = RequestMethod.GET)
    public ResponseEntity<Object> GetCategories(@ApiParam(value = "The id of the category",required=false) @PathVariable("name") String name) {
		
		if(name == null){			
			Iterable<Category> allCategories = categoriesApi.findAll();
			
			return new ResponseEntity<Object>(allCategories, HttpStatus.OK);		
		} else {
			Iterable<Category> categories = categoriesApi.findOneByName(name);
			
			return new ResponseEntity<Object>(categories, HttpStatus.OK);
		}
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	// ################### MOCKUP METHODEN ########################


    public ResponseEntity<Object> categoriesIdDelete(
@ApiParam(value = "ID of Category.",required=true ) @PathVariable("id") Integer id


) {
    	CategoryManager categoryManager = CategoryManagerImpl.getSingletonMockSuperUgly();   
    	categoryManager.delCategory(id);
        return new ResponseEntity<Object>(HttpStatus.OK);
    }

    public ResponseEntity<Object> categoriesIdGet(
@ApiParam(value = "ID of Category.",required=true ) @PathVariable("id") Integer id


) {
        
     	CategoryManager categoryManager = CategoryManagerImpl.getSingletonMockSuperUgly();    	
    	Category category = categoryManager.getCategory(id);
    	HttpHeaders headers = new HttpHeaders();
        return new ResponseEntity<>(category, headers, HttpStatus.FOUND);
    }

    public ResponseEntity<Object> categoriesIdPut(
@ApiParam(value = "ID of Category.",required=true ) @PathVariable("id") Integer id


,
        

@ApiParam(value = "Category that will be added"  ) @RequestBody Category category

) {
        // do some magic!
    	CategoryManager categoryManager = CategoryManagerImpl.getSingletonMockSuperUgly();   
    	categoryManager.addCategory(category);        
        return new ResponseEntity<Object>(HttpStatus.OK);
    }

}
