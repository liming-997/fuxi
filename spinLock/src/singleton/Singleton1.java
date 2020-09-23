package singleton;

/**
 * 饿汉
 *   构造方法私有
 *   提供公共静态的返回值为该实例的方法
 */
public class Singleton1 {
    private Singleton1() {

    }
    private static Singleton1 singleton1 = new Singleton1();

    public static Singleton1 newInstance() {
        return singleton1;
    }

    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {

            System.out.println(Singleton1.newInstance());
        }
    }
}
