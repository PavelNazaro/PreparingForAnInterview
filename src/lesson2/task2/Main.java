package lesson2.task2;

public class Main {
    public static void main(String[] args) {
        MyArrayList<Integer> integers = new MyArrayList<>();

        integers.add(0);
        integers.add(1);
        integers.add(2);
        integers.add(3);
        integers.add(4);
        integers.add(5);
        integers.add(6);
        integers.add(7);
        integers.add(8);
        integers.add(9);
        integers.add(10);
        integers.add(11);
        integers.add(12);
        integers.add(13);
        integers.add(14);
        integers.add(15);

        integers.display();

        integers.delete(0);
        integers.delete(7);

        integers.display();
    }
}
