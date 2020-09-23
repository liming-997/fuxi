package spinlock;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;

/**
 * 手写一个自旋锁
 */
public class spinlockDemo {
    //原子引用线程
    AtomicReference<Thread> atomicReference = new AtomicReference<>();
    public void lock() {
        Thread thread = Thread.currentThread();
        System.out.println(Thread.currentThread().getName() + "\t 获取锁");
        //如果希望值不为null,则一直尝试获取锁
        while (!atomicReference.compareAndSet(null,thread)) {

        }
    }

    public void unLock() {
        Thread thread = Thread.currentThread();
        atomicReference.compareAndSet(thread, null);
        System.out.println(Thread.currentThread().getName() + "\t 释放锁");
    }
    public static void main(String[] args) {
        spinlockDemo spinlockDemo = new spinlockDemo();
        new Thread(() ->{
            try {
                spinlockDemo.lock();
                TimeUnit.SECONDS.sleep(3);
                spinlockDemo.unLock();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        },"AAA").start();

        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        new Thread(() ->{
           spinlockDemo.lock();
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
           spinlockDemo.unLock();
        },"BBB").start();
    }
}
