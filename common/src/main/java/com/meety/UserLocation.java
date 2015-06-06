package com.meety;

import java.io.Serializable;

/**
 * Created by miki on 06.06.2015.
 */
public class UserLocation implements Serializable {

    private String locationName;

    private Double latitude;

    private Double longitude;


    public String getLocationName() {
        return locationName;
    }

    public UserLocation setLocationName(String locationName) {
        this.locationName = locationName;
        return this;
    }

    public Double getLatitude() {
        return latitude;
    }

    public UserLocation setLatitude(Double latitude) {
        this.latitude = latitude;
        return this;
    }

    public Double getLongitude() {
        return longitude;
    }

    public UserLocation setLongitude(Double longitude) {
        this.longitude = longitude;
        return this;
    }

    @Override
    public String toString() {
        return "UserLocation{" +
                "locationName='" + locationName + '\'' +
                ", latitude=" + latitude +
                ", longitude=" + longitude +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        UserLocation that = (UserLocation) o;

        if (latitude != null ? !latitude.equals(that.latitude) : that.latitude != null) return false;
        return !(longitude != null ? !longitude.equals(that.longitude) : that.longitude != null);

    }

    @Override
    public int hashCode() {
        int result = latitude != null ? latitude.hashCode() : 0;
        result = 31 * result + (longitude != null ? longitude.hashCode() : 0);
        return result;
    }
}
