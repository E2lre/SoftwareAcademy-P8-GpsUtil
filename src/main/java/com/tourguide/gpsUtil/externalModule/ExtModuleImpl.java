package com.tourguide.gpsUtil.externalModule;

import gpsUtil.location.Attraction;
import gpsUtil.location.VisitedLocation;
import gpsUtil.GpsUtil;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public class ExtModuleImpl implements ExtModule{

    private static GpsUtil gpsUtil = new GpsUtil();

    @Override
    public VisitedLocation getUserLocation(UUID userId) {

        return gpsUtil.getUserLocation(userId);
    }

    @Override
    public List<Attraction> getAttractions() {
        return gpsUtil.getAttractions();
    }
}
