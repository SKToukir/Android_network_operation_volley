package com.example.toukir.networkoperation;

/**
 * Created by toukir on 3/23/16.
 */
public class NoticeItems {

    private String title;
    private String details;
    private String date;

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public NoticeItems(String title, String details,String date) {
        this.title = title;
        this.details = details;
        this.date = date;
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
