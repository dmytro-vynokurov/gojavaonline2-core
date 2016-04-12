package com.goit.gojavaonline.core.offline.offline4;

import java.util.List;

public class Dog {

    @JsonField("name")
    private String name;

    @JsonField("BREED")
    private String breed;

    private int age;

    @JsonField("kids")
    private List<Integer> kids;

    @JsonField("cat")
    private Cat cat;

    public Dog() {
    }

    public Dog(String name, int age, String breed) {
        this.age = age;
        this.breed = breed;
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBreed() {
        return breed;
    }

    public void setBreed(String breed) {
        this.breed = breed;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public List<Integer> getKids() {
        return kids;
    }

    public void setKids(List<Integer> kids) {
        this.kids = kids;
    }

    public Cat getCat() {
        return cat;
    }

    public void setCat(Cat cat) {
        this.cat = cat;
    }

    @Override
    public String toString() {
        return "Dog{" +
                "age=" + age +
                ", name='" + name + '\'' +
                ", breed='" + breed + '\'' +
                ", kids=" + kids +
                ", cat=" + cat +
                '}';
    }
}
