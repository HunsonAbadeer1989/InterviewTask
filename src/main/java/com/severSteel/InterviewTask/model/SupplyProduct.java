package com.severSteel.InterviewTask.api.response;

import com.severSteel.InterviewTask.model.Product;
import com.severSteel.InterviewTask.model.Supply;
import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "supply_product")
@NoArgsConstructor
@RequiredArgsConstructor
@Getter
@Setter
public class SupplyProduct {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @ManyToOne
    @JoinColumn(name = "supply_id")
    @NonNull
    private Supply supply;

    @ManyToOne
    @JoinColumn(name = "product_id")
    @NonNull
    private Product product;

}
