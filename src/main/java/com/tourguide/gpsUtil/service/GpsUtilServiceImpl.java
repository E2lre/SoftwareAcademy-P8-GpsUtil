package com.tourguide.gpsUtil.service;

import com.tourguide.gpsUtil.externalModule.ExtModule;
import gpsUtil.location.Attraction;
import gpsUtil.location.VisitedLocation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;

import java.util.List;
import java.util.UUID;

@Configuration
public class GpsUtilServiceImpl implements GpsUtilService {

    @Autowired
    private ExtModule extModule;

    /**
     * Give the user location for a user
     * @param userId userId user UUID
     * @return user location
     */
    @Override
    public VisitedLocation getUserLocation(UUID userId) {
        return extModule.getUserLocation(userId);
    }
    /**
     * Give a list of all attractions
     * @return list of all attractions
     */
    @Override
    public List<Attraction> getAttractions() {
        return extModule.getAttractions();
    }
}
