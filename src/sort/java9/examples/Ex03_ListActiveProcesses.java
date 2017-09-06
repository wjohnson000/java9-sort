package sort.java9.examples;

import java.io.IOException;
import java.util.stream.Stream;

/**
 * List all currently running [active] processes, including their PID, command line and
 * start and run times.
 * 
 * @author wjohnson000
 *
 */
public class Ex03_ListActiveProcesses {
    public static void main(String... args) throws IOException, InterruptedException {
        ProcessHandle handle = ProcessHandle.current();
        System.out.println("Handle: " + handle);
        System.out.println("  Info: " + handle.info());
        System.out.println("   Cmd: " + handle.info().command());

        System.out.println("\n\nActive processes ...");
        Stream<ProcessHandle> liveProcesses = ProcessHandle.allProcesses();
        liveProcesses
            .filter(ProcessHandle::isAlive)
            .forEach(proc -> {
                System.out.println("Proc: " + proc.pid() + " --> " + proc.info());
            });
    }
}