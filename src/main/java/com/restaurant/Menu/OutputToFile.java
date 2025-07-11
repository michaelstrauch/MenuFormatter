package com.restaurant.Menu;

import com.restaurant.Exceptions.MenuException;
import com.restaurant.Models.DailyMenu;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFParagraph;
import org.apache.poi.xwpf.usermodel.XWPFRun;


import java.io.*;
import java.util.List;


public class OutputToFile {


    static String exportRozvozFile = "src/main/resources/Files/menu_rozvozy.txt";
    static String exportStoriesFile = "src/main/resources/Files/menu_stories.txt";
    static String storiesTestFile = "src/main/resources/Files/test.docx";

    public void exportToFile(List<DailyMenu> weeklyMenu, String exportPath) throws MenuException {

        try (FileOutputStream output = new FileOutputStream(storiesTestFile)) {
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
    }
}

//        try (BufferedWriter writer = new BufferedWriter(new FileWriter(exportPath, false))) {
//
//            for (DailyMenu menu : weeklyMenu) {
//                if (exportPath.equals(exportRozvozFile)){
//                writer.write(menu.toRozvozFormat());
//                writer.write("\n");
//                }
//                else if (exportPath.equals(exportStoriesFile)) {
//                    writer.write(menu.toStoriesFormat());
//                    writer.write("\n");
//                }
//            }
//        } catch (IOException e) {
//            throw new MenuException("Chyba při zápisu do souboru" + e.getMessage());
//        }
//    }
//}

