package com.ironhack.getejercicio.controller.impl;

import com.ironhack.getejercicio.controller.ProductController;
import com.ironhack.getejercicio.enums.Category;
import com.ironhack.getejercicio.enums.Department;
import com.ironhack.getejercicio.model.Product;
import com.ironhack.getejercicio.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

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

    @GetMapping("/products/byCategoryAndDepartment")
    public List<Product> findByCategoryAndDepartment(@RequestParam Category category, @RequestParam (defaultValue = "CLOTHING")Department department){
        List<Product> productList = productRepository.findByCategoryAndDepartment(category,department);
        return productList;

    }


}
