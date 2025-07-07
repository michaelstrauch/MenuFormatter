package com.restaurant.Menu;

import com.restaurant.Exceptions.MenuException;
import com.restaurant.Models.DailyMenu;
import com.restaurant.Models.MenuModel;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.*;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class InputFromFile {

    List<DailyMenu> weeklyMenu = new ArrayList<>();


    public List<DailyMenu> getWeeklyMenu() {
        return weeklyMenu;
    }

    public void readFromFile(String inputFile) throws MenuException {
        Pattern soupPattern = Pattern.compile("^([A-Z ]+)\\s+(.+)");
        Pattern mealPattern = Pattern.compile("^(\\d+\\.)\\s+([A-Z ]+)\\s+(.+)");
        String soup = "";
        String currentDay;
        DailyMenu currentMenu = null;
        try (Scanner reader = new Scanner(new BufferedReader(new FileReader(inputFile)))) {
            while (reader.hasNextLine()) {
                String line = reader.nextLine();
                if (line != null && line.matches("^Pondělí|Úterý|Středa|Čtvrtek|Pátek$")) {
                    currentDay = line;
                    soup = reader.nextLine();
                    Matcher soupMatcher = soupPattern.matcher(soup);
                    if (soupMatcher.find()) {
                        String soupName = soupMatcher.group(1);
                        String soupDesc = soupMatcher.group(2);
                        currentMenu = new DailyMenu(currentDay,soupName,soupDesc);
                    }
//                    currentMenu = new DailyMenu(currentDay);
                    weeklyMenu.add(currentMenu);
                } else {
                    Matcher mealMatcher = mealPattern.matcher(line);
                    if (mealMatcher.find()) {
                        String number = mealMatcher.group(1);
                        String title = mealMatcher.group(2).trim();
                        String description = mealMatcher.group(3).trim();
                        MenuModel menu = new MenuModel(title, description, number);
                        if (currentMenu != null) {
                            currentMenu.addToDailyMenu(menu);
                        }

                    }
                }
            }
        } catch (FileNotFoundException e) {
            throw new MenuException("Chyba při čtení souboru: " + e.getMessage());
        }
    }
}
