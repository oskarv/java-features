package generics.buffer;

public interface Buffer<T> {

    boolean offer(T value);

    T poll();

    int next(int index);
}
