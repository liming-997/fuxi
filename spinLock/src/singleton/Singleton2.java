package singleton;

public class Singleton2 {
    private Singleton2() {

    }

    private static Singleton2 singleton2 = null;

    public synchronized static Singleton2 newInStance() {
        if (singleton2 == null) {
            singleton2 = new Singleton2();
        }
        return singleton2;
    }

    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            System.out.println(Singleton2.newInStance());
        }
    }
}
