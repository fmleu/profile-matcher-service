package com.profile.matcher.service.model;

import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document(collection = "matchers")
public class Matchers {

    private Level level;
    private Has has;
    private DoesNotHave doesNotHave;
}
