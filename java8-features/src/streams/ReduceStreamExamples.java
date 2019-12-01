package streams;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;

public class ReduceStreamExamples {

    public static void main (String [] argv) {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4);

        int sum = numbers.stream().reduce(0, Integer::sum);
        System.out.println("Sum: " + sum);

        int max = numbers.stream().reduce(-1, Integer::max);
        System.out.println("Max: " + max);

        Optional<Integer> maxWithMaxMethod = numbers.stream().max(Comparator.naturalOrder());
        System.out.println("Max: " + (maxWithMaxMethod.isPresent() ? maxWithMaxMethod.get() : "no max"));
    }
}
