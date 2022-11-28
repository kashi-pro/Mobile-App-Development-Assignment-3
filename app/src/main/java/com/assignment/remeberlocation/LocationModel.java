package com.assignment.remeberlocation;

public class LocationModel {

    private String name;
    private String desc;

    public LocationModel(String inName, String inDesc) {
        name= inName;
        desc= inDesc;
    }

    public String getName() {
        return name;
    }

    public String getDesc() {
        return desc;
    }
}
