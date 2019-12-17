package generics.inheritance;

import generics.collections.dto.Employee;
import generics.collections.dto.Person;

import java.util.Collections;
import java.util.List;
import java.util.function.Consumer;

public class Wildcards {

    public static void main (String [] argv) {
        Person oskar = new Person("oskar", 25);
        List<Person> people = Collections.singletonList(oskar);
        printAll(people);

        Employee oskarelo = new Employee("oskarelo", 25);
        List<Employee> employees = Collections.singletonList(oskarelo);
        printAll(employees);

        printOne(people);
    }

    private static void printAll(List<? extends Person> listToPrint) {
        System.out.println("0-----------------------------------------------------------0");
        Consumer<Person> printConsumer = System.out::println;;
        listToPrint.forEach(printConsumer);
        System.out.println("0-----------------------------------------------------------0");
    }

    private static void printOne(List<? super Employee> objectToPrint) {
        System.out.println("\n");
        System.out.println(objectToPrint);
        System.out.println("_____________________________________________________________");
    }
}
