package com.restaurant.Menu;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class DailyMenu {


    String day;
    List<MenuModel> menu;

    public DailyMenu(String day) {
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

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(day).append("\n");
        for (MenuModel meal: menu) {
            sb.append(meal.toString()).append("\n");
        }
        return sb.toString();
    }
}


