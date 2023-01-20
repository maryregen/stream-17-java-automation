import java.util.LinkedList;
import java.util.Queue;

public class QueueExample {

    public static Queue<String> queue = new LinkedList<>();

    public void add(String value) {
        queue.offer(value);
    }

    public boolean search() {
        for (String str : queue) {
            queue.peek();
            System.out.println("Значение: " + str);
        }
        return false;
    }

    public void remove() {
        while (queue.size() != 0)
        {
            queue.poll();
            System.out.println("Удаленный элемент: " + queue.poll());
        }
    }
}
