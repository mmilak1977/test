package com.example.agnieszka.kompetencyjny;

import java.util.Date;

/**
 * Created by DELL on 2015-06-07.
 */
public class MyVisit {

    private int drawableId;
    private String titleVisit;
    private String dateVisit;
    private String hourVisit;

    //private String placeVisit;

    public MyVisit(int id, String title, String date, String hour)
    {
        super();
        drawableId = id;
        titleVisit = title;
        dateVisit = date;
        hourVisit = hour;
    }

    public String getTitleVisit() {
        return titleVisit;
    }

    public void setTitleVisit(String titleVisit) {
        this.titleVisit = titleVisit;
    }

    public String getDateVisit() {
        return dateVisit;
    }

    public void setDateVisit(String dateVisit) {
        this.dateVisit = dateVisit;
    }

    public String getHourVisit() {
        return hourVisit;
    }

    public void setHourVisit(String hourVisit) {
        this.hourVisit = hourVisit;
    }

    public int getDrawableId() {
        return drawableId;
    }

    public void setDrawableId(int drawableId) {
        this.drawableId = drawableId;
    }
}
