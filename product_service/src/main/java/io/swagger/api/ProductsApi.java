package io.swagger.api;

import io.swagger.annotations.Api;
import io.swagger.model.Product;

@javax.annotation.Generated(value = "class io.swagger.codegen.languages.SpringCodegen", date = "2016-10-24T14:07:33.320Z")

@Api(value = "products", description = "the products API")
public interface ProductsApi extends org.springframework.data.repository.CrudRepository<Product, Integer>{

	void deleteByCategory(Integer categoryId);
}
