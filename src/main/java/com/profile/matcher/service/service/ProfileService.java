package com.profile.matcher.service.service;

import com.profile.matcher.service.exception.ServiceException;
import com.profile.matcher.service.model.Profile;

public interface ProfileService {

    Profile getPlayerProfile(String playerId) throws ServiceException;
}
