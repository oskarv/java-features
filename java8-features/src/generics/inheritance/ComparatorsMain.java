package generics.inheritance;

import generics.collections.dto.Person;

import java.util.Arrays;
import java.util.List;

public class ComparatorsMain {

    public static void main (String [] argv) {
        Person oskar = new Person("Oskar", 25);
        Person oskarelo = new Person("Oskarelo", 24);
        List<Person> people = Arrays.asList(oskar, oskarelo);
        System.out.println(people);

        System.out.println("00----------------------------------------------------------00");
        people.sort(new AgeComparator());
        System.out.println(people);
        System.out.println("00----------------------------------------------------------00");

        people.sort(new ReverseComparator<Person>(new AgeComparator()));
        System.out.println(people);
        System.out.println("00----------------------------------------------------------00");
    }
}
