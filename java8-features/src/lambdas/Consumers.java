package lambdas;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;

public class Consumers {

    public static void main (String [] argv) {
        List<String> names = Arrays.asList("Oskar", "Robert Martin", "Martin Fowler");

        // using standard Consumer Lambda
        System.out.println("using standard Consumer Lambda");
        names.forEach(name -> System.out.println(name));

        System.out.println("========================**========================");

        // using method reference (shorter, more readable syntax)
        System.out.println("using method reference (shorter, more readable syntax)");
        names.forEach(System.out::println);

        System.out.println("========================**========================");

        List<String> resultNames = new ArrayList<>();

        Consumer<String> printConsumer = System.out::println;
        Consumer<String> insertConsumer = resultNames::add; // or: insertConsumer = name -> resultNames.add(name);

        System.out.println("chain consumers, one prints other inserts into another collection");
        names.forEach(printConsumer.andThen(insertConsumer));

        System.out.println("========================**========================");
        System.out.println("Result array");

        resultNames.forEach(System.out::println);
    }
}
