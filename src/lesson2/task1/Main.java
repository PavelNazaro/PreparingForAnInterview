package lesson2.task1;

public class Main {
    public static void main(String[] args) {
        MyLinkedList<String> list = new MyLinkedList<>();

        list.add("First");
        list.add("Second");
        list.add("Third");

        list.display();

        list.delete();

        list.display();
    }
}
