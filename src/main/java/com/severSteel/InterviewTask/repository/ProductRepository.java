package com.severSteel.InterviewTask.repository;

import com.severSteel.InterviewTask.model.Product;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

public interface ProductRepository extends CrudRepository<Product, Long> {

    @Query(value = "SELECT * FROM product AS p " +
            "WHERE p.name LIKE :type", nativeQuery = true)
    Product findProductByType(@Param("type") String type);

}
