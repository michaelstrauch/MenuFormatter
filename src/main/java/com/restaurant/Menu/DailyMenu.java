package com.restaurant.Menu;

import java.util.ArrayList;
import java.util.List;

public class DailyMenu {

    String day;
    String soup;
    List<MenuModel> menu;

    public DailyMenu(String day, String soup) {
        this.day = day;
        this.soup = soup;
        this.menu = new ArrayList<>();
    }

    public String getDay() {
        return day;
    }

    public void setDay(String day) {
        this.day = day;
    }

    public String getSoup() {
        return soup;
    }

    public void setSoup(String soup) {
        this.soup = soup;
    }

    public List<MenuModel> getMenu() {
        return menu;
    }

    public void setMenu(List<MenuModel> menu) {
        this.menu = menu;
    }
}
