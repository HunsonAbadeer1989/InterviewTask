package com.severSteel.InterviewTask.api.response;

import com.severSteel.InterviewTask.model.TotalSupplyParams;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Map;

@NoArgsConstructor
@Getter
@Setter
public class SupplyReportResponse implements ResponseApi {

    private Map<String, TotalSupplyParams> reportList;

    public SupplyReportResponse(Map<String, TotalSupplyParams> supplies) {
        reportList.putAll(supplies);
    }

}
