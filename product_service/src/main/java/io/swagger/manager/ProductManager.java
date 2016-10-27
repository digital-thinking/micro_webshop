package io.swagger.manager;


import java.util.List;

import io.swagger.model.Product;

public interface ProductManager {

	public List<Product> getProducts();

	public Product getProductById(int id);

	public int addProduct(String name, double price, int categoryId, String details);

	public List<Product> getProductsForSearchValues(String searchValue, double searchMinPrice, double searchMaxPrice);
	
    public void deleteProductById(int id);
	
}
