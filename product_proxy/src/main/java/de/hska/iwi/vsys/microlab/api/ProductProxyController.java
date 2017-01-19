package de.hska.iwi.vsys.microlab.api;

import java.util.ArrayList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.ApiParam;

@RestController
@EnableCircuitBreaker
public class ProductProxyController {

	@Autowired
	private ProductClient productClient;

	@Autowired
	private CategoryClient categoryClient;

	@RequestMapping(value = "/products", method = RequestMethod.GET)
	public ResponseEntity<Iterable<ProductCategoryDTO>> getProducts(
			@ApiParam(value = "Searches for all products with the given string contained in the product descrption.") @RequestParam(value = "searchstring", required = false) String searchstring,
			@ApiParam(value = "Searches for all products which are more expencive than given value.") @RequestParam(value = "searchmin", required = false) Double searchmin,
			@ApiParam(value = "Searches for all products which are less expencive than given value.") @RequestParam(value = "searchmax", required = false) Double searchmax,
			@ApiParam(value = "Lists all products with this name.") @RequestParam(value = "name", required = false) String name) {
		// TODO return ProductCategoryDTO
		ArrayList<ProductCategoryDTO> categoryDTOs = new ArrayList<>();
		ProductCategoryDTO dto = null;
		for (Product p : productClient.getProducts(searchmin, searchmax, name, searchstring)) {
			if (p != null) {
				Category c = categoryClient.getCategory(p.getCategory());
				if (c != null && c.getId() != null) {
					dto = new ProductCategoryDTO(p, c);
					categoryDTOs.add(dto);
				}
			}
		}

		return new ResponseEntity<Iterable<ProductCategoryDTO>>(categoryDTOs, HttpStatus.OK);
	}

	@RequestMapping(value = "/products/{productId}", method = RequestMethod.GET)
	public ResponseEntity<ProductCategoryDTO> getProducts(@PathVariable Long productId) {
		ProductCategoryDTO dto = null;
		Product p = productClient.getProduct(productId);
		if (p != null) {
			Category c = categoryClient.getCategory(p.getCategory());
			if (c != null && c.getId() != null) {
				dto = new ProductCategoryDTO(p, c);
			}
		}

		return new ResponseEntity<>(dto, HttpStatus.OK);
	}

	@RequestMapping(value = "/products", method = RequestMethod.POST)
	public ResponseEntity<Object> AddUser(
			@ApiParam(value = "The product that will be added") @RequestBody ProductCategoryDTO productCategoryDTO) {
		Category createdOrExistingCat = categoryClient.addCategory(productCategoryDTO.getCategory());
		if (createdOrExistingCat == null) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Failed to create Category " + productCategoryDTO.getCategory());
		}
		productCategoryDTO.setCategory(createdOrExistingCat);
		Product createdOrExistingProd = productClient.addProduct(Product.fromProductDTO(productCategoryDTO));
		if (createdOrExistingProd == null) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Failed to create Product " + productCategoryDTO);
		}
		productCategoryDTO = new ProductCategoryDTO(createdOrExistingProd, createdOrExistingCat);
		return new ResponseEntity<Object>(productCategoryDTO, HttpStatus.OK);
	}
	
	@RequestMapping(value = "/categories", method = RequestMethod.GET)
	public ResponseEntity<Iterable<Category>> GetCategories() {
		ArrayList<Category> categories = new ArrayList<>();
		
		for (Category c : categoryClient.getCategorys()){
			categories.add(c);
		}

		return new ResponseEntity<Iterable<Category>>(categories, HttpStatus.OK);
	}
	
	@RequestMapping(value = "/categories", method = RequestMethod.POST)
	public ResponseEntity<Object> AddCategory(
			@ApiParam(value = "The category to add", required = true) @RequestBody Category category) {
		Category saved = categoryClient.addCategory(category);
		
		return new ResponseEntity<Object>(saved, HttpStatus.OK);
	}
}
