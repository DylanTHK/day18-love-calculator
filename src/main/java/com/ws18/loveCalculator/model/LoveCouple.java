package com.ws18.loveCalculator.model;

public class LoveCouple {
    
    private String sname;
    private String fname;
    private Integer percentage;

    public LoveCouple(String sname, String fname) {
        this.sname = sname;
        this.fname = fname;
    }

    public String getSname() {
        return sname;
    }

    public void setSname(String sname) {
        this.sname = sname;
    }

    public String getFname() {
        return fname;
    }

    public void setFname(String fname) {
        this.fname = fname;
    }

    public Integer getPercentage() {
        return percentage;
    }

    public void setPercentage(Integer percentage) {
        this.percentage = percentage;
    }

}
