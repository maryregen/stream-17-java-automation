import java.util.HashMap;
import java.util.Map;

public class MapExample {

    Map<Integer, String> fields = new HashMap<>();

    public void add(int key, String value) {
        fields.put(key, value);
    }

    public boolean searchKey(int key) {
        if (fields.containsKey(key)) {
            return true;
        } else {
            return false;
        }
    }

    public boolean searchValue(String value) {
       if (fields.containsValue(value)) {
            return true;
       } else {
            return false;
        }
    }

    public void remove(int key) {
        do {
            fields.remove(key);
        }
        while (fields.size() > 2);
    }
}

