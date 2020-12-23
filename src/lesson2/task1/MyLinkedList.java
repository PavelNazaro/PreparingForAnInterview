package lesson2.task1;

class MyLink<T> {
    public T object;

    public MyLink<T> next;

    public MyLink(T object){
        this.object = object;
    }

    public void display(){
        System.out.println(this.object);
    }
}

public class MyLinkedList<T> {
    public MyLink<T> first;
    public MyLink<T> last;

    public MyLinkedList(){
        first = null;
        last = null;
    }

    public boolean isEmpty(){
        return (first == null);
    }

    public void add(T object){
        MyLink<T> newLink = new MyLink<>(object);
        if (this.isEmpty())
            last = newLink;
        newLink.next = first;
        first = newLink;
    }

    public MyLink<T> delete(){

        MyLink<T> temp = first;
        if (first.next == null)
            last = null;
        first = first.next;
        return temp;

    }

    public void display(){
        MyLink<T> current = first;
        while(current != null){
            current.display();
            current = current.next;
        }
    }
}
