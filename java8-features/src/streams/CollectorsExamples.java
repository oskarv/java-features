package streams;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class CollectorsExamples {

    public static void main (String [] argv) {
        List<String> people = Arrays.asList("Oskar", "Brad", "Pit", "Messi");

        String names = people.stream().filter(name -> name.contains("a")).collect(Collectors.joining(", "));
        System.out.println(names);

        System.out.println("---------------------------------------------------------");

        Map<Integer, List<String>> peopleMap = people.stream().collect(Collectors.groupingBy(String::length));
        System.out.println(peopleMap);
    }
}
