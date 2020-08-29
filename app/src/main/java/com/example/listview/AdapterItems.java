package com.example.listview;

public class AdapterItems {
    public int ID;
    public String JobTitle;
    public String Description;
    //for new detlails
    AdapterItems(int ID, String JobTitle, String Description)
    {
        this.ID=ID;
        this.JobTitle=JobTitle;
        this.Description=Description;
    }
}
