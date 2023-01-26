package com.ws18.loveCalculator.model;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URLDecoder;

import jakarta.json.JsonReader;
import jakarta.json.Json;
import jakarta.json.JsonObject;

public class LoveCouple {
    
    private String sname;
    private String fname;
    private Integer percentage;
    private String result;


    // contructors for LoveCouple
    public LoveCouple(String json) throws IOException {
        updateCouple(json);
    }

    public LoveCouple(String sname, String fname) {
        this.sname = sname;
        this.fname = fname;
    }

    public LoveCouple(String sname, String fname, Integer percentage, String result) {
        this.sname = sname;
        this.fname = fname;
        this.percentage = percentage;
        this.result = result;
    }

    // 
    public void updateCouple(String json) throws IOException {
        // creating 
        try(InputStream is = new ByteArrayInputStream(json.getBytes())){
            JsonReader r = Json.createReader(is); // create reader from byte stream
            JsonObject o = r.readObject(); // coverts json reader to json object

            String fname = o.getString("fname");
            String sname = o.getString("sname");
            String result = o.getString("result");
            Integer percentage = Integer.parseInt(o.getString("percentage"));
            
            // remove enccoding chars from name input (prevent invalid)
            fname = URLDecoder.decode(fname, "UTF-8");
            sname = URLDecoder.decode(sname, "UTF-8");

            setFname(fname);
            setSname(sname);
            setResult(result);
            setPercentage(percentage);
            
        }
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

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    @Override
    public String toString() {
        return "LoveCouple [sname=" + sname + ", fname=" + fname + ", percentage=" + percentage + ", result=" + result
                + "]";
    }

}
