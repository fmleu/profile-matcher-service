package com.profile.matcher.service.model;

import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;

import java.math.BigDecimal;
import java.util.Map;

@Data
@Document(collection = "inventory")
public class Inventory {

    private Map<String, BigDecimal> resources;
}
