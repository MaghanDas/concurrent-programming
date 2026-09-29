package Synchronized;

import java.util.List;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) throws InterruptedException{
            List<Integer> numbers = new ArrayList<>();

            // thread 1..
        Thread oddThread =  new Thread(()->{
            for (int i = 1; i < 1_000_000; i += 2) {
                synchronized (numbers){
                    while(i != numbers.size() + 1){
                        try{
                            numbers.wait();
                        }
                        catch (InterruptedException e ){
                            Thread.currentThread().interrupt();
                            return;
                        }
                    }
                    numbers.add(i);
                    numbers.notifyAll();
                }
            }
        });
        // Thread 2 - even
        Thread evenThread =  new Thread(()->{
            for (int i = 2; i < 1_000_000; i += 2) {
                synchronized (numbers){
                    while(i != numbers.size() + 1){
                        try{
                            numbers.wait();
                        }
                        catch (InterruptedException e ){
                            Thread.currentThread().interrupt();
                            return;
                        }
                    }
                    numbers.add(i);
                    numbers.notifyAll();
                }
//                numbers.add(i);
            }
        });

        // waiting for them to finish.
        long start = System.nanoTime();

        oddThread.start();
        evenThread.start();

        oddThread.join();
        evenThread.join();

        long end = System.nanoTime();

        System.out.println("List size: " + numbers.size());
        System.out.println("First 20: " + numbers.subList(0, 20));
        System.out.println("Last 20: "
                + numbers.subList(numbers.size() - 20, numbers.size()));
        System.out.println("Sorted: " + isSorted(numbers));
        System.out.printf("Execution time: %.3f seconds%n",
                (end - start) / 1_000_000_000.0);
    }

    static boolean isSorted(List<Integer> numbers) {
        for (int i = 1; i < numbers.size(); i++) {
            if (numbers.get(i - 1) >= numbers.get(i)) {
                return false;
            }
        }
        return true;
    }
}


