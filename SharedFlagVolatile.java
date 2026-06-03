public class SharedFlagVolatile {
   private static volatile boolean running = true;
   public static void main(String[] args) 
     throws InterruptedException {
       Thread worker = new Thread(() -> {
           while (running) { /* work */ }
           System.out.println("Stopped");
       });
       worker.start();
       Thread.sleep(1000);
       running = false; // Immediately visible to worker thread
   }
}
