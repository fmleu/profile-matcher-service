package com.profile.matcher.service.model;

import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document(collection = "level")
public class Level {

    private Double min;
    private Double max;
}
