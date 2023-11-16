package demo.generics.bounds;

import demo.generics.bounds.entries.Animal;
import demo.generics.bounds.entries.Cat;
import java.util.ArrayList;
import java.util.List;

@SuppressWarnings({"java:S1481", "java:S1854"})
public class GenericsInheritance {

    public static void main(String[] args) {

        Animal cat = new Cat();

        List<Cat> catList = new ArrayList<>();
        // List<Animal> animalList = catList; //ошибка
    }
}
