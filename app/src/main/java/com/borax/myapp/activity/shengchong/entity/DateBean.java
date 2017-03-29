package com.borax.myapp.activity.shengchong.entity;

/**
 * Created by borax on 2017/2/27.
 */

public class DateBean {

    private int year;
    private int month;
    private int day;
    private int currentWeek;

    public DateBean(int year, int month, int day, int currentWeek) {
        this.year = year;
        this.month = month;
        this.day = day;
        this.currentWeek = currentWeek;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getMonth() {
        return month;
    }

    public void setMonth(int month) {
        this.month = month;
    }

    public int getDay() {
        return day;
    }

    public void setDay(int day) {
        this.day = day;
    }

    public int getCurrentWeek() {
        return currentWeek;
    }

    public void setCurrentWeek(int currentWeek) {
        this.currentWeek = currentWeek;
    }
}
