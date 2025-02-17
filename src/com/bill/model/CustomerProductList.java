package com.bill.model;

public class CustomerProductList {
    private String pname;
    private int qty;

    public String getPname() {
        return pname;
    }

    public void setPname(String pname) {
        this.pname = pname;
    }

    public CustomerProductList(String pname, int qty) {
        this.pname = pname;
        this.qty = qty;
    }

    public int getQty() {
        return qty;
    }

    public void setQty(int qty) {
        this.qty = qty;
    }
}
