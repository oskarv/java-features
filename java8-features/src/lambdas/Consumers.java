package lambdas;

import java.util.Arrays;
import java.util.List;

public class Consumers {

    public static void main (String [] argv) {
        List<String> names = Arrays.asList("Oskar", "Robert Martin", "Martin Fowler");

        // using standard Consumer Lambda
        names.forEach(name -> System.out.println(name));

        System.out.println("========================**========================");

        // using method reference (shorter, more readable syntax)
        names.forEach(System.out::println);
    }
}
