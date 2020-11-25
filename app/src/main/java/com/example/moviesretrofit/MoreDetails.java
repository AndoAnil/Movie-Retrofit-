package com.example.moviesretrofit;

public class MoreDetails {

    //Model class for nested object
    private String release;
    private String category;
    private String duration;

    public MoreDetails(String release, String category, String duration) {
        this.release = release;
        this.category = category;
        this.duration = duration;
    }

    public MoreDetails(){}
    public String getRelease() {
        return release;
    }

    public void setRelease(String release) {
        this.release = release;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }


}
