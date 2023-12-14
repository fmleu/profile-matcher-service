package com.profile.matcher.service.dal.impl;

import com.profile.matcher.service.dal.ProfileDal;
import com.profile.matcher.service.exception.ServiceException;
import com.profile.matcher.service.model.Profile;
import com.profile.matcher.service.repository.ProfileRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.Optional;

import static com.profile.matcher.service.util.Constants.ID_FIELD;
import static com.profile.matcher.service.util.Constants.PROFILE_ACTIVE_CAMPAIGNS_FIELD;

@Slf4j
@AllArgsConstructor
@Service
public class ProfileDalImpl implements ProfileDal {

    private ProfileRepository profileRepository;
    private MongoTemplate mongoTemplate;

    @Override
    public Profile getProfileByPlayerId(String playerId) throws ServiceException {
        Optional<Profile> optionalProfile = profileRepository.findById(playerId);
        if (optionalProfile.isEmpty()) {
            log.error("The profile with id {} not found", playerId);
            throw new ServiceException(HttpStatus.NOT_FOUND, "Profile not found");
        }

        return optionalProfile.get();
    }

    @Override
    public void updateActiveCampaignsOnProfile(Profile profile) {
        Query query = new Query().addCriteria(Criteria.where(ID_FIELD).in(profile.getPlayerId()));
        Update update = new Update().set(PROFILE_ACTIVE_CAMPAIGNS_FIELD, profile.getActiveCampaigns());
        mongoTemplate.upsert(query, update, Profile.class);
        log.info("Profile with playerId {} is successfully updated", profile.getPlayerId());
    }
}
