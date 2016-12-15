package de.hska.iwi.vsys.microlab;

import java.util.Collections;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@EnableCircuitBreaker
public class ProductProxyController {

	@Autowired
	private ProductClient productClient;
	
	@Autowired
	private CategoryClient categoryClient;

	@RequestMapping(value = "/products", method = RequestMethod.GET)
	public ResponseEntity<Iterable<ProductCategoryDTO>> getProducts() {
		//TODO return ProductCategoryDTO
		return new ResponseEntity<Iterable<ProductCategoryDTO>>(Collections.emptyList(), HttpStatus.OK);
	}

	@RequestMapping(value = "/products/{productId}", method = RequestMethod.GET)
	public ResponseEntity<ProductCategoryDTO> getProducts(@PathVariable Long productId) {
		ProductCategoryDTO dto = null;
		Product p = productClient.getProduct(productId);
		if (p != null)
		{
			Category c = categoryClient.getCategory(p.getCategory());
			if  (c != null && c.getId() != null){
			 dto = new ProductCategoryDTO(p, c);
			}
		}
		
		
		//TODO return ProductCategoryDTO
		return new ResponseEntity<>(dto, HttpStatus.OK);
	}

}
