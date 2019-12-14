package generics.inheritance;

public class SortedPair<T extends Comparable<T>> {
    private T first;
    private T second;

    SortedPair (T obj1, T obj2) {
        if (obj1.compareTo(obj2) > 0) {
            first = obj1;
            second = obj2;
        }
        else {
            first = obj2;
            second = obj1;
        }
    }

    @Override
    public String toString() {
        return "first: " + getFirst() + "; second: " + getSecond() + ";";
    }

    public T getFirst() {
        return first;
    }

    public T getSecond() {
        return second;
    }
}
