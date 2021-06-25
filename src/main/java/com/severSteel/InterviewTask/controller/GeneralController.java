package com.severSteel.InterviewTask.controller;

import com.severSteel.InterviewTask.api.request.CreateSupplyRequest;
import com.severSteel.InterviewTask.api.request.SupplyReportRequest;
import com.severSteel.InterviewTask.api.response.ResponseApi;
import com.severSteel.InterviewTask.service.SupplyService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/")
@AllArgsConstructor
public class GeneralController {

    private final SupplyService supplyService;

    @PostMapping
    public ResponseEntity<ResponseApi> createNewSupply(@RequestBody CreateSupplyRequest supplyRequest){
        return supplyService.createNewSupply(supplyRequest);
    }

    @GetMapping
    public ResponseEntity<ResponseApi> createSupplyReport(@RequestBody SupplyReportRequest reportRequest){
        return supplyService.createSupplyReport(reportRequest);
    }

}
