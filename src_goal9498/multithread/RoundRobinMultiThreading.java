package multithread;

import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedDeque;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Needs re-work. It's NOT correct.
 */
public class RoundRobinMultiThreading {

    public static void main(String[] args) {
        Thread t1 = new Thread(new RoundRobinLogic());
        Thread t2 = new Thread(new RoundRobinLogic());
        Thread t3 = new Thread(new RoundRobinLogic());

        t1.start();
        t2.start();
        t3.start();
    }

}

class RoundRobinLogic implements Runnable {
    private static final AtomicInteger systemIndex = new AtomicInteger(1);

    private static final RemoteSystem[] systems = new RemoteSystem[] { new RemoteSystem("System1"),
            new RemoteSystem("System2"), new RemoteSystem("System3"), new RemoteSystem("System4"), };

    public static final Queue<String> output = new ConcurrentLinkedDeque<>();

    @Override
    public void run() {
        RemoteSystem system = systems[systemIndex.incrementAndGet() % systems.length];

        // Sending the request to right system
        output.add("Request to " + system.name());
    }
}

class RemoteSystem {
    private final String name;

    RemoteSystem(String name) {
        this.name = name;
    }

    public String name() {
        return name;
    }
}
