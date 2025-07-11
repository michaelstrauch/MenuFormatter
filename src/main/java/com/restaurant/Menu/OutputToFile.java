package com.restaurant.Menu;

import com.restaurant.Exceptions.MenuException;
import com.restaurant.Models.DailyMenu;
import org.apache.poi.xwpf.usermodel.XWPFDocument;

import java.io.*;
import java.util.List;


public class OutputToFile {


    static String exportRozvozFile = "src/main/resources/Files/menu_rozvozy.txt";
    static String exportStoriesFile = "src/main/resources/Files/menu_stories.docx";
    static String exportWebpageFile = "src/main/resources/Files/menu_web.txt";


    public void exportToFile(List<DailyMenu> weeklyMenu, String exportPath) throws MenuException {


        if (exportPath.equals(exportStoriesFile)) {
            try (FileOutputStream output = new FileOutputStream(exportStoriesFile)) {
                XWPFDocument fullDoc = new XWPFDocument();
                for (DailyMenu menu : weeklyMenu) {
                    menu.toStoriesFormat(fullDoc);
                }
                fullDoc.write(output);
            } catch (FileNotFoundException e) {
                throw new MenuException("Chyba při zápisu do souboru" + e.getMessage());
            } catch (IOException e) {
                throw new MenuException("Chyba při zápisu do souboru" + e.getMessage());
            }
        } else if (exportPath.equals(exportRozvozFile)) {
            try (BufferedWriter writer = new BufferedWriter(new FileWriter(exportPath, false))) {

                for (DailyMenu menu : weeklyMenu) {
                    writer.write(menu.toRozvozFormat());
                    writer.write("\n");
                }
            } catch (IOException e) {
                throw new MenuException("Chyba při zápisu do souboru" + e.getMessage());
            }
        } else if (exportPath.equals(exportWebpageFile)) {
            try (BufferedWriter writer = new BufferedWriter(new FileWriter(exportPath, false))) {

                for (DailyMenu menu : weeklyMenu) {
                    writer.write(menu.toWebpageFormat());
                    writer.write("\n");
                }
            } catch (IOException e) {
                throw new MenuException("Chyba při zápisu do souboru" + e.getMessage());
            }
        }
    }
}


