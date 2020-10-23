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

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@RestController
public class GpsUtilControler {

    private Logger logger = LoggerFactory.getLogger(GpsUtilControler.class);

    @Autowired
    private GpsUtilService gpsUtilService;

    /**
     * Give the user location for a user
     * @param userId user UUID
     * @return user location
     * @throws UUIDException if user UUID is incorrect
     */
    @GetMapping(value = "getUserLocation")
    @ResponseStatus(HttpStatus.OK)
    public VisitedLocation getUserLocation (@RequestParam UUID userId) throws UUIDException {
        try {
            logger.debug("Start getUserLocation for : " + userId.toString());

            return gpsUtilService.getUserLocation(userId);
        } catch (Exception e){
            throw new UUIDException("UUID input error : userId = " + userId + "  message :" + e.getMessage());
        }
    }

    /**
     * Give the user location for a user
     * @param userId user UUID in string format
     * @return user location
     * @throws UUIDException if user UUID is incorrect
     */
    @GetMapping(value = "getUserLocationV2")
    @ResponseStatus(HttpStatus.OK)
    public VisitedLocation getUserLocationV2 (@RequestParam String userId) throws UUIDException {
        try {
            logger.debug("Start getUserLocationV2 for : " + userId);
            UUID userIdUUID = UUID.fromString(userId);
            return gpsUtilService.getUserLocation(userIdUUID);
        } catch (Exception e){
            throw new UUIDException("UUID input error : userId = " + userId + "  message :" + e.getMessage());
        }
    }

    /**
     * Give a list of all attractions
     * @return list of all attractions
     */
    @GetMapping(value = "getAttractions")
    @ResponseStatus(HttpStatus.OK)
    public List<Attraction> getAttractions () {
        logger.debug("Start getAttractions");
        return gpsUtilService.getAttractions();
    }
}
