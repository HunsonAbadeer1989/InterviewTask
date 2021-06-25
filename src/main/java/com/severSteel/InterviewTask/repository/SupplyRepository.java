package com.severSteel.InterviewTask.repository;

import com.severSteel.InterviewTask.model.Supply;
import com.severSteel.InterviewTask.model.TotalSupplyParams;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface SupplyRepository extends CrudRepository<Supply, Integer> {

    @Query(value =
            "SELECT prov.name AS provider_name, s.date_of_supply, " +
            "prod.name AS product_name, prod.type AS product_type, prod.weight, prod.price " +
            "FROM supply AS s " +
            "JOIN provider AS prov ON s.provider_id = prov.id " +
            "JOIN supply_product AS s_p ON s.id = s_p.supply_id " +
            "JOIN product AS prod ON s_p.product_id = prod.id " +
            "WHERE (date_of_supply BETWEEN start AND end) ", nativeQuery = true)
    List<TotalSupplyParams> getSuppliesBetweenDatePeriod(@Param("start") LocalDate start, @Param("end") LocalDate end);

}
