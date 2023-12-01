package com.profile.matcher.service.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document(collection = "clan")
public class Clan {

    @Id
    private String id;
    private String name;
}
