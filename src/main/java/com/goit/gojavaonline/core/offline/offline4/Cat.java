package com.goit.gojavaonline.core.offline.offline4;

public class Cat {
    @JsonField("catName")
    private String catName;

    public Cat() {

    }

    public Cat(String catName) {
        this.catName = catName;
    }

    public String getCatName() {
        return catName;
    }

    public void setCatName(String catName) {
        this.catName = catName;
    }
}
