package com.restaurant.Models;

import java.util.ArrayList;
import java.util.List;

public class DailyMenu {


    String day;
    String soupName;
    String soupDescription;
    List<MenuModel> menu;

    public DailyMenu(String day, String soupName, String soupDescription) {
        this.soupDescription = soupDescription;
        this.soupName = soupName;
        this.day = day;
        this.menu = new ArrayList<>();
    }

    public String getDay() {
        return day;
    }

    public void setDay(String day) {
        this.day = day;
    }

    public List<MenuModel> getMenu() {
        return menu;
    }

    public void setMenu(List<MenuModel> menu) {
        this.menu = menu;
    }

    public void addToDailyMenu(MenuModel singleMenu) {
        menu.add(singleMenu);
    }

    public String toRozvozFormat() {
        StringBuilder sb = new StringBuilder();
        sb.append(day).append("\n");
        for (MenuModel meal : menu) {
            sb.append(meal.toRozvozFormat()).append("\n");
        }
        return sb.toString();
    }

    public String toStoriesFormat() {
        StringBuilder sb = new StringBuilder();
        sb.append(day).append("\n")
                .append(soupName).append("\n")
                .append(soupDescription).append("\n");
        for (MenuModel meal : menu) {
            sb.append(meal.toStoriesFormat()).append("\n");
        }
        return sb.toString();
    }
}


