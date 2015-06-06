package com.meety;

import java.io.Serializable;

/**
 * Created by miki on 06.06.2015.
 */
public class Occupation implements Serializable {

    private String title;

    private String at;

    private Integer yearStarted;

    private Integer yearFinished;

    public String getTitle() {
        return title;
    }

    public Occupation setTitle(String title) {
        this.title = title;
        return this;
    }

    public String getAt() {
        return at;
    }

    public Occupation setAt(String at) {
        this.at = at;
        return this;
    }

    public Integer getYearStarted() {
        return yearStarted;
    }

    public Occupation setYearStarted(Integer yearStarted) {
        this.yearStarted = yearStarted;
        return this;
    }

    public Boolean getOnGoing() {
        return this.yearFinished == null && this.yearStarted != null;
    }

    public Integer getYearFinished() {
        return yearFinished;
    }

    public Occupation setYearFinished(Integer yearFinished) {
        this.yearFinished = yearFinished;
        return this;
    }

    @Override
    public String toString() {
        return title + " at " + at + " in " + this.yearStarted + " - " + this.yearFinished;
    }
}
