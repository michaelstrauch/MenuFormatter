package com.restaurant;

import com.restaurant.Exceptions.MenuException;
import com.restaurant.Menu.IO_Formatting;
import com.restaurant.Menu.MenuModel;

public class Main {
    public static void main(String[] args) {
        IO_Formatting menuFormat = new IO_Formatting();

        try {
            menuFormat.readFromFile("E:/Coding/Projects/MenuFormatter/src/main/java/com/restaurant/Files/menu_original.txt");
        } catch (MenuException e) {
            System.err.println("Something wrong");
        }

        for (MenuModel menu : menuFormat.dailyMenu()) {
            System.out.println(menu);
        };
    }
}