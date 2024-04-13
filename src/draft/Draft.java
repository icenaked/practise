package draft;

import java.util.concurrent.Semaphore;

import java.util.Arrays;
import java.util.Comparator;

public class Draft {
    static class Printabc{
        Semaphore a=new Semaphore(1);
        Semaphore b=new Semaphore(0);
        Semaphore c=new Semaphore(0);
        public void printA() throws InterruptedException {
            for(int i=0;i<10;i++){
                a.acquire();
                System.out.print("a");
                b.release();
            }
        }
        public void printB() throws InterruptedException {
            for(int i=0;i<10;i++){
                b.acquire();
                System.out.print("b");
                c.release();
            }
        }
        public void printC() throws InterruptedException {
            for(int i=0;i<10;i++){
                c.acquire();
                System.out.print("c");
                a.release();
            }
        }
    }
    static int[] b={4,5,6};
    public static void main(String[] args) {
        Printabc x=new Printabc();
        Thread t1=new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    x.printA();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        });
        Thread t2=new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    x.printB();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        });
        Thread t3=new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    x.printC();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        });
        t1.start();
        t2.start();
        t3.start();
    }

}
