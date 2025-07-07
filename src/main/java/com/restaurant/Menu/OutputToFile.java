package com.restaurant.Menu;

import com.restaurant.Exceptions.MenuException;
import com.restaurant.Models.DailyMenu;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class OutputToFile {

    static String exportRozvozFile = "src/main/resources/Files/menu_rozvozy.txt";
    static String exportStoriesFile = "src/main/resources/Files/menu_stories.txt";

    public void exportToFile(List<DailyMenu> weeklyMenu, String exportPath) throws MenuException {

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(exportPath, false))) {
            for (DailyMenu menu : weeklyMenu) {
                if (exportPath.equals(exportRozvozFile)){
                writer.write(menu.toRozvozFormat());
                writer.write("\n");
                }
                else if (exportPath.equals(exportStoriesFile)) {
                    writer.write(menu.toStoriesFormat());
                    writer.write("\n");
                }
            }
        } catch (IOException e) {
            throw new MenuException("Chyba při zápisu do souboru" + e.getMessage());
        }
    }
}

