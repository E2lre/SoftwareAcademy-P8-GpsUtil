package com.tourguide.gpsUtil.service;

import gpsUtil.location.Attraction;
import gpsUtil.location.VisitedLocation;

import java.util.List;
import java.util.UUID;

public interface GpsUtilService {
    public VisitedLocation getUserLocation(UUID userId);
    public List<Attraction> getAttractions();
}
