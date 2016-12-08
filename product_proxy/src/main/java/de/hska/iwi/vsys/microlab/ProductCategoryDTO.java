package de.hska.iwi.vsys.microlab;

public class ProductCategoryDTO {

	private Long id;
	private String name;
	private String details;
	private double price;
	private Category category;

	public ProductCategoryDTO(){}

	public ProductCategoryDTO(Product p, Category c) {
		this.id = p.getId();
		this.name = p.getName();
		this.details = p.getDetails();
		this.price = p.getPrice();
		this.category = c;
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

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	public String getDetails() {
		return details;
	}

	public void setDetails(String details) {
		this.details = details;
	}

}
