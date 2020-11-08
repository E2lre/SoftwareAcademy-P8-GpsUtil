# GpsUtil
API REST micro-service for TourGuide application to managing travel and attraction for a custumer.
GpsUtil manage Gps informations. 
This app use SPRINT BOOT, FeignClient.

## Getting Started

- Endpoint : http://localhost:8082/

## Prerequisites

- Java 1.8 or later
- Spring Boot 2.2.6
- Gradle 2.2.5

# Installation

No Database creation needed:

To start the application start sub-micro-service with or without docker in build libs directories: 
- Gpsutil : java -jar gpsUtil-0.0.1-SNAPSHOT.jar


# Architecture Diagram
![ScreenShot](Architecture.png)

# URI
## Get User Location
It's call with UUID for the userId
Example : 
GET http://localhost:8082/getUserLocation?attractionId=123e4567-e89b-12d3-a456-426614174000&userId=123e4567-e89b-12d3-a456-426614174000

## get User LocationV2
It's call with String for the userId
Example : 
ET http://localhost:8082/getUserLocationV2?attractionId=123e4567-e89b-12d3-a456-426614174000&userId=123e4567-e89b-12d3-a456-426614174000

## Get Attractions
Return all attractions
Example : 
http://localhost:8082/getAttractions
