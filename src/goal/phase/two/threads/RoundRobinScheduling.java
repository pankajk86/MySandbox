package goal.phase.two.threads;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class RoundRobinScheduling {

    static int count = 1;

    public static void main(String[] args) {
        final Lock lock = new ReentrantLock();
        final Condition condition = lock.newCondition();

        Thread t1 = new Thread(new RRThread(lock, condition, 1, 2, count));
        Thread t2 = new Thread(new RRThread(lock, condition, 2, 3, count));
        Thread t3 = new Thread(new RRThread(lock, condition, 3, 1, count));

        t1.start();
        t2.start();
        t3.start();
    }

}

class RRThread implements Runnable {

    final Lock lock;
    final Condition condition;
    int actual;
    int next;

    public RRThread(Lock lock, Condition condition, int actual, int next, int count) {
        this.lock = lock;
        this.condition = condition;
        this.actual = actual;
        this.next = next;
    }

    @Override
    public void run() {

        while (true) {
            lock.lock();
            try {
                while (RoundRobinScheduling.count != actual) {
                    try {
                        condition.await();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                System.out.print(actual + " ");
                RoundRobinScheduling.count = next;
                condition.signalAll();

            } finally {
                lock.unlock();
            }
        }
    }

    public void start() {

    }

}