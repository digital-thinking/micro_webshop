package de.hska.iwi.vsys.microlab.api;

import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;

@Component
public class ProductClient {

	private final Map<Long, Product> productCache = new LinkedHashMap<Long, Product>();

	@Autowired
	private RestTemplate restTemplate;

	@HystrixCommand(fallbackMethod = "getProductCache", commandProperties = {
			@HystrixProperty(name = "circuitBreaker.requestVolumeThreshold", value = "2") })
	public Iterable<Product> getProducts(Double searchmin, Double searchmax, String name, String searchstring) {
		Collection<Product> products = new HashSet<Product>();


		UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl("http://product-service/v1/products")
				.queryParam("searchmin", searchmin)
				.queryParam("searchmax", searchmax)
				.queryParam("name", name)
				.queryParam("searchstring", searchstring);
		
		Product[] tmpproducts = restTemplate.getForObject(builder.toUriString(), Product[].class);		
		Collections.addAll(products, tmpproducts);
		productCache.clear();
		products.forEach(u -> productCache.put(u.getId(), u));
		return products;
	}

	@HystrixCommand(fallbackMethod = "getProductCache", commandProperties = {
			@HystrixProperty(name = "circuitBreaker.requestVolumeThreshold", value = "2") })
	public Product getProduct(Long productId) {
		Product tmpproduct = restTemplate.getForObject("http://product-service/v1/products/" + productId,
				Product.class);
		productCache.putIfAbsent(productId, tmpproduct);
		return tmpproduct;
	}

	public Iterable<Product> getProductCache(Double searchmin, Double searchmax, String name, String searchstring) {
		return productCache.values();
	}

	public Product getProductCache(Long productId) {
		return productCache.getOrDefault(productId, new Product());
	}

}
