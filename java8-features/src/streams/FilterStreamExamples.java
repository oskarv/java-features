package streams;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.stream.Stream;

public class FilterStreamExamples {

    public static void main (String [] argv) {
        List<String> people = Arrays.asList("Oskar", "Brad", "Pit", "Messi");

        Stream<String> peopleStream = people.stream();
        Consumer<String> printConsumer = System.out::println;

        // Print all data from the stream
        System.out.println("========================**========================");
        System.out.println("print all data from the stream");
        peopleStream.forEach(printConsumer);

        Predicate<String> containsPredicate = str -> str.contains("a");
        Predicate<String> containsAdditionalPredicate = str -> str.contains("s");
        peopleStream = people.stream();
        Stream<String> filteredPeopleStream = peopleStream.filter(containsPredicate.or(containsAdditionalPredicate));

        // print filtered stream, string are filtered on predicate whether they contain latter "a" or letter "s"
        System.out.println("========================**========================");
        System.out.println("print filtered stream, string are filtered on predicate whether they contain latter \"a\" or letter \"s\"");
        filteredPeopleStream.forEach(printConsumer);
    }
}
