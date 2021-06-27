package com.severSteel.InterviewTask.api.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class SupplyForResultMapDTO implements ResponseApi{

    @JsonProperty("date_of_supply")
    private LocalDate dateOfSupply;
    @JsonProperty("product_name")
    private String productName;
    @JsonProperty("product_weight")
    private double productWeight;
    @JsonProperty("product_price")
    private double productPrice;

    public SupplyForResultMapDTO(SupplyDTO dto){
        dateOfSupply = dto.getDateOfSupply();
        productName = dto.getProductName();
        productWeight = dto.getProductWeight();
        productPrice = dto.getProductPrice();
    }

}
