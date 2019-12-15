package generics.inheritance;

import generics.collections.dto.Person;

import java.util.Arrays;
import java.util.Comparator;
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

        Person min = min(people, new AgeComparator());
        System.out.println("Min is: " + min);
        System.out.println("00----------------------------------------------------------00");
    }

    public static <T> T min (List<T> values, Comparator<T> comparator) {
        if (values.isEmpty()) {
            throw new IllegalArgumentException("List of values is empty");
        }

        T min = values.get(0);

        for(T value : values) {
            if (comparator.compare(value, min) < 0) {
                min = value;
            }
        }

        return min;
    }
}
