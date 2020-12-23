package lesson2.task2;

import java.util.Arrays;

public class MyArrayList<T> {
    public static final int DEFAULT_CAPACITY = 10;
    public static final double ARRAY_MAGNIFICATION_FACTOR = 1.5;
    int size;
    Object[] objects;
    int i;

    public MyArrayList(int size) {
        this.size = size;
        createArray();
    }

    public MyArrayList() {
        this.size = DEFAULT_CAPACITY;
        createArray();
    }

    private void createArray(){
        objects = new Object[size];
        i = 0;
    }

    public void add(T object){
        if (i >= size) {
            ensureCapacity();
        }
        objects[i] = object;
        i++;
    }

    public void delete(int i){
        if (i < this.i && i >= 0){
            this.i--;
            System.arraycopy(objects, i+1, objects, i, size - i - 1);
        } else {
            System.out.println("Error!");
        }
    }

    private void ensureCapacity() {
        size = (int) (size * ARRAY_MAGNIFICATION_FACTOR);
        objects = Arrays.copyOf(objects, size);
    }

    public int getSize() {
        return size;
    }

    public void display(){
        for (int j = 0; j < i; j++) {
            System.out.print(objects[j] + " ");
        }
        System.out.println();
    }
}
