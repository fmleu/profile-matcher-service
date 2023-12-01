package com.profile.matcher.service.config;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.profile.matcher.service.model.Campaign;
import com.profile.matcher.service.model.Profile;
import jakarta.annotation.PostConstruct;
import lombok.AllArgsConstructor;
import org.springframework.core.io.ClassPathResource;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Component;

import java.io.IOException;

@AllArgsConstructor
@Component
public class InitializeData {

    private final MongoTemplate mongoTemplate;
    private final ObjectMapper objectMapper;

    @PostConstruct
    public void init() throws IOException {
        System.out.println("Initializing data");

        Campaign campaign = objectMapper.readValue(
                new ClassPathResource("/data/campaign.json").getFile(),
                new TypeReference<>() {});
        Profile profile = objectMapper.readValue(
                new ClassPathResource("/data/profile.json").getFile(),
                new TypeReference<>() {});

        mongoTemplate.insert(campaign);
        mongoTemplate.insert(profile);

        System.out.println("Data initialization completed successfully");
    }
}
