package com.ironhack.getejercicio.controller.impl;

import com.ironhack.getejercicio.controller.ProductController;
import com.ironhack.getejercicio.enums.Category;
import com.ironhack.getejercicio.enums.Department;
import com.ironhack.getejercicio.model.Product;
import com.ironhack.getejercicio.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
public class ProductControllerImpl implements ProductController {

    @Autowired
    private ProductRepository productRepository;

    @GetMapping("/products/{id}")
    public Product findById(@PathVariable(name = "id") long id) {

        Optional<Product> optionalProduct = productRepository.findById(id);
        return optionalProduct.get();
    }

    @GetMapping("/products")
    public List<Product> findByCategoryAndDepartment(@RequestParam Optional <Category> optionalCategory, @RequestParam (defaultValue = "CLOTHING")Department department){
        List<Product> productList;
        if(optionalCategory.isPresent()) {
            productList = productRepository.findByCategoryAndDepartment(optionalCategory.get(), department);

        }else{
            productList = productRepository.findByDepartment(department);
        }

        return productList;


        }


    @PostMapping("/products")
    @ResponseStatus(HttpStatus.CREATED)
    public Product store(@RequestBody @Valid Product product) {
    return productRepository.save(product);
    }


}
