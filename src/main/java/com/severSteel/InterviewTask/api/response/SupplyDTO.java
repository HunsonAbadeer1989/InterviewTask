package com.severSteel.InterviewTask.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import java.time.LocalDate;


@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class SupplyDTO {

    @JsonProperty("provider_name")
    private String providerName;
    @JsonProperty("date_of_supply")
    private LocalDate dateOfSupply;
    @JsonProperty("product_name")
    private String productName;
    @JsonProperty("product_type")
    private String productType;
    @JsonProperty("product_weight")
    private double productWeight;
    @JsonProperty("product_price")
    private double productPrice;

}
