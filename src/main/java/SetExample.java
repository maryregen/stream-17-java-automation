import java.util.HashSet;

public class SetExample {
    public static HashSet<String> names = new HashSet<>();;

    public void add(String value) {
        names.add(value);
    }

    public String search(String value) {
        while (!(names.contains(value)))
        {
            System.out.println("Имя 'Марья' всё ещё нет ");
        }
        return value;
    }
    public void remove(String value) {
        names.remove(value);
    }
}
