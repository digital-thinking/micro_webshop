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
public class CategoryClient {

	private final Map<Integer, Category> categoryCache = new LinkedHashMap<Integer, Category>();

	@Autowired
	private RestTemplate restTemplate;

	@HystrixCommand(fallbackMethod = "getCategoryCache", commandProperties = {
			@HystrixProperty(name = "circuitBreaker.requestVolumeThreshold", value = "2") })
	public Iterable<Category> getCategorys() {
		Collection<Category> cats = new HashSet<Category>();
		Category[] tmpCategorys = restTemplate.getForObject("http://category-service/v1/categories", Category[].class);
		Collections.addAll(cats, tmpCategorys);
		categoryCache.clear();
		cats.forEach(u -> categoryCache.put(u.getId(), u));
		return cats;
	}

	@HystrixCommand(fallbackMethod = "getCategoryCache", commandProperties = {
			@HystrixProperty(name = "circuitBreaker.requestVolumeThreshold", value = "2") })
	public Category getCategory(Integer categoryId) {
		Category tmpCategory = restTemplate.getForObject("http://category-service/v1/categories/" + categoryId,
				Category.class);
		categoryCache.putIfAbsent(categoryId, tmpCategory);
		return tmpCategory;
	}

	public Iterable<Category> getCategoryCache() {
		return categoryCache.values();
	}

	public Category getCategoryCache(Integer categoryId) {
		return categoryCache.getOrDefault(categoryId, new Category());
	}

}
