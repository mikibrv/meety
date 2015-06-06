package com.meety;

import java.util.ArrayList;
import java.util.List;

/**
 * Also contains comparations... similar stuff..
 * Created by miki on 06.06.2015.
 */
public class UserCompared extends User {

    List<String> similarities = new ArrayList<String>();

    private int distance;


    private Boolean sameLanguage = Boolean.FALSE;


    public UserCompared(User user) {
        super(user);
    }

    public List<String> getSimilarities() {
        return similarities;
    }

    public void setSimilarities(List<String> similarities) {
        this.similarities = similarities;
    }

    public UserCompared addSimilarity(String similarity) {
        this.similarities.add(similarity);
        return this;
    }

    public int getCountSimilarities() {
        return this.similarities.size();
    }

    public int getDistance() {
        return distance;
    }

    public void setDistance(int distance) {
        this.distance = distance;
    }

    public Boolean isSameLanguage() {
        return sameLanguage;
    }

    public void setSameLanguage(Boolean sameLanguage) {
        this.sameLanguage = sameLanguage;
    }
}
