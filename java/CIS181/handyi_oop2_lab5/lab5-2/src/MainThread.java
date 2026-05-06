/***********************************************************
 * Name: Ian Handy
 * Date: 2026-04-28
 * Description: Lab 5 Part 2 driver — spawns two MyThread instances
 * with characters 'h' and 'a' and starts them concurrently. With the
 * fair static Semaphore inside MyThread, the printed output strictly
 * alternates h-a-h-a... 1000 times.
 ***********************************************************/

public class MainThread {

    public static void main(String[] args) {
        MyThread t1 = new MyThread('h');
        MyThread t2 = new MyThread('a');

        t1.start();
        t2.start();
    }
}
