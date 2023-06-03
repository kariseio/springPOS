package com.example.springpos.entity;

import java.sql.Timestamp;

public class Receive {
    private int re_code;
    private int p_code;
    private Timestamp re_date;
    private int re_quantity;

    public Receive(int p_code, Timestamp re_date, int re_quantity) {
        this.p_code = p_code;
        this.re_date = re_date;
        this.re_quantity = re_quantity;
    }

    public int getP_code() {
        return p_code;
    }

    public void setP_code(int p_code) {
        this.p_code = p_code;
    }

    public Timestamp getRe_date() {
        return re_date;
    }

    public void setRe_date(Timestamp re_date) {
        this.re_date = re_date;
    }

    public int getRe_quantity() {
        return re_quantity;
    }

    public void setRe_quantity(int re_quantity) {
        this.re_quantity = re_quantity;
    }
}
