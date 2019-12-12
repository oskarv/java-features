package generics.collections;

import generics.collections.dto.Person;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class CollectionsExamples {

    public static void main (String [] argv) {
        Person oskar = new Person("Oskar", 24);
        Person oskarelo = new Person("Oskarelo", 24);

        List<Person> people = Arrays.asList(oskar, oskarelo);
        System.out.println(people);

        System.out.println("*******************************************************");

        Iterator<Person> personIterator = people.iterator();
        while (personIterator.hasNext()) {
            System.out.println(personIterator.next());
        }

        System.out.println("*******************************************************");

        Consumer<Person> printConsumer = System.out::println;
        Predicate<Person> containsPredicate = person -> person.getName().contains("elo");
        people.stream().filter(containsPredicate).forEach(printConsumer);

        System.out.println("II-------------------------------------------------II");
        System.out.println("II-----------------------MAPS----------------------II");
        System.out.println("II-------------------------------------------------II");

        Map<Integer, List<Person>> peopleMap = people.stream().collect(Collectors.groupingBy(Person::getAge));
        Predicate<Map.Entry<Integer, List<Person>>> entryPredicate = entry -> entry.getKey() == 24;
        Consumer<Map.Entry<Integer, List<Person>>> entryPrintConsumer = System.out::println;
        peopleMap.entrySet().stream().filter(entryPredicate).forEach(entryPrintConsumer);
    }
}
