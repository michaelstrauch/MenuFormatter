package com.restaurant.Models;

import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFParagraph;
import org.apache.poi.xwpf.usermodel.XWPFRun;

import java.util.ArrayList;
import java.util.List;

public class DailyMenu {

    String day;
    String soupName;
    String soupDescription;
    List<MenuModel> menu;

    public DailyMenu(String day, String soupName, String soupDescription) {
        this.soupDescription = soupDescription;
        this.soupName = soupName;
        this.day = day;
        this.menu = new ArrayList<>();
    }

    public String getDay() {
        return day;
    }

    public void setDay(String day) {
        this.day = day;
    }

    public List<MenuModel> getMenu() {
        return menu;
    }

    public void setMenu(List<MenuModel> menu) {
        this.menu = menu;
    }

    public void addToDailyMenu(MenuModel singleMenu) {
        menu.add(singleMenu);
    }

    public String toRozvozFormat() {
        StringBuilder sb = new StringBuilder();
        sb.append(day).append("\n");
        for (MenuModel meal : menu) {
            sb.append(meal.toRozvozFormat()).append("\n");
        }
        return sb.toString();
    }

    public XWPFDocument toStoriesFormat(XWPFDocument doc) {
        XWPFParagraph par1 = doc.createParagraph();
        XWPFRun r1 = par1.createRun();
        r1.setText(day);

        XWPFParagraph par2 = doc.createParagraph();
        XWPFRun r2 = par2.createRun();
        r2.setText(soupName);
        r2.addBreak();
        r2.setText(soupDescription);

        XWPFParagraph par3 = doc.createParagraph();
        for (MenuModel meal : menu) {
           meal.menuToStoriesFormat(doc);
        }
        XWPFParagraph par4 = doc.createParagraph();
        return doc;

//        StringBuilder sb = new StringBuilder();
//        sb.append(day).append("\n\n")
//                .append(soupName).append("\r")
//                .append(soupDescription).append("\n\n");
//        for (MenuModel meal : menu) {
//            sb.append(meal.toStoriesFormat()).append("\n");
//        }
//        return sb.toString();
    }
}


