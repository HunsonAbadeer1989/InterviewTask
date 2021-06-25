package com.severSteel.InterviewTask.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Embedded;
import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class TotalSupplyParams {

    @JsonProperty("provider_name")
    @Embedded
    private String providerName;
    @JsonProperty("date_of_supply")
    private LocalDate dateOfSupply;
    @JsonProperty("product_name")
    private String productName;
    @JsonProperty("product_type")
    private String productType;
    private double totalWeight;
    private double totalPrice;

}
