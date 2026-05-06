/***********************************************************
 * Name: Ian Handy
 * Date: 2026-04-28
 * Description: Lab 5 Part 2 — a Thread subclass that prints a
 * single character 1000 times. Used to study how thread scheduling
 * (yield, sleep) and a fair binary semaphore affect interleaving.
 ***********************************************************/

import java.util.concurrent.Semaphore;

public class MyThread extends Thread {

    // Step 13: a single static fair binary semaphore (one permit) used to enforce
    // strict alternation of the two threads' prints. `true` = fair queueing
    // (FIFO), which is what makes alternation work with just one permit.
    static Semaphore s = new Semaphore(1, true);

    private char c;

    public MyThread(char c) {
        super();
        this.c = c;
    }

    @Override
    public void run() {
        for (int i = 0; i < 1000; i++) {
            try {
                s.acquire();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                return;
            }
            System.out.print(c);

            // Step 9: yield gives the scheduler a hint that this thread is
            // willing to step aside; with semaphore-based ordering it has no
            // visible effect on the interleaving, but it's left in to match
            // the lab's experimentation flow.
            Thread.yield();

            // Step 11: sleep(1) forces the OS to suspend the current thread,
            // which gives the other thread a near-guaranteed chance to grab
            // the next semaphore permit. Combined with the fair semaphore,
            // this produces tight h-a-h-a alternation.
            try {
                Thread.sleep(1);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                s.release();
                return;
            }

            s.release();
        }
    }
}
