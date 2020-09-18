package com.tourguide.gpsUtil.externalModule;

import gpsUtil.GpsUtil ;
import gpsUtil.location.Attraction;
import gpsUtil.location.VisitedLocation;

import java.util.List;
import java.util.UUID;

public interface ExtModule {

    public VisitedLocation getUserLocation(UUID userId);
    public List<Attraction> getAttractions();
}
