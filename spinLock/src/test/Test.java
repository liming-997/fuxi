package test;

public class Test implements Runnable{

    private Object lock = new Object();
    private static int value = 0;

    @Override
    public void run() {
        synchronized (Test.class) {
            System.out.println(value++);
        }
    }

    public void r() {
        System.out.println("dd");
    }
    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
             Thread thread = new Thread(new Test());
             thread.start();
        }
        
    }

}
