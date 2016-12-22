package io.swagger.api;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.util.MultiValueMap;

import io.swagger.annotations.Api;
import io.swagger.model.Product;

@javax.annotation.Generated(value = "class io.swagger.codegen.languages.SpringCodegen", date = "2016-10-24T14:07:33.320Z")

@Api(value = "products", description = "the products API")
public interface ProductsApi extends org.springframework.data.repository.CrudRepository<Product, Integer>{

	void deleteByCategory(Integer categoryId);
	
	List<Product> findByNameLike(String name);
	
	List<Product> findByPriceBetween(Double x, Double y);

	@Query("select p from Product p where p.name like %?3% and p.details like %?4% and p.price between ?1 and ?2")
	List<Product> findByPriceBetweenAndNameLikeAndDetailsLike(Double searchmin, Double searchmax, String name, String searchString);

}
