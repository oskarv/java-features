package generics.inheritance;

import java.util.Comparator;

public class ReverseComparator<T> implements Comparator<T> {
    private Comparator<T> delegateTComparator;

    public ReverseComparator(Comparator<T> delegateTComparator) {
        this.delegateTComparator = delegateTComparator;
    }

    @Override
    public int compare(T o1, T o2) {
        return -1 * delegateTComparator.compare(o1, o2);
    }
}
