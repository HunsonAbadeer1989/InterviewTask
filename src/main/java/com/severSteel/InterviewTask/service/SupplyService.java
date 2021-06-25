package com.severSteel.InterviewTask.service;

import com.severSteel.InterviewTask.api.request.CreateSupplyRequest;
import com.severSteel.InterviewTask.api.request.SupplyReportRequest;
import com.severSteel.InterviewTask.api.response.ResponseApi;
import org.springframework.http.ResponseEntity;

public interface SupplyService {

    ResponseEntity<ResponseApi> createNewSupply(CreateSupplyRequest supplyRequest);

    ResponseEntity<ResponseApi> createSupplyReport(SupplyReportRequest reportRequest);

}
