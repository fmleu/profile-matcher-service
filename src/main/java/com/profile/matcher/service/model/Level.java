package com.profile.matcher.service.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

@JsonInclude(JsonInclude.Include.NON_NULL)
@Data
public class Level {

    private Double min;
    private Double max;
}
