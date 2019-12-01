package streams;

import java.util.Arrays;
import java.util.List;
import java.util.function.Function;

public class MapStreamExamples {

    public static void main (String [] argv) {
        List<String> people = Arrays.asList("Oskar", "Brad", "Pit", "Messi");

        Function<String, Integer> length = String::length;

        // map the stream into lengths of string inputs and print result
        System.out.println("map the stream into lengths of string inputs and print result");
        people.stream()
                .map(length) // or this:  .map(String::length)
                .forEach(System.out::println);

        // flatMap handles cases where mappings returns Stream type object
    }
}
