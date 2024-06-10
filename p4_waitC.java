
    
    class ChildThread extends Thread {
        private Thread mainThread;
    
        // Constructor to accept the main thread
        public ChildThread(Thread mainThread) {
            this.mainThread = mainThread;
        }
    
        public void run() {
            System.out.println("Child thread starting.");
            
            try {
                mainThread.join();
                for (int i = 1; i <= 5; i++) {
                    System.out.println("Child thread: " + i);
       
                    Thread.sleep(1000);
                }
            } catch (InterruptedException e) {
                System.out.println("Child thread interrupted.");
            }
    
            System.out.println("Child thread finished.");
        }
    }
    
    public class p4_waitC {
        public static void main(String[] args) {
            System.out.println("Main thread starting.");
    
            // Create and start the child thread, passing the main thread as an argument
            ChildThread child = new ChildThread(Thread.currentThread());
            child.start();
            try {
                for (int i = 1; i <= 3; i++) {
                    System.out.println("Main thread: " + i);
                    // Sleep for 1 second (1000 milliseconds)
                    Thread.sleep(1000);
                }
            } catch (InterruptedException e) {
                System.out.println("Main thread interrupted.");
            }
    
            System.out.println("Main thread finished.");
        }
    }
    