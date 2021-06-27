package com.severSteel.InterviewTask.api.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class weightAndPriceDTO {

    @JsonProperty("weight_sum")
    private double weightSum;
    @JsonProperty("price_sum")
    private double priceSum;

}
