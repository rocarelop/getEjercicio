package com.ironhack.getejercicio.controller;

import com.ironhack.getejercicio.enums.Category;
import com.ironhack.getejercicio.enums.Department;
import com.ironhack.getejercicio.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.web.bind.annotation.RestController;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;


public interface ProductController {
    Product findById(long id);
    List<Product> findByCategoryAndDepartment(Optional<Category> optionalCategory, Department department);

}
