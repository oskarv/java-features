package generics.buffer;

public class CircularBuffer<T> implements Buffer<T> {
    private T [] buffer;
    private int readCursor = 0;
    private int writeCursor = 0;

    public CircularBuffer(int size) {
        buffer = (T[]) new Object[size];
    }

    @Override
    public boolean offer(T value) {
        if (buffer[writeCursor] != null) {
            return false;
        }

        buffer[writeCursor] = value;
        writeCursor = next(writeCursor);
        return true;
    };

    @Override
    public T poll() {
        T value = buffer[readCursor];
        if (value == null) {
            return null;
        }

        buffer[readCursor] = null;
        readCursor = next(readCursor);
        return value;
    }

    @Override
    public int next(int index) {
        return (index + 1) % buffer.length;
    }
}
