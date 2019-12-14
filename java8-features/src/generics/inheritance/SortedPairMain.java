package generics.inheritance;

public class SortedPairMain {

    public static void main(String [] argv) {
        System.out.println(new SortedPair<Integer>(7, 8));
        System.out.println(new SortedPair<Integer>(77, 7));
        System.out.println(new SortedPair<String>("iii", "ooo"));
    }
}
