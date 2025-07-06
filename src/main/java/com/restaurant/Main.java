package com.restaurant;

import com.restaurant.Exceptions.MenuException;
import com.restaurant.Menu.DailyMenu;
import com.restaurant.Menu.InputFromFile;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        InputFromFile menuFormat = new InputFromFile();


        try {
            menuFormat.readFromFile("E:/Coding/Projects/MenuFormatter/src/main/java/com/restaurant/Files/menu_original.txt");
        } catch (MenuException e) {
            System.err.println("Something wrong");
        }

        List<DailyMenu> weeklyMenu = menuFormat.getWeeklyMenu();

        for (DailyMenu menu : weeklyMenu ) {
            System.out.println(menu);
        }


    }
}