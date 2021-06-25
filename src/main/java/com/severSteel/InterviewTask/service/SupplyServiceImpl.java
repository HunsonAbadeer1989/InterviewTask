package com.severSteel.InterviewTask.service;

import com.severSteel.InterviewTask.api.request.CreateSupplyRequest;
import com.severSteel.InterviewTask.api.request.SupplyReportRequest;
import com.severSteel.InterviewTask.api.response.ResponseApi;
import com.severSteel.InterviewTask.model.TotalSupplyParams;
import com.severSteel.InterviewTask.repository.SupplyRepository;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
@AllArgsConstructor
public class SupplyServiceImpl implements SupplyService {

    private final SupplyRepository supplyRepository;

    @Override
    public ResponseEntity<ResponseApi> createNewSupply(CreateSupplyRequest supplyRequest) {

        return null;
    }

    @Override
    public ResponseEntity<ResponseApi> createSupplyReport(SupplyReportRequest reportRequest) {

        if(reportRequest == null){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        Map<String, TotalSupplyParams> supplyReport = new HashMap<>();

        List<TotalSupplyParams> totalParamsList =
                supplyRepository.getSuppliesBetweenDatePeriod(reportRequest.getFromDate(), reportRequest.getToDate());

        if(totalParamsList == null){
            return new ResponseEntity<>(HttpStatus.OK);
        }

        String supplyProviderName;
        TotalSupplyParams params;

        return null;
    }

}
