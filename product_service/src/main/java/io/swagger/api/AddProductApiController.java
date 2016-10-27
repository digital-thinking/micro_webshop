package io.swagger.api;

import io.swagger.model.Product;

import io.swagger.annotations.*;
import io.swagger.manager.ProductManager;
import io.swagger.manager.ProductManagerImpl;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;


@javax.annotation.Generated(value = "class io.swagger.codegen.languages.SpringCodegen", date = "2016-10-24T14:07:33.320Z")

@Controller
public class AddProductApiController implements AddProductApi {

    public ResponseEntity<Void> addProductPost(

@ApiParam(value = "Product that will be added"  ) @RequestBody Product product

) {
    	ProductManager productManager = ProductManagerImpl.getSingletonMockSuperUgly();    	
    	productManager.addProduct(product.getName(), product.getPrice(), product.getCategory(), product.getDetails());
        return new ResponseEntity<Void>(HttpStatus.OK);
    }

}
