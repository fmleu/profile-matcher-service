package com.profile.matcher.service.service.impl;

import com.profile.matcher.service.dal.CampaignDal;
import com.profile.matcher.service.dal.ProfileDal;
import com.profile.matcher.service.exception.ServiceException;
import com.profile.matcher.service.model.Campaign;
import com.profile.matcher.service.model.Profile;
import com.profile.matcher.service.service.ProfileService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@AllArgsConstructor
@Service
public class ProfileServiceImpl implements ProfileService {

    private ProfileDal profileDal;
    private CampaignDal campaignDal;

    @Override
    public Profile getPlayerProfile(String playerId) throws ServiceException {
        try {
            Profile profile = profileDal.getProfileByPlayerId(playerId);
            List<Campaign> campaigns = campaignDal.getAllCampaigns();
            if (campaigns.isEmpty()) {
                log.info("No campaigns found");
            } else {
                Double profileLevel = profile.getLevel();
                boolean update = false;

                for (Campaign campaign : campaigns) {
                    Double min = campaign.getMatchers().getLevel().getMin();
                    Double max = campaign.getMatchers().getLevel().getMax();
                    if (min <= profileLevel && max >= profileLevel) {
                        profile.getActiveCampaigns().add(campaign);
                        profile.setActiveCampaigns(profile.getActiveCampaigns());
                        update = true;
                    }
                }

                if (update) {
                    profileDal.updateActiveCampaignsOnProfile(profile);
                }
            }

            return profile;
        } catch (ServiceException exception) {
            log.error("Error: {}", exception.getMessage());
            throw exception;
        } catch (Exception exception) {
            log.error("Error: {}", exception.getMessage());
            throw new ServiceException(HttpStatus.INTERNAL_SERVER_ERROR, exception.getMessage());
        }
    }
}
