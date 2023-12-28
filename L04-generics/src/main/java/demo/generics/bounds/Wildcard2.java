package demo.generics.bounds;

import demo.generics.bounds.entries.Cat;
import java.util.ArrayList;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@SuppressWarnings({"unchecked", "rawtypes", "java:S125", "java:S1144"})
public class Wildcard2 {
    private static final Logger logger = LoggerFactory.getLogger(Wildcard2.class);

    public static void main(String[] args) {
        //
        //        List<Animal> animalList = new ArrayList<>();
        //        animalList.add(new Animal());
        //        printWild(animalList);

        List<Cat> catList = new ArrayList<>();
        catList.add(new Cat());
        // printWild(catList);
        printObj(catList);

        for (Cat cat : catList) {
            if (cat instanceof Cat) {
                logger.info(cat.getMyau());
            }
        }

        //        //левый тип данных
        List<String> stringList = new ArrayList<>();
        stringList.add("подкидыш");
        //        printWild(stringList);
        //
        //        //Можно еще и так
        //        List voidList = new ArrayList<>();
        //        voidList.add(LocalTime.now());
        //        printWild(voidList);
        //        printObj(voidList);

    }

    // Unbounded Wildcards
    private static void printWild(List<?> animalList) {
        // animalList.add("внезапно добавленная строка"); //ошибка
        animalList.forEach(val -> logger.info("{}", val));
    }

    private static void printObj(List animalList) {
        animalList.add("внезапно добавленная строка");
        //        animalList.forEach( System.out::println );
    }
}
