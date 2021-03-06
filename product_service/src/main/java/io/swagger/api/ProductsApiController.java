package io.swagger.api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import io.swagger.annotations.ApiParam;
import io.swagger.model.Product;


@javax.annotation.Generated(value = "class io.swagger.codegen.languages.SpringCodegen", date = "2016-10-24T14:07:33.320Z")

@Controller
public class ProductsApiController {
	
	@Autowired
	private ProductsApi productsApi;
	
	@RequestMapping(value = "/products/{productId}", method = RequestMethod.GET)
	public ResponseEntity<Object> GetProductById(@ApiParam(value = "The id of the product",required=true) @PathVariable("productId") Integer productId){
		
		Product product = productsApi.findOne(productId);		
		return new ResponseEntity<Object>(product, HttpStatus.OK);
	}
	
	@RequestMapping(value = "/products/{productId}", method = RequestMethod.DELETE)
	public ResponseEntity<Object> DeleteProductById(@ApiParam(value = "The id of the product",required=true) @PathVariable("productId") Integer productId){
		
		productsApi.delete(productId);		
		return new ResponseEntity<Object>(HttpStatus.OK);
	}
	
	@RequestMapping(value = "/products", method = RequestMethod.GET)
	public ResponseEntity<Object> GetProducts(@ApiParam(value = "Searches for all products with the given string contained in the product descrption.") @RequestParam(value = "searchstring", required = false) String searchstring,
	        @ApiParam(value = "Searches for all products which are more expencive than given value.") @RequestParam(value = "searchmin", required = false) Double searchmin,
	        @ApiParam(value = "Searches for all products which are less expencive than given value.") @RequestParam(value = "searchmax", required = false) Double searchmax,
	        @ApiParam(value = "Lists all products with this name.") @RequestParam(value = "name", required = false) String name) 
    {
		if (searchmin == null) searchmin = 0.0;
		if (searchmax == null) searchmax = Double.MAX_VALUE;
		if (name == null) name = "%";
		if (searchstring == null) searchstring = "%";
		return new ResponseEntity<Object>(productsApi.findByPriceBetweenAndNameLikeAndDetailsLike(searchmin, searchmax, name, searchstring), HttpStatus.OK);				
	}
	
	
	
	
	@RequestMapping(value = "/products", produces = { "application/json" }, consumes = { "application/json" }, method = RequestMethod.POST)
    public ResponseEntity<Object> AddProduct(@ApiParam(value = "The product that will be added") @RequestBody Product product) {		
		Product saved = productsApi.save(product);		
		return new ResponseEntity<Object>(saved, HttpStatus.OK);
	}	
	
	@RequestMapping(value = "/products/{categoryId}", method = RequestMethod.DELETE)
	public ResponseEntity<Object> DeleteProductsByCategory(@ApiParam(value = "The id of the categories",required=true) @PathVariable("categoryId") Integer categoryId){
		
		productsApi.deleteByCategory(categoryId);		
		return new ResponseEntity<>(HttpStatus.OK);
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	// #################### MOCKUP METHODEN ####################

//    public ResponseEntity<List<Product>> productsGet(@ApiParam(value = "Searches for all products with the given string contained in the product descrption.") @RequestParam(value = "searchstring", required = false) String searchstring,
//        @ApiParam(value = "Searches for all products which are more expencive than given value.") @RequestParam(value = "searchmin", required = false) Integer searchmin,
//        @ApiParam(value = "Searches for all products which are less expencive than given value.") @RequestParam(value = "searchmax", required = false) Integer searchmax,
//        @ApiParam(value = "Lists all products with this name.") @RequestParam(value = "name", required = false) String name) 
//    {
//    	List<Product> products;
//    	ProductManager productManager = ProductManagerImpl.getSingletonMockSuperUgly(); 
//    	if (searchstring == null && searchmin == null && searchmax == null)
//    	{
//    		products = productManager.getProducts();
//    	}
//    	else
//    	{
//    		products = productManager.getProductsForSearchValues(searchstring, searchmin, searchmax);
//    	}
//    	HttpHeaders headers = new HttpHeaders();
//        return new ResponseEntity<List<Product>>(products, headers, HttpStatus.FOUND);
//    }
//
//    public ResponseEntity<Object> productsIdDelete(@ApiParam(value = "ID of Product.",required=true ) @PathVariable("id") Integer id) {
//    	ProductManager productManager = ProductManagerImpl.getSingletonMockSuperUgly();    	
//    	productManager.deleteProductById(id);
//        return new ResponseEntity<Object>(HttpStatus.OK);
//    }
//
//    public ResponseEntity<Object> productsIdGet(@ApiParam(value = "ID of Product.",required=true ) @PathVariable("id") Integer id) {
//    	ProductManager productManager = ProductManagerImpl.getSingletonMockSuperUgly();    	
//    	Product p = productManager.getProductById(id);
//    	HttpHeaders headers = new HttpHeaders();
//        return new ResponseEntity<Object>(p, headers, HttpStatus.OK);
//    }

}
