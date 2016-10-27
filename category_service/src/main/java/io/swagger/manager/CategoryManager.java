package io.swagger.manager;

import java.util.List;

import io.swagger.model.Category;

public interface CategoryManager {
	
	public List<Category> getCategories();
	
	public Category getCategory(int id);
	
	public void addCategory(Category cat);
	
	public void delCategory(int id);


}
