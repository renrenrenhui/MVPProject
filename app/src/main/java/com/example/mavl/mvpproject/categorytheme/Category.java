package com.example.mavl.mvpproject.categorytheme;

public class Category {
    private String name;
    private String icon;
    private String des;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public String getDes() {
        return des;
    }

    public void setDes(String des) {
        this.des = des;
    }

    public Category(String name, String icon, String des) {
        this.name = name;
        this.icon = icon;
        this.des = des;
    }
}
