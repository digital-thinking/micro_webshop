package de.hska.iwi.vsys.microlab.api;

import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;

@Component
public class ProductClient {

	private final Map<Long, Product> productCache = new LinkedHashMap<Long, Product>();

	@Autowired
	private RestTemplate restTemplate;

	@HystrixCommand(fallbackMethod = "getProductCache", commandProperties = {
			@HystrixProperty(name = "circuitBreaker.requestVolumeThreshold", value = "2") })
	public Iterable<Product> getProducts() {
		Collection<Product> products = new HashSet<Product>();
		Product[] tmpproducts = restTemplate.getForObject("http://product-service/v1/products", Product[].class);
		Collections.addAll(products, tmpproducts);
		productCache.clear();
		products.forEach(u -> productCache.put(u.getId(), u));
		return products;
	}

	@HystrixCommand(fallbackMethod = "getProductCache", commandProperties = {
			@HystrixProperty(name = "circuitBreaker.requestVolumeThreshold", value = "2") })
	public Product getProduct(Long productId) {
		Product tmpproduct = restTemplate.getForObject("http://product-service/v1/products/" + productId, Product.class);
		productCache.putIfAbsent(productId, tmpproduct);
		return tmpproduct;
	}

	public Iterable<Product> getProductCache() {
		return productCache.values();
	}

	public Product getProductCache(Long productId) {
		return productCache.getOrDefault(productId, new Product());
	}

}
