package proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class ProxyFactory {
    public static void main(String[] args) {
        Person teacher = new Teacher();
        Person p = (Person) Proxy.newProxyInstance(teacher.getClass().getClassLoader(), teacher.getClass().getInterfaces(), new InvocationHandler() {
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                System.out.println("开始代理");
                Object invoke = method.invoke(teacher, args);
                System.out.println("代理结束");
                return invoke;
            }
        });
        p.say();

    }
}
