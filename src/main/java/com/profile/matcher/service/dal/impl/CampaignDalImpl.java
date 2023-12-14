package com.profile.matcher.service.dal.impl;

import com.profile.matcher.service.dal.CampaignDal;
import com.profile.matcher.service.model.Campaign;
import com.profile.matcher.service.repository.CampaignRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@AllArgsConstructor
@Service
public class CampaignDalImpl implements CampaignDal {

    private CampaignRepository campaignRepository;

    @Override
    public List<Campaign> getAllCampaigns() {
        return campaignRepository.findAll();
    }
}
