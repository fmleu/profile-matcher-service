package com.profile.matcher.service.repository;

import com.profile.matcher.service.model.Campaign;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CampaignRepository extends MongoRepository<Campaign, Long> {

}
