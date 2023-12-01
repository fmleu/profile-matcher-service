package com.profile.matcher.service.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;

@Data
@Document(collection = "campaign")
public class Campaign {

    private String game;
    private String name;
    private Double priority;
    private Matchers matchers;
    private LocalDateTime startDate;
    private LocalDateTime endDate;
    private boolean enabled;
    @LastModifiedDate
    private LocalDateTime lastUpdated;
}
