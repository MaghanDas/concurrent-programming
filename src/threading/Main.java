package threading;

import java.io.FileNotFoundException;
import java.io.PrintWriter;

public class Main {

//    static class PrintThread extends Thread {
//        private final String text;
//        private final PrintWriter writer;
//        public PrintThread(String text, PrintWriter writer){
//            this.text = text;
//            this.writer = writer;
//        }
//
//        @Override
//        public void run(){
//            for (int i = 0; i < 100; i++) {
////                for (int j = 0; j < text.length(); j++) {
////                    System.out.println(text.charAt(j));
////                }
//
//                // writting to a file.
//                synchronized (writer){
//                    writer.println(text);
//                }
//            }
//        }
//    }

    static class PrintTask implements Runnable{
        private final String text;

        public PrintTask(String text) {
            this.text = text;
        }

        @Override
        public void run(){
            for (int i = 0; i < 50; i++) {
                System.out.println(text);
            }
        }
        
}
    public static void main(String[] args) throws FileNotFoundException, InterruptedException{
//        PrintWriter writer = new PrintWriter("output.txt");
//
//        Thread helloThread = new PrintThread("hello", writer);
//        Thread wordThread = new PrintThread("word", writer);

//        helloThread.start();
//        wordThread.start();
        // wait until both thread finishes.
//        helloThread.join();
//        wordThread.join();

//        writer.close();

//        helloThread.run();
//        wordThread.run();
        //  start() → creates a new thread → JVM eventually calls run() on that thread.
        //  run() → just executes the method on the thread that called it (here, main).

    // Use of Thread using runnable interface.
    Thread hello = new Thread(new PrintTask("Hello"));
    Thread world = new Thread(new PrintTask("world"));

    hello.start();
    world.start();

}
}