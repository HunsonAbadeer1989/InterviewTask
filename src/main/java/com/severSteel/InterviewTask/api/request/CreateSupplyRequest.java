package com.severSteel.InterviewTask.api.request;

import com.severSteel.InterviewTask.model.Product;
import com.severSteel.InterviewTask.model.Provider;
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

    private Provider provider;
    private List<Product> productList;

}
