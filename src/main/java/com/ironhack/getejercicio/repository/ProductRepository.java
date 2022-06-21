package com.ironhack.getejercicio.repository;

import com.ironhack.getejercicio.enums.Category;
import com.ironhack.getejercicio.enums.Department;
import com.ironhack.getejercicio.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
    //Product finById(long id);

    List<Product> findByCategoryAndDepartment(Category category, Department department);

}
