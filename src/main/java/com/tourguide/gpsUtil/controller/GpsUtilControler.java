package com.tourguide.gpsUtil.controller;

import com.tourguide.gpsUtil.controller.exceptions.UUIDException;
import com.tourguide.gpsUtil.service.GpsUtilService;
import gpsUtil.location.Attraction;
import gpsUtil.location.VisitedLocation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.UUID;

@RestController
public class GpsUtilControler {
    @Autowired
    private GpsUtilService gpsUtilService;

    @GetMapping(value = "getUserLocation")
    @ResponseStatus(HttpStatus.OK)
    public VisitedLocation getUserLocation (@RequestParam String userId) throws UUIDException {
        try {
            UUID userIdUUID = UUID.fromString(userId);
            return gpsUtilService.getUserLocation(userIdUUID);
        } catch (Exception e){
            throw new UUIDException("UUID input error : userId = " + userId + "  message :" + e.getMessage());
        }
    }

    @GetMapping(value = "getAttractions")
    @ResponseStatus(HttpStatus.OK)
    public List<Attraction> getAttractions () {
        return gpsUtilService.getAttractions();
    }
}
