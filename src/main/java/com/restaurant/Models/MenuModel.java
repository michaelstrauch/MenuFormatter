package com.restaurant.Models;

import com.restaurant.Exceptions.MenuException;
import org.apache.poi.xwpf.usermodel.ParagraphAlignment;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFParagraph;
import org.apache.poi.xwpf.usermodel.XWPFRun;

public class MenuModel {

    private String greekSoup;
    private String greekMainCourse;
    private String description;
    private String price;
    private String iD;

    public MenuModel(String greekSoup, String greekMainCourse, String description, String iD) {
        this.greekMainCourse = greekMainCourse;
        this.description = description;
        this.iD = iD;
        this.greekSoup = greekSoup;
    }

    public String getGreekSoup() {
        return greekSoup;
    }

    public void setGreekSoup(String greekSoup) {
        this.greekSoup = greekSoup;
    }

    public String getGreekMainCourse() {
        return greekMainCourse;
    }

    public void setGreekMainCourse(String greekMainCourse) {
        this.greekMainCourse = greekMainCourse;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getPrice() {
        return price;
    }

    public String setPrice() {
        switch (getID()) {
            case "1." -> price = ("175,-");
            case "2." -> price = ("185,-");
            case "3." -> price = ("195,-");
            case "4." -> price = ("205,-");
            case "5." -> price = ("215,-");
        }
        return price;
    }

    public String getID() {
        return iD;
    }

    public void setID(String iD) {
        this.iD = iD;
    }


    public String menuToRozvozFormat() {
        return iD + " " + greekMainCourse + " + polévka k menu" + "\n"
                  + description + ", " + greekSoup + "\n"
                  + setPrice();
    }

    public void menuToStoriesFormat(XWPFDocument menuDoc) {
        XWPFParagraph par1 = menuDoc.createParagraph();
        par1.setAlignment(ParagraphAlignment.CENTER);
        XWPFRun r1 = par1.createRun();
        r1.setText(iD + " " + greekMainCourse);
        r1.addBreak();
        r1.setText(description);
        r1.addBreak();
        r1.setText(setPrice());
    }

    public String menuToWebpageFormat() {
        return iD + " " + greekMainCourse + " " + description + " - " + setPrice();
    }
}
