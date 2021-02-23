package singleton;

public class Singleton2 {
    /**
     * 构造器私有
     */
    private Singleton2() {

    }

    private static Singleton2 singleton2 = null;

    /**
     * 双端检索 提高效率
     * @return
     */
    public static Singleton2 newInStance() {
        if (singleton2 == null) {
            synchronized (Singleton2.class) {
                if (singleton2 == null) {
                    singleton2 = new Singleton2();
                }
            }
        }
        return singleton2;
    }

    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            System.out.println(Singleton2.newInStance());
        }
    }
}
