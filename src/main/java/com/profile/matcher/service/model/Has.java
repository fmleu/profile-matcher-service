package com.profile.matcher.service.model;

import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Data
@Document(collection = "has")
public class Has {

    private List<String> country;
    private List<String> items;
}
