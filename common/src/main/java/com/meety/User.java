package com.meety;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by miki on 06.06.2015.
 */
@Document(collection = "users")
public class User implements Serializable {

    @Id
    private String id;

    private String deviceId;

    private String name;

    private String picture;

    private List<String> languages = new ArrayList<String>();

    private List<String> interests = new ArrayList<String>();

    private UserLocation location;

    private UserLocation homeTown;

    private List<UserLocation> locationsHistory = new ArrayList<UserLocation>();

    private List<Occupation> educationHistory = new ArrayList<Occupation>();

    private List<Occupation> jobHistory = new ArrayList<Occupation>();

    public String getId() {
        return id;
    }

    public User() {
    }

    public User(User user) {
        this.id = user.id;
        this.deviceId = user.deviceId;
        this.name = user.name;
        this.picture = user.picture;
        this.interests = user.interests;
        this.location = user.location;
        this.homeTown = user.homeTown;
        this.locationsHistory = user.locationsHistory;
        this.educationHistory = user.educationHistory;
        this.jobHistory = user.jobHistory;
    }

    public User addHistoricLocation(UserLocation userLocation) {
        this.locationsHistory.add(userLocation);
        return this;
    }

    public User addEducation(Occupation occupation) {
        this.educationHistory.add(occupation);
        return this;
    }

    public User addJob(Occupation occupation) {
        this.jobHistory.add(occupation);
        return this;
    }

    public User setId(String id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public User setName(String name) {
        this.name = name;
        return this;
    }

    public String getDeviceId() {
        return deviceId;
    }

    public User setDeviceId(String deviceId) {
        this.deviceId = deviceId;
        return this;
    }

    public List<String> getInterests() {
        return interests;
    }

    public User setInterests(List<String> interests) {
        this.interests = interests;
        return this;
    }

    public UserLocation getLocation() {
        return location;
    }

    public User setLocation(UserLocation location) {
        this.location = location;
        return this;
    }

    public List<UserLocation> getLocationsHistory() {
        return locationsHistory;
    }

    public User setLocationsHistory(List<UserLocation> locationsHistory) {
        this.locationsHistory = locationsHistory;
        return this;
    }

    public List<Occupation> getEducationHistory() {
        return educationHistory;
    }

    public User setEducationHistory(List<Occupation> educationHistory) {
        this.educationHistory = educationHistory;
        return this;
    }

    public List<Occupation> getJobHistory() {
        return jobHistory;
    }

    public User setJobHistory(List<Occupation> jobHistory) {
        this.jobHistory = jobHistory;
        return this;
    }


    public User setPicture(String picture) {
        this.picture = picture;
        return this;
    }

    public String getPicture() {
        return picture;
    }

    public UserLocation getHomeTown() {
        return homeTown;
    }

    public User setHomeTown(UserLocation homeTown) {
        this.homeTown = homeTown;
        return this;
    }

    public List<String> getLanguages() {
        return languages;
    }

    public User setLanguages(List<String> languages) {
        this.languages = languages;
        return this;
    }

    public User addLanguage(String language) {
        languages.add(language);
        return this;
    }

    @Override
    public String toString() {
        return "User{" +
                "id='" + id + '\'' +
                ", deviceId='" + deviceId + '\'' +
                ", name='" + name + '\'' +
                ", picture='" + picture + '\'' +
                ", languages=" + languages +
                ", interests=" + interests +
                ", location=" + location +
                ", homeTown=" + homeTown +
                ", locationsHistory=" + locationsHistory +
                ", educationHistory=" + educationHistory +
                ", jobHistory=" + jobHistory +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        User user = (User) o;

        return !(id != null ? !id.equals(user.id) : user.id != null);

    }

    @Override
    public int hashCode() {
        return id != null ? id.hashCode() : 0;
    }

    public User addInterest(String interest) {
        this.interests.add(interest);
        return this;
    }
}
