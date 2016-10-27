package io.swagger.api;
import io.swagger.model.Error;
import io.swagger.model.Product;
import io.swagger.annotations.*;
import io.swagger.manager.ProductManager;
import io.swagger.manager.ProductManagerImpl;

import org.springframework.http.HttpHeaders;
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


@javax.annotation.Generated(value = "class io.swagger.codegen.languages.SpringCodegen", date = "2016-10-24T14:07:33.320Z")

@Controller
public class ProductsApiController implements ProductsApi {

    public ResponseEntity<List<Product>> productsGet(@ApiParam(value = "Searches for all products with the given string contained in the product descrption.") @RequestParam(value = "searchstring", required = false) String searchstring



,
        @ApiParam(value = "Searches for all products which are more expencive than given value.") @RequestParam(value = "searchmin", required = false) Integer searchmin



,
        @ApiParam(value = "Searches for all products which are less expencive than given value.") @RequestParam(value = "searchmax", required = false) Integer searchmax



,
        @ApiParam(value = "Lists all products with this name.") @RequestParam(value = "name", required = false) String name



) {
    	List<Product> products;
    	ProductManager productManager = ProductManagerImpl.getSingletonMockSuperUgly(); 
    	if (searchstring == null && searchmin == null && searchmax == null)
    	{
    		products = productManager.getProducts();
    	}
    	else
    	{
    		products = productManager.getProductsForSearchValues(searchstring, searchmin, searchmax);
    	}
    	HttpHeaders headers = new HttpHeaders();
        return new ResponseEntity<List<Product>>(products, headers, HttpStatus.FOUND);
    }

    public ResponseEntity<Object> productsIdDelete(
@ApiParam(value = "ID of Product.",required=true ) @PathVariable("id") Integer id


) {
    	ProductManager productManager = ProductManagerImpl.getSingletonMockSuperUgly();    	
    	productManager.deleteProductById(id);
        return new ResponseEntity<Object>(HttpStatus.OK);
    }

    public ResponseEntity<Object> productsIdGet(
@ApiParam(value = "ID of Product.",required=true ) @PathVariable("id") Integer id


) {
    	ProductManager productManager = ProductManagerImpl.getSingletonMockSuperUgly();    	
    	Product p = productManager.getProductById(id);
    	HttpHeaders headers = new HttpHeaders();
        return new ResponseEntity<Object>(p, headers, HttpStatus.OK);
    }

}
