package com.restaurant.Menu;

import com.restaurant.Exceptions.MenuException;
import com.restaurant.Models.DailyMenu;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class OutputToFile {

    public void exportToFile(List<DailyMenu> weeklyMenu, String exportPath) throws MenuException {

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(exportPath, false))) {
            for (DailyMenu menu : weeklyMenu) {
                writer.write(menu.toString());
                writer.write("\n");
            }
        } catch (IOException e) {
            throw new MenuException("Chyba při zápisu do souboru" + e.getMessage());
        }
    }
}

