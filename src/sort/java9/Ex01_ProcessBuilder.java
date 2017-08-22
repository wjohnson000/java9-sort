package sort.java9;

import java.io.IOException;
import java.nio.file.Paths;
import java.util.concurrent.CompletableFuture;

/**
 * Start a system process, dump the results.
 * 
 * @author wjohnson000
 *
 */
public class Ex01_ProcessBuilder {
    public static void main(String... args) throws IOException, InterruptedException {
        ProcessBuilder dir = new ProcessBuilder()
            .directory(Paths.get("C:/temp").toFile())
            .command("dir", "-a");

        Process proc = dir.start();
        CompletableFuture<Process> future = proc.onExit();
        future.whenComplete((process, exception) -> {
            if (exception != null) {
                System.out.println("\nEX: " + exception);
            } else {
                try {
                    byte[] outBytes = process.getInputStream().readAllBytes();
                    System.out.println("\nResults:\n" + new String(outBytes));
                } catch (IOException e) {
                    System.out.println("\nUnable to read results of command: " + e.getMessage());
                }
            }
        });
        future.join();

        try { Thread.sleep(2000L); } catch(Exception ex) { }
        System.exit(0);
    }
}