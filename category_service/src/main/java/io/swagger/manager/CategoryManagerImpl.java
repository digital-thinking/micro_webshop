package io.swagger.manager;

import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.stream.Collectors;

import io.swagger.model.Category;

public class CategoryManagerImpl implements CategoryManager {
	
	private static final CategoryManagerImpl instance = new CategoryManagerImpl();
	private static final ConcurrentHashMap<Integer, Category> storage = new ConcurrentHashMap<>();

	@Override
	public List<Category> getCategories() {
		return storage.values().stream().collect(Collectors.toList());
	}

	@Override
	public Category getCategory(int id) {
		return storage.get(id);
	}

	@Override
	public void addCategory(Category cat) {
		storage.put(cat.getId(), cat);

	}

	@Override
	public void delCategory(int id) {
		storage.remove(id);

	}
	
	public static CategoryManager getSingletonMockSuperUgly(){
		return instance;
	}


}
