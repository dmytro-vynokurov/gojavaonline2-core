package com.goit.gojavaonline.core.offline.offline2.mylist;



//import java.util.LinkedList;

abstract class Animal<T extends Animal>{
    String name;

    public Animal(String name) {
        this.name = name;
    }
    public abstract String say();

    public abstract String meet(T other);
}

class Dog extends Animal<Dog> implements Comparable<Dog>{
    public Dog(String name) {
        super(name);
    }

    @Override
    public String say() {
        return "bow-wow";
    }

    @Override
    public String meet(Dog otherDog) {
        return this+ " dog sniffs "+otherDog;
    }

    @Override
    public String toString() {
        return "Dog{" +
                "name='" + name + '\'' +
                '}';
    }

    @Override
    public int compareTo(Dog o) {
        return 0;
    }
}

class Cat extends Animal<Cat>{
    public Cat(String name) {
        super(name);
    }

    @Override
    public String say() {
        return "meow";
    }

    @Override
    public String meet(Cat otherCat) {
        return this+" cat met "+otherCat;
    }


    @Override
    public String toString() {
        return "Cat{" +
                "name='" + name + '\'' +
                '}';
    }

}


public class ListRunner {
    public static void main(String[] args) {
        LinkedList<Cat> cats = new LinkedList<>();
        cats.add(new Cat("1"));
        cats.add(new Cat("2"));
        cats.add(new Cat("3"));

        LinkedList<Dog> dogs = new LinkedList<>();
        dogs.add(new Dog("1"));
        dogs.add(new Dog("2"));
        dogs.add(new Dog("3"));

        printList(cats);
        printList(dogs);

    }

    private static <T extends Animal<T>> void printList(LinkedList<T> animals) {
        for (int i = 0; i < animals.size(); i++) {
            T animal = animals.get(i);
            String greeting = animal.say();
            System.out.println(animal+" says "+greeting);
            if(i>=1) {
                T previous = animals.get(i - 1);
                String meetResult = animal.meet(previous);
                System.out.println(meetResult);
            }
        }
    }
}
