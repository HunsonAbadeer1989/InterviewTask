package com.severSteel.InterviewTask.api.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import java.util.Map;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class NewSupplyResponse implements ResponseApi {

    @NonNull
    private boolean success;

    @JsonProperty("errors")
    private Map<String, String> errors;

}
