package com.severSteel.InterviewTask.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class TotalWeightAndPrice {

    @JsonProperty("weight_sum")
    private double weightSum;
    @JsonProperty("price_sum")
    private double priceSum;

}
