package com.profile.matcher.service.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document(collection = "device")
public class Device {

    @Id
    private Long id;
    private String model;
    private String carrier;
    private String firmware;
}
