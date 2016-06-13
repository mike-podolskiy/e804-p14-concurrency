//CHECKSTYLE:OFF
package kz.mix.e804.concurrency.threadLocalRandom;

import java.util.concurrent.ThreadLocalRandom;

public class ThreadLocalRandomTest {
    public static void main(String[] args) {
        for (int i = 0; i < 20; i++) {
            System.out.println(ThreadLocalRandom.current().nextInt(0, 4));
        }
    }
}
