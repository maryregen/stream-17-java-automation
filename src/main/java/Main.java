import java.util.LinkedList;
import java.util.Queue;

public class Main {

    public static void main(String[] args) {
        // LIST
        ArrayListExample l = new ArrayListExample();
        l.add("red");
        l.add("yellow");
        l.add("green");
        int idx = l.search("red");
        System.out.println(idx);
        l.remove(idx);

        //SET
        SetExample s = new SetExample();
        s.add("Иван");
        s.add("Марья");
        s.add("Пётр");
        s.add("Иван");
        System.out.println(s.search("Марья"));
        System.out.println("Было установлено имя " + s.search("Марья"));
        s.remove("Марья");

        //MAP
        MapExample m = new MapExample();
        m.add(111111, "Лидия Cеменовна Кочерга");
        m.add(222222, "`Максим Павлович Зиновьев");
        m.add(333333, "Анна Николаевна Данилова");
        System.out.println(m.searchKey(111111));
        System.out.println(m.searchValue("Лидия Cеменовна Кочерга"));
        m.remove(111111);

        //QUEUE
        QueueExample q = new QueueExample();
        q.add("Первый");
        q.add("Второй");
        q.add("Третий");
        System.out.println(q.search());
        q.remove();
    }
}
