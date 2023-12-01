package com.profile.matcher.service.model;

import lombok.Data;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.mongodb.core.mapping.Document;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@Data
@Document(collection = "profile")
public class Profile {

    @Id
    private String playerId;
    private String credential;
    @CreatedDate
    private LocalDateTime created;
    @LastModifiedDate
    private LocalDateTime modified;
    private LocalDateTime lastSession;
    private BigDecimal totalSpent;
    private BigDecimal totalRefund;
    private Double totalTransactions;
    private LocalDateTime lastPurchase;
    private List<Campaign> activeCampaigns;
    private List<Device> devices;
    private Double level;
    private BigDecimal xp;
    private BigDecimal totalPlaytime;
    private String country;
    private String language;
    private LocalDateTime birthdate;
    private String gender;
    private Inventory inventory;
    private Clan clan;
    private String customField;
}
