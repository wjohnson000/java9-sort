package sort.java9.examples;

import java.io.IOException;
import java.nio.file.Paths;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

/**
 * Start a system process, dump the results.  There are three different ways of listing the
 * contents of the "C:\temp" directory.  NOTE: the third way would work in Java 1.7 and 1.8.
 * 
 * @author wjohnson000
 *
 */
public class Ex02_ProcessBuilder {
    public static void main(String... args) throws Exception {
//        listTemp_version01();
        listTemp_version02();
//        listTemp_version03();
    }

    static void listTemp_version01() throws IOException, InterruptedException, ExecutionException {
        ProcessBuilder listDirProc = new ProcessBuilder()
                .directory(Paths.get("C:/temp").toFile())
                .command("dir", "-a");

        Process proc = listDirProc.start();
        ProcessHandle processHandle = proc.toHandle();
        System.out.println("Started process -- PID: " + processHandle.pid());
        CompletableFuture<ProcessHandle> future = processHandle.onExit();
        future.get();

        byte[] outBytes = proc.getInputStream().readAllBytes();
        System.out.println("\nResults:\n" + new String(outBytes));
    }

    static void listTemp_version02() throws IOException, InterruptedException, ExecutionException {
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
    }

    static void listTemp_version03() throws IOException, InterruptedException, ExecutionException {
        ProcessBuilder listDirProc = new ProcessBuilder()
                .directory(Paths.get("C:/temp").toFile())
                .command("dir", "-l");

        listDirProc.inheritIO().start();
    }
}