package generics.lambdas;

import generics.collections.dto.Person;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class Lambdas {

    public static void main(String [] argv) {
        Person oskar = new Person("Oskar", 24);
        Person rade = new Person("Jovan", 87);
        Person pera = new Person("Pera", 75);
        List<Person> people = Arrays.asList(oskar, rade, pera);

        Predicate<Person> isOlderThan50 = person -> person.getAge() > 50;
        Map<Boolean, List<Person>> predicatedResult = people.stream().collect(Collectors.partitioningBy(isOlderThan50));
        System.out.println(predicatedResult);

        System.out.println("------------------------------------------------****------------------------------------------------");
        System.out.println("------------------------------------------------****------------------------------------------------");

        Map<Boolean, Long> countingResult = people.stream().collect(Collectors.partitioningBy(isOlderThan50, Collectors.counting()));
        System.out.println(countingResult);
    }
}
