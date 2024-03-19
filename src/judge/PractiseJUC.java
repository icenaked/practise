package judge;
import java.util.*;
import java.util.concurrent.Semaphore;
import java.util.concurrent.atomic.AtomicInteger;

public class PractiseJUC {
    static class Foo {
        private AtomicInteger firstJobDone = new AtomicInteger(0);
        private AtomicInteger secondJobDone = new AtomicInteger(0);
        public Foo() {}
        public void first(Runnable printFirst) throws InterruptedException {
//            printFirst.run();
            System.out.println("1");
            firstJobDone.incrementAndGet();
        }
        public void second(Runnable printSecond) throws InterruptedException {
            while (firstJobDone.get() != 1) {
            }
            printSecond.run();
            secondJobDone.incrementAndGet();
        }
        public void third(Runnable printThird) throws InterruptedException {
            while (secondJobDone.get() != 1) {
            }
            printThird.run();
        }
    }
    static class EvenOdd{
        Semaphore even = new Semaphore(1);
        Semaphore odd = new Semaphore(0);
        public void printEven() throws InterruptedException {
            for(int i=0;i<=100;i+=2){
                even.acquire();
                System.out.println(i);
                odd.release();
            }
        }
        public void printOdd() throws InterruptedException {
            for(int i=1;i<=100;i+=2){
                odd.acquire();
                System.out.println(i);
                even.release();
            }
        }
    }


    public static void main(String[] args){
        Foo foo = new Foo();
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    foo.first(() -> System.out.println("1"));
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        });
        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    foo.second(() -> System.out.println("2"));
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        });
        Thread t3 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    foo.third(() -> System.out.println("3"));
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        });
//        t2.start();
//        t3.start();
//        t1.start();

        EvenOdd evenOdd=new EvenOdd();
        Thread t4=new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    evenOdd.printEven();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        });
        Thread t5=new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    evenOdd.printOdd();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        });
        t4.start();
        t5.start();
    }
}
