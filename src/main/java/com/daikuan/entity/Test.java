package com.daikuan.entity;

public class Test {
    private Integer id;

    private String war;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getWar() {
        return war;
    }

    public void setWar(String war) {
        this.war = war == null ? null : war.trim();
    }
}