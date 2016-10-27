package io.swagger.manager;

import java.math.BigDecimal;
import java.math.MathContext;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.stream.Collectors;

import io.swagger.model.Product;

public class ProductManagerImpl implements ProductManager {

	private static final ProductManagerImpl instance = new ProductManagerImpl();
	private static final ConcurrentHashMap<Integer, Product> storage = new ConcurrentHashMap<>();
	
	@Override
	public List<Product> getProducts() {
		return storage.values().stream().collect(Collectors.toList());//TODO replace with database
	}

	@Override
	public Product getProductById(int id) {
		return storage.get(id);//TODO replace with database
	}

	@Override
	public int addProduct(String name, double price, int categoryId, String details) {
		int productId = -1;
		
		Product product = new Product();
		product.setName(name);
		product.setPrice(price);
		product.setCategory(categoryId);
		if(details != null){
			product.setDetails(details);
		} 
		
		product.setId(5);//TODO REMOVE!!!!
		storage.put(productId, product); //TODO replace with database
		
		productId = product.getId();
			 
		return productId;
	}

	@Override
	public List<Product> getProductsForSearchValues(String searchValue, double searchMinPrice, double searchMaxPrice) {
		List<Product> productList = null;

		//TODO implement criteria
		
	    return productList;
	}

	@Override
	public void deleteProductById(int id) {
		storage.remove(id);
		
	}
	
	public static ProductManager getSingletonMockSuperUgly(){
		return instance;
	}


}
