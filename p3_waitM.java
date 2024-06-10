
    
    class ChildThread extends Thread {
        public void run() {
            System.out.println("Child thread starting.");
    
            // Demonstrate the use of sleep method
            try {
                for (int i = 1; i <= 5; i++) {
                    System.out.println("Child thread: " + i);
                    // Sleep for 1 second (1000 milliseconds)
                    Thread.sleep(1000);
                }
            } catch (InterruptedException e) {
                System.out.println("Child thread interrupted.");
            }
    
            System.out.println("Child thread finished.");
        }
    }
    
    public class p3_waitM {
        public static void main(String[] args) {
            System.out.println("Main thread starting.");
    
            // Create a new child thread
            ChildThread child = new ChildThread();
            child.start();
    
            // Demonstrate the use of join method
            try {
                System.out.println("Main thread waiting for child thread to finish.");
                child.join();
            } catch (InterruptedException e) {
                System.out.println("Main thread interrupted.");
            }
    
            System.out.println("Main thread finished.");
        }
    }
    
