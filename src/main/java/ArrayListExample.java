import java.util.ArrayList;

public class ArrayListExample {
    public static ArrayList<String> basket = new ArrayList<>(0);

    public void add(String value) {
        basket.add(value);
    }

    public int search(String value) {
        for (int i = 0; i < basket.size(); i++) {
            if (basket.get(i) == value) {
                return i;
            }
        }
        return -1;
    }
    public void remove(int idx) {
        basket.remove(idx);
    }
}
