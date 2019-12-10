package generics.buffer;

public class MainBuffer {

    public static void main (String [] argv) {
        Buffer<String> stringBuffer = new CircularBuffer<>(10);

        stringBuffer.offer("Oskar \n");
        stringBuffer.offer("Oskarelo \n");
        stringBuffer.offer("Oscar \n");

        StringBuilder stringBuilder = new StringBuilder();
        String value = stringBuffer.poll();

        while (value != null) {
            stringBuilder.append(value);
            value = stringBuffer.poll();
        }

        System.out.println(stringBuilder);
    }
}
