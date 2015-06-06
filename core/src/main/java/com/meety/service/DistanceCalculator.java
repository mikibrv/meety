package com.meety.service;

import com.meety.UserLocation;

/**
 * Created by miki on 06.06.2015.
 */
public class DistanceCalculator {

    public double getDistance(UserLocation userLocation, UserLocation userLocationTwo) {

        return distance(userLocation.getLatitude(), userLocation.getLongitude(), userLocationTwo.getLatitude(),
                userLocationTwo.getLongitude());
    }


    private double distance(double lat1, double lon1, double lat2, double lon2) {

        double theta = lon1 - lon2;

        double dist = Math.sin(deg2rad(lat1)) * Math.sin(deg2rad(lat2)) + Math.cos(deg2rad(lat1)) * Math.cos(deg2rad(lat2)) * Math.cos(deg2rad(theta));

        dist = Math.acos(dist);
        dist = rad2deg(dist);

        dist = dist * 60 * 1.1515;

        dist = dist * 1.609344;

        return (dist);

    }

    private double rad2deg(double rad) {
        return (rad * 180 / Math.PI);
    }

    private double deg2rad(double deg) {
        return (deg * Math.PI / 180.0);

    }


}
