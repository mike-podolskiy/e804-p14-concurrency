//CHECKSTYLE:OFF
package kz.mix.e804.concurrency.collections;

import java.util.concurrent.PriorityBlockingQueue;

// Illustrates the use of PriorityBlockingQueue. In this case, if there is no element available in the priority queue
// the thread calling take() method will block (i.e., wait) until another thread inserts an element
public class PriorityBlockingQueueExample {
    public static void main(String[] args) {
        final PriorityBlockingQueue<Integer> priorityBlockingQueue = new PriorityBlockingQueue<>();

        new Thread() {
            public void run() {
                try {
                    // use take() instead of remove()
                    // note that take() blocks, whereas remove() doesn't block
                    System.out.println("The removed element is: " + priorityBlockingQueue.take());
                } catch (InterruptedException ie) {
                    // its safe to ignore this exception
                    ie.printStackTrace();
                }
            }
        }.start();

        new Thread() {
            public void run() {
                // add an element with value 10 to the priority queue
                priorityBlockingQueue.add(10);
                System.out.println("Successfully added an element to the queue ");
            }
        }.start();
    }
}
