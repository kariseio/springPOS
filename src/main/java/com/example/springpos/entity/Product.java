package com.example.springpos.entity;

public class Product {
    private int p_code;
    private String p_name;
    private int p_quantity;
    private int p_price;

    public Product(String p_name, int p_quantity, int p_price) {
        this.p_name = p_name;
        this.p_quantity = p_quantity;
        this.p_price = p_price;
    }

    public Product(int p_code, String p_name, int p_quantity, int p_price) {
        this.p_code = p_code;
        this.p_name = p_name;
        this.p_quantity = p_quantity;
        this.p_price = p_price;
    }

    public int getP_code() {
        return p_code;
    }

    public String getP_name() {
        return p_name;
    }

    public void setP_name(String p_name) {
        this.p_name = p_name;
    }

    public int getP_quantity() {
        return p_quantity;
    }

    public void setP_quantity(int p_quantity) {
        this.p_quantity = p_quantity;
    }

    public int getP_price() {
        return p_price;
    }

    public void setP_price(int p_price) {
        this.p_price = p_price;
    }
}
