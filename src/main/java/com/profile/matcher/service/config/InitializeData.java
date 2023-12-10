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

import static com.profile.matcher.service.util.Constants.CAMPAIGN_JSON_PATH;
import static com.profile.matcher.service.util.Constants.PROFILE_JSON_PATH;

@AllArgsConstructor
@Component
public class InitializeData {

    private final MongoTemplate mongoTemplate;
    private final ObjectMapper objectMapper;

    @PostConstruct
    public void init() throws IOException {
        System.out.println("Initializing data...");

        Campaign campaign = objectMapper.readValue(
                new ClassPathResource(CAMPAIGN_JSON_PATH).getFile(),
                new TypeReference<>() {});
        Profile profile = objectMapper.readValue(
                new ClassPathResource(PROFILE_JSON_PATH).getFile(),
                new TypeReference<>() {});

        mongoTemplate.insert(campaign);
        mongoTemplate.insert(profile);

        System.out.println("Data initialization completed successfully!");
    }
}
