package com.profile.matcher.service.model;

import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Data
@Document(collection = "doesNotHave")
public class DoesNotHave {

    private List<String> items;
}
