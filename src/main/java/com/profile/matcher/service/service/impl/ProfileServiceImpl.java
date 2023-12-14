package com.profile.matcher.service.service.impl;

import com.profile.matcher.service.exception.ServiceException;
import com.profile.matcher.service.model.Campaign;
import com.profile.matcher.service.model.Profile;
import com.profile.matcher.service.repository.CampaignRepository;
import com.profile.matcher.service.repository.ProfileRepository;
import com.profile.matcher.service.service.ProfileService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Slf4j
@AllArgsConstructor
@Service
public class ProfileServiceImpl implements ProfileService {

    private ProfileRepository profileRepository;
    private CampaignRepository campaignRepository;

    @Override
    public Profile getPlayerProfile(String playerId) throws ServiceException {
        Optional<Profile> optionalProfile = profileRepository.findById(playerId);
        if (optionalProfile.isEmpty()) {
            log.error("The profile with id {} not found", playerId);
            throw new ServiceException(HttpStatus.NOT_FOUND, "Profile not found");
        }

        List<Campaign> activeCampaigns = campaignRepository.findAll();
        if (activeCampaigns.isEmpty()) {
            log.error("No active campaigns found");
            throw new ServiceException(HttpStatus.NOT_FOUND, "Active campaigns not found");
        }

        Profile profile = optionalProfile.get();
        Double profileLevel = profile.getLevel();
        for (Campaign campaign : activeCampaigns) {
            Double min = campaign.getMatchers().getLevel().getMin();
            Double max = campaign.getMatchers().getLevel().getMax();
            if (min <= profileLevel && max >= profileLevel) {
                profile.getActiveCampaigns().add(campaign);
                profile.setActiveCampaigns(profile.getActiveCampaigns());
            }
        }

        return profile;
    }
}
