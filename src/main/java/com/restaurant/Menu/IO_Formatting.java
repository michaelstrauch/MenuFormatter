package com.restaurant.Menu;

import com.restaurant.Exceptions.MenuException;

import java.awt.*;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.*;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class IO_Formatting {

    List<MenuModel> dailyMenu = new ArrayList<>();

    public List<MenuModel> dailyMenu() {
        return dailyMenu;
    }

    public void readFromFile(String inputFile) throws MenuException {
        Pattern pattern = Pattern.compile("^(\\d+\\.)\\s+([A-Z ]+)\\s+(.+) –\\s*(\\d+,-)");
        String soup = "";
        String currentDay = "";
        try (Scanner reader = new Scanner(new BufferedReader(new FileReader(inputFile)))) {
            while (reader.hasNextLine()) {
                String line = reader.nextLine();
                if (line != null && line.matches("^Pondělí|Úterý|Středa|Čtvrtek|Pátek$")) {
                    currentDay = line;
                    soup = reader.nextLine();
                } else {
                    Matcher matcher = pattern.matcher(line);
                    if (matcher.find()) {
                        String number = matcher.group(1);
                        String title = matcher.group(2).trim();
                        String description = matcher.group(3).trim();
                        String price = matcher.group(4);
                        MenuModel menu = new MenuModel(currentDay, soup, title, description, price, number);
                        dailyMenu.add(menu);
                    }
                }
            }
        } catch (FileNotFoundException e) {
            throw new MenuException("Chyba při čtení souboru: " + e.getMessage());
        }
    }
}
