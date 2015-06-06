package com.meety.service;


import com.meety.Occupation;
import com.meety.User;
import com.meety.UserCompared;
import com.meety.UserLocation;
import org.apache.commons.lang3.StringUtils;

import java.util.List;

/**
 * Created by miki on 06.06.2015.
 */
public class UserComparator {
    User user;
    UserCompared toCompare;

    public UserComparator(User user, User toCompare) {
        this.user = user;
        this.toCompare = new UserCompared(toCompare);
    }

    /**
     * @return
     */
    public UserCompared compare() {
        Double distance = new DistanceCalculator().getDistance(user.getLocation(), toCompare.getLocation());
        toCompare.setDistance(distance.intValue());
        checkCommonPlaces();
        checkCommonActivity(user.getEducationHistory(), toCompare.getEducationHistory());
        checkCommonActivity(user.getJobHistory(), toCompare.getJobHistory());
        checkInterests();
        checkHomeTown();
        checkLanguages();
        return toCompare;
    }

    private void checkLanguages() {
        for (String language : user.getLanguages()) {
            for (String languageTwo : toCompare.getLanguages()) {
                if (stringEquals(language, languageTwo)) {
                    toCompare.addSimilarity("Same language spoken : " + language);
                    toCompare.setSameLanguage(true);
                }
            }
        }
    }

    private void checkHomeTown() {
        double distance = new DistanceCalculator().getDistance(user.getHomeTown(), toCompare.getHomeTown());
        if (distance < DistanceCalculator.ONE_KM * 10) {
            toCompare.addSimilarity("Similar hometown detected: " + user.getHomeTown());
        }
    }

    private void checkInterests() {
        for (String interestOne : user.getInterests()) {
            for (String interestTwo : toCompare.getInterests()) {
                if (interestOne.equalsIgnoreCase(interestTwo)) {
                    this.toCompare.addSimilarity("Interest match: " + interestOne);
                }
            }
        }
    }

    private void checkCommonActivity(List<Occupation> occupationsOne, List<Occupation> occupationsTwo) {
        for (Occupation occupationOne : occupationsOne) {
            for (Occupation occupationTwo : occupationsTwo) {
                if (stringEquals(occupationOne.getAt(), occupationTwo.getAt())) {
                    this.toCompare.addSimilarity("Have been working or studying at " + occupationOne.getAt());
                } else {
                    if (stringEquals(occupationOne.getTitle(), occupationTwo.getAt())) {
                        this.toCompare.addSimilarity("Have had same title: " + occupationOne.getTitle());
                    }
                }
            }
        }
    }

    /**
     * For each common place (less than 1km distance) 2 points are added.
     * If name of the location is similar , 1 more point is added;
     */
    private void checkCommonPlaces() {
        for (UserLocation userLocation : user.getLocationsHistory()) {
            for (UserLocation secondLocation : toCompare.getLocationsHistory()) {
                double distance = new DistanceCalculator().getDistance(userLocation, secondLocation);
                if (distance < DistanceCalculator.ONE_KM) {
                    toCompare.addSimilarity("Similar location detected: " + userLocation.toString() + "" +
                            " - " + secondLocation.toString());
                }
            }
        }
    }

    private Boolean stringEquals(String one, String two) {
        return StringUtils.containsIgnoreCase(one, two)
                || StringUtils.containsIgnoreCase(two, one)
                || StringUtils.equalsIgnoreCase(one, two);
    }

    private Boolean occupationIntersects(Occupation occupation, Occupation occupationTwo) {
        if (occupation.getYearStarted() != null && occupationTwo.getYearStarted() != null) {
            int startOne = occupation.getYearStarted();
            int startTwo = occupationTwo.getYearStarted();

            int endOne = occupation.getYearFinished() != null ? occupation.getYearFinished() : Integer.MAX_VALUE;
            int endTwo = occupationTwo.getYearFinished() != null ? occupationTwo.getYearFinished() : Integer.MAX_VALUE;

            return (startOne <= startTwo && endOne <= endTwo) ||
                    (startTwo <= startOne && endTwo <= endOne);

        }
        return false;
    }


}
