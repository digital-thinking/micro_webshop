package de.hska.iwi.vsys.microlab.api;

public class Product {

	private Long id;
	private String name;
	private String details;
	private double price;
	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	private int category;

	public Product(){}

	public Product(Long id, String name) {
		this.id = id;
		this.name = name;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "Product [id=" + id + ", name=" + name + ", price=" + price + "]";
	}

	public int getCategory() {
		return category;
	}

	public void setCategory(int category) {
		this.category = category;
	}

	public String getDetails() {
		return details;
	}

	public void setDetails(String details) {
		this.details = details;
	}

	
	public static Product fromProductDTO(ProductCategoryDTO categoryDTO){
		Product p = new Product();
		p.category = categoryDTO.getCategory().getId();
		p.details = categoryDTO.getDetails();
		p.id = categoryDTO.getId();
		p.name = categoryDTO.getName();
		p.price = categoryDTO.getPrice();
		return p;
		
	}
}
