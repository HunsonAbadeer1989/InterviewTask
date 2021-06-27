package com.severSteel.InterviewTask.api.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.severSteel.InterviewTask.model.Product;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class CreateSupplyRequest implements RequestApi {

    @JsonProperty("provider_id")
    private Long providerId;
    @JsonProperty("products")
    private List<Product> productList;

}
