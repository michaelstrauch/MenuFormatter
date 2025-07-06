package com.restaurant;

import com.restaurant.Exceptions.MenuException;
import com.restaurant.Models.DailyMenu;
import com.restaurant.Menu.InputFromFile;
import com.restaurant.Menu.OutputToFile;

import java.util.List;

public class Main {
    public static void main(String[] args) {

        String importFile = "src/main/resources/Files/menu_original.txt";
        String exportFile = "src/main/resources/Files/menu_formatted.txt";
        InputFromFile menuInput = new InputFromFile();
        OutputToFile menuOutput = new OutputToFile();
        List<DailyMenu> weeklyMenu = menuInput.getWeeklyMenu();


        try {
            menuInput.readFromFile(importFile);
        } catch (MenuException e) {
            System.err.println("Chyba > " + e.getMessage());
        }

        try {
            menuOutput.exportToFile(weeklyMenu,exportFile);
        } catch (MenuException e) {
            System.err.println("Chyba > " + e.getMessage());
        }


    }
}