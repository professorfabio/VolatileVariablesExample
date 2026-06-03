public class SharedFlag {
   private static boolean running = true;
   public static void main(String[] args) 
     throws InterruptedException {
       Thread worker = new Thread(() -> {
           while (running) { /* work */ }
           System.out.println("Stopped");
       });
       worker.start();
       Thread.sleep(1000);
       running = false; // May not be (immediately) visible to 
                        // worker thread without volatile
   }
}
