import java.util.List;
import java.util.ArrayList;

public class Queue {
    private final List<String> queue = new ArrayList<>();

    public void enqueue(String item) {
        queue.add(item);
    }

    public String dequeue() {
        String item = queue.getFirst();

        queue.removeFirst();

        return item;
    }

    public boolean isEmpty() {
        return queue.isEmpty();
    }
}
