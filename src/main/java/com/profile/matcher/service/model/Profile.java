package com.profile.matcher.service.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.mongodb.core.mapping.Document;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

import static com.profile.matcher.service.util.Constants.DATE_TIME_PATTERN;

@JsonIgnoreProperties
@JsonInclude(JsonInclude.Include.NON_NULL)
@Data
@Document(collection = "profile")
public class Profile {

    @JsonProperty("player_id")
    @Id
    private String playerId;
    private String credential;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = DATE_TIME_PATTERN)
    @CreatedDate
    private LocalDateTime created;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = DATE_TIME_PATTERN)
    @LastModifiedDate
    private LocalDateTime modified;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = DATE_TIME_PATTERN)
    @JsonProperty("last_session")
    private LocalDateTime lastSession;
    @JsonProperty("total_spent")
    private BigDecimal totalSpent;
    @JsonProperty("total_refund")
    private BigDecimal totalRefund;
    @JsonProperty("total_transactions")
    private Double totalTransactions;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = DATE_TIME_PATTERN)
    @JsonProperty("last_purchase")
    private LocalDateTime lastPurchase;
    @JsonProperty("active_campaigns")
    private List<Campaign> activeCampaigns;
    private List<Device> devices;
    private Double level;
    private BigDecimal xp;
    @JsonProperty("total_playtime")
    private BigDecimal totalPlaytime;
    private String country;
    private String language;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = DATE_TIME_PATTERN)
    private LocalDateTime birthdate;
    private String gender;
    private Inventory inventory;
    private Clan clan;
    @JsonProperty("custom_field")
    private String customField;
}
