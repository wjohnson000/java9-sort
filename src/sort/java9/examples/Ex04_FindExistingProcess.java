package sort.java9.examples;

import java.io.IOException;
import java.util.concurrent.CompletableFuture;
import java.util.stream.Stream;

/**
 * Find a running process of Windows "notepad" and attach a "CompletableFuture" which
 * will simply print out a message when the process is killed.
 * 
 * @author wjohnson000
 *
 */
public class Ex04_FindExistingProcess {
    public static void main(String... args) throws IOException, InterruptedException {
        Stream<ProcessHandle> liveProcesses = ProcessHandle.allProcesses();
        ProcessHandle notepad = liveProcesses
            .filter(proc -> proc.info().command().orElse("").contains("notepad.exe"))
            .findFirst()
            .orElse(null);

        if (notepad == null) {
            System.out.println("Notepad isn't running");
        } else {
            System.out.println("Notepad proc: " + notepad.pid() + " --> " + notepad.info());
            CompletableFuture<ProcessHandle> future = notepad.onExit();
            future.whenComplete((proc, exception) -> {
                System.out.println("Notepad has closed ...");
            });
            
            try { Thread.sleep(6000L); } catch(Exception ex) { }
        }
    }
}