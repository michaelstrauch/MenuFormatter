package com.restaurant;

import com.restaurant.Exceptions.MenuException;
import com.restaurant.Menu.DailyMenu;
import com.restaurant.Menu.InputFromFile;
import com.restaurant.Menu.OutputToFile;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        InputFromFile menuInput = new InputFromFile();
        OutputToFile menuOutput = new OutputToFile();


        try {
            menuInput.readFromFile("E:/Coding/Projects/MenuFormatter/src/main/java/com/restaurant/Files/menu_original.txt");
        } catch (MenuException e) {
            System.err.println("Chyba > " + e.getMessage());
        }

        List<DailyMenu> weeklyMenu = menuInput.getWeeklyMenu();

        for (DailyMenu menu : weeklyMenu ) {
            System.out.println(menu);
        }

        try {
            menuOutput.exportToFile(weeklyMenu,"E:/Coding/Projects/MenuFormatter/src/main/java/com/restaurant/Files/menu_formatted.txt");
        } catch (MenuException e) {
            System.err.println("Chyba > " + e.getMessage());;
        }


    }
}