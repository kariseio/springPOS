package com.example.springpos.entity;

import java.sql.Timestamp;

public class Sale {
    private int s_code;
    private String s_pname;
    private Timestamp s_date;
    private int s_quantity;
    private int s_price;

    public Sale(String s_pname, Timestamp s_date, int s_quantity, int s_price) {
        this.s_pname = s_pname;
        this.s_date = s_date;
        this.s_quantity = s_quantity;
        this.s_price = s_price;
    }

    public Sale(int s_code, String s_pname, Timestamp s_date, int s_quantity, int s_price) {
        this.s_code = s_code;
        this.s_pname = s_pname;
        this.s_date = s_date;
        this.s_quantity = s_quantity;
        this.s_price = s_price;
    }

    public int getS_code() {
        return s_code;
    }

    public String getS_pname() {
        return s_pname;
    }

    public void setS_pname(String s_pname) {
        this.s_pname = s_pname;
    }

    public Timestamp getS_date() {
        return s_date;
    }

    public void setS_date(Timestamp s_date) {
        this.s_date = s_date;
    }

    public int getS_quantity() {
        return s_quantity;
    }

    public void setS_quantity(int s_quantity) {
        this.s_quantity = s_quantity;
    }

    public int getS_price() {
        return s_price;
    }

    public void setS_price(int s_price) {
        this.s_price = s_price;
    }
}
