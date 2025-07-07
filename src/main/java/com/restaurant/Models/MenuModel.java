package com.restaurant.Models;

public class MenuModel {

    private String greekSoup;
    private String greekMainCourse;
    private String description;
    private String price;
    private String iD;

    public MenuModel(String greekSoup, String greekMainCourse, String description, String iD) {
        this.greekSoup = greekSoup;
        this.greekMainCourse = greekMainCourse;
        this.description = description;
        this.iD = iD;


    }

    public String getGreekSoup() {
        return greekSoup;
    }

    public void setGreekSoup(String greekSoup) {
        this.greekSoup = greekSoup;
    }

    public String getGreekMainCourse() {
        return greekMainCourse;
    }

    public void setGreekMainCourse(String greekMainCourse) {
        this.greekMainCourse = greekMainCourse;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getPrice() {
        return price;
    }

    public String setPrice() {
        switch (getiD()) {
            case "1." -> price = ("175,-");
            case "2." -> price = ("185,-");
            case "3." -> price = ("195,-");
            case "4." -> price = ("205,-");
            case "5." -> price = ("215,-");
        } return price;
    }

    public String getiD() {
        return iD;
    }

    public void setiD(String iD) {
        this.iD = iD;
    }

    @Override
    public String toString() {
        return  iD + " " +
                greekMainCourse + " + polévka k menu" + "\n" +
                description + ", " + greekSoup + "\n" +
                setPrice();

    }
}
