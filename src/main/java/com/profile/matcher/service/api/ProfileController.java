package com.profile.matcher.service.api;

import com.profile.matcher.service.exception.ServiceException;
import com.profile.matcher.service.model.Profile;
import com.profile.matcher.service.service.ProfileService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

@AllArgsConstructor
@RestController
public class ProfileController implements ProfileApi {

    private ProfileService profileService;

    @Override
    public ResponseEntity<Profile> getProfile(String playerId) throws ServiceException {
        return new ResponseEntity<>(profileService.getPlayerProfile(playerId), HttpStatus.OK);
    }
}
