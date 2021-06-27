package com.severSteel.InterviewTask.controller;

import com.severSteel.InterviewTask.api.request.CreateSupplyRequest;
import com.severSteel.InterviewTask.api.request.SupplyReportRequest;
import com.severSteel.InterviewTask.repository.ProductRepository;
import com.severSteel.InterviewTask.service.SupplyService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@Controller
@AllArgsConstructor
public class GeneralController {

    private final SupplyService supplyService;
    private final ProductRepository productRepository;

    @PostMapping
    public String createNewSupply(@RequestBody @ModelAttribute("supplyRequest") CreateSupplyRequest supplyRequest){
        supplyService.createNewSupply(supplyRequest);
        return "main";
    }

    @GetMapping("/main")
    public String createSupplyReport(@RequestBody @ModelAttribute("reportRequest") SupplyReportRequest reportRequest,
                                     Model model){
        supplyService.createSupplyReport(reportRequest);
        model.addAttribute("reportRequest", reportRequest);
        return "main";
    }

    @GetMapping("/products")
    public String getProducts(Model model){
        model.addAttribute("products", productRepository.findAll());
        return "products";
    }

}
