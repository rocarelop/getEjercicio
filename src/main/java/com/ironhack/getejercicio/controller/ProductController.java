package com.ironhack.getejercicio.controller;

import com.ironhack.getejercicio.enums.Category;
import com.ironhack.getejercicio.enums.Department;
import com.ironhack.getejercicio.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


public interface ProductController {
    Product findById(long id);
    List<Product> findByCategoryAndDepartment(Category category, Department department);

}
