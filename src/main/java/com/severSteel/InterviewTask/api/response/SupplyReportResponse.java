package com.severSteel.InterviewTask.api.response;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.HashMap;
import java.util.Map;

@NoArgsConstructor
@Getter
@Setter
public class SupplyReportResponse implements ResponseApi {

    private Map<String, Map<String, SupplyForResultMapDTO>> reportList;

    public SupplyReportResponse(Map<String, Map<String, SupplyForResultMapDTO>> supplies) {
        reportList = new HashMap<>();
        reportList.putAll(supplies);
    }

}
