package com.restaurant;

import com.restaurant.Exceptions.MenuException;
import com.restaurant.Models.DailyMenu;
import com.restaurant.Menu.InputFromFile;
import com.restaurant.Menu.OutputToFile;

import java.util.List;

public class Main {
    public static void main(String[] args) {

        String importFile = "src/main/resources/Files/menu_original.txt";
        String exportRozvozFile = "src/main/resources/Files/menu_rozvozy.txt";
        String exportStoriesFile = "src/main/resources/Files/menu_stories.txt";

        InputFromFile menuInput = new InputFromFile();
        OutputToFile menuOutput = new OutputToFile();
        List<DailyMenu> weeklyMenu = menuInput.getWeeklyMenu();


        try {
            menuInput.readFromFile(importFile);
        } catch (MenuException e) {
            System.err.println("Chyba > " + e.getMessage());
        }

        try {
            menuOutput.exportToFile(weeklyMenu, exportRozvozFile);
        } catch (MenuException e) {
            System.err.println("Chyba > " + e.getMessage());
        }

        try {
            menuOutput.exportToFile(weeklyMenu,exportStoriesFile);
        } catch (MenuException e) {
            System.err.println("Chyba > " + e.getMessage());
        }


    }
}