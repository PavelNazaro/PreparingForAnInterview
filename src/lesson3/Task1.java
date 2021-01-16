package lesson3;

public class Task1 {
    public static void main(String[] args) {
        Task1 task1 = new Task1();
        new Thread(task1::method1).start();
        new Thread(task1::method2).start();
    }

    private synchronized void method1(){
        while (true) {
            notify();
            System.out.println("ping");
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    private synchronized void method2(){
        while (true) {
            notify();
            System.out.println("pong");
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
