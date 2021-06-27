package com.severSteel.InterviewTask.service;

import com.severSteel.InterviewTask.api.request.CreateSupplyRequest;
import com.severSteel.InterviewTask.api.request.SupplyReportRequest;
import com.severSteel.InterviewTask.api.response.*;
import com.severSteel.InterviewTask.model.Product;
import com.severSteel.InterviewTask.model.Provider;
import com.severSteel.InterviewTask.model.Supply;
import com.severSteel.InterviewTask.model.SupplyProduct;
import com.severSteel.InterviewTask.repository.ProductRepository;
import com.severSteel.InterviewTask.repository.ProviderRepository;
import com.severSteel.InterviewTask.repository.SupplyProductRepository;
import com.severSteel.InterviewTask.repository.SupplyRepository;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.*;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class SupplyServiceImpl implements SupplyService {

    private final SupplyRepository supplyRepository;
    private final ProviderRepository providerRepository;
    private final ProductRepository productRepository;
    private final SupplyProductRepository supplyProductRepository;

    @Override
    public ResponseEntity<ResponseApi> createNewSupply(CreateSupplyRequest supplyRequest) {

        if (supplyRequest == null || supplyRequest.getProviderId() == null || supplyRequest.getProductList() == null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        // Проверка наличия пользователя в БД, в будущем может быть вынесена в отдельный метод
        Provider providerById = providerRepository.findById(supplyRequest.getProviderId())
                .orElseThrow(NotFoundOrBadRequestResponse::new);


        // Проверка наличия вида продукта в БД, в будущем может быть вынесена в отдельный метод
        List<Product> products =  supplyRequest.getProductList()
                .stream().map(p -> productRepository.findProductByType(p.getType())).collect(Collectors.toList());

        Supply newSupply = new Supply();
        newSupply.setProvider(providerById);
        newSupply.setProducts(supplyRequest.getProductList());
        newSupply.setDateOfSupply(LocalDate.now());

        supplyRepository.save(newSupply);

        // Сохранение нового вида продукта
        for(Product product : supplyRequest.getProductList()) {
            if (!products.contains(product)){
                productRepository.save(product);
                supplyProductRepository.save(new SupplyProduct(newSupply, product));

            }
        }

        return new ResponseEntity<>(HttpStatus.OK);
    }

    @Override
    public ResponseEntity<ResponseApi> createSupplyReport(SupplyReportRequest reportRequest) {

        if (reportRequest == null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        Map<String, Map<String, SupplyForResultMapDTO>> resultMap = new HashMap<>();

        LocalDate fromDate = reportRequest.getFromDate();
        LocalDate toDate = reportRequest.getToDate();
        List<Supply> totalParamsList = supplyRepository.getSuppliesBetweenDatePeriod(fromDate, toDate);

        if (totalParamsList == null) {
            return new ResponseEntity<>(HttpStatus.OK);
        }

        List<SupplyDTO> DTOList = mapSupplyToDTO(totalParamsList);

        // Перебираем выборку поставок из БД
        for (SupplyDTO supplyDTO : DTOList) {
            Map<String, SupplyForResultMapDTO> innerSupply =  new HashMap<>();
            SupplyForResultMapDTO resultDTO = new SupplyForResultMapDTO(supplyDTO);
            String providerName = supplyDTO.getProviderName();

            // Поставщика с именем providerName не существует в финальной выборке
            if (!resultMap.containsKey(providerName)) {
                // Добавляем поставщика и поставку
                innerSupply.put(supplyDTO.getProductType(), resultDTO);
                resultMap.put(providerName, innerSupply);
            }

            // Поставщик с именем providerName уже присутствует в финальной выборке
            else {
                String productType = supplyDTO.getProductType();
                // Поставщик с именем providerName не содержит в поставке данный вид товара productType
                if(!resultMap.get(providerName).containsKey(productType)){
                    resultMap.get(providerName).put(productType, resultDTO);
                }

                // Если поставщик с именем providerName уже содержит в одной из поставок данный вид товара productType
                // Устанавливаем новые суммирующие значения веса и цены поставки
                else {
                    double oldWeight = resultMap.get(providerName).get(productType).getProductWeight();
                    double oldPrice = resultMap.get(providerName).get(productType).getProductPrice();
                    double newWeight = oldWeight + supplyDTO.getProductWeight();
                    double newPrice = oldPrice + supplyDTO.getProductPrice();
                    resultMap.get(providerName).get(productType).setProductWeight(newWeight);
                    resultMap.get(providerName).get(productType).setProductPrice(newPrice);
                }

            }
        }

        return new ResponseEntity<>(new SupplyReportResponse(resultMap), HttpStatus.OK);
    }

    public List<SupplyDTO> mapSupplyToDTO(List<Supply> supplies) {
        List<SupplyDTO> supplyDTOList = new ArrayList<>();

        for (Supply supply : supplies) {
            for (Product product : supply.getProducts()) {
                SupplyDTO supplyDTO = new SupplyDTO();
                supplyDTO.setProviderName(supply.getProvider().getName());
                supplyDTO.setDateOfSupply(supply.getDateOfSupply());
                supplyDTO.setProductName(product.getName());
                supplyDTO.setProductType(product.getType());
                supplyDTO.setProductWeight(product.getWeight());
                supplyDTO.setProductPrice(product.getPrice());
                supplyDTOList.add(supplyDTO);
            }
        }

        return supplyDTOList;
    }


}
