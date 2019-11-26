package lambdas;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Comparators {

    static class OldSchoolComparator implements Comparator<String> {
        @Override
        public int compare(String firstString, String secondString) {
            return Integer.compare(firstString.length(), secondString.length());
        }
    }

    public static void main (String [] argv) {
        List<String> listOfStrings = Arrays.asList("**", "****", "*", "***");

        // Old school way, create separate class and use it across the project
        Comparator<String> oldStringComparator = new OldSchoolComparator();
        listOfStrings.sort(oldStringComparator);
        System.out.println(listOfStrings.toString());

        // anonymous class approach is valid if you need this type of comparator only once
        listOfStrings = Arrays.asList("**", "****", "*", "***");
        Comparator<String> anonymousComparator = new Comparator<String>() {
            @Override
            public int compare(String s1, String s2) {
                return Integer.compare(s1.length(), s2.length());
            };
        };
        listOfStrings.sort(anonymousComparator);
        System.out.println(listOfStrings.toString());

        // lambda way, better ( more readable ) way of using anonymous classes
        listOfStrings = Arrays.asList("**", "****", "*", "***");
        Comparator<String> lambaComparator = (String s1, String s2) -> Integer.compare(s1.length(), s2.length());
        listOfStrings.sort(lambaComparator);
        System.out.println(listOfStrings);
    }
}
