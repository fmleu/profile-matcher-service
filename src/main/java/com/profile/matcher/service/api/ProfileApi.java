package com.profile.matcher.service.api;

import com.profile.matcher.service.exception.ServiceException;
import com.profile.matcher.service.model.Profile;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

public interface ProfileApi {

    @RequestMapping(value = "/get_client_config/{player_id}",
            produces = { "application/json" },
            method = RequestMethod.GET)
    ResponseEntity<Profile> getProfile(@PathVariable(name = "player_id") String playerId) throws ServiceException;
}
