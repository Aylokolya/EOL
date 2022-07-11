package com.demo.entity;

public class Item {
    private Integer id;

    private Integer qid;

    private String itema;

    private String itemb;

    private String itemc;

    private String itemd;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getQid() {
        return qid;
    }

    public void setQid(Integer qid) {
        this.qid = qid;
    }

    public String getItema() {
        return itema;
    }

    public void setItema(String itema) {
        this.itema = itema == null ? null : itema.trim();
    }

    public String getItemb() {
        return itemb;
    }

    public void setItemb(String itemb) {
        this.itemb = itemb == null ? null : itemb.trim();
    }

    public String getItemc() {
        return itemc;
    }

    public void setItemc(String itemc) {
        this.itemc = itemc == null ? null : itemc.trim();
    }

    public String getItemd() {
        return itemd;
    }

    public void setItemd(String itemd) {
        this.itemd = itemd == null ? null : itemd.trim();
    }
}