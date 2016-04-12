package com.goit.gojavaonline.core.offline.offline4;

public class Runner {

    private static JsonConverter jsonConverter = new JsonConverter();

    public static void main(String[] args) {
        Dog dog = new Dog("Bobby", 7, "Doberman");
//        dog.setKids(Arrays.asList(1, 2, 3));
//        dog.setCat(new Cat("cat34"));

        System.out.println(dog);

        String json = jsonConverter.convertToJson(dog);

        System.out.println(json);

        Dog deserializedDog = jsonConverter.parseJson(json, Dog.class);

        System.out.println(deserializedDog);
    }
}