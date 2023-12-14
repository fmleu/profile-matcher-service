package com.profile.matcher.service.dal;

import com.profile.matcher.service.exception.ServiceException;
import com.profile.matcher.service.model.Profile;

public interface ProfileDal {

    Profile getProfileByPlayerId(String playerId) throws ServiceException;
    void updateActiveCampaignsOnProfile(Profile profile);
}
