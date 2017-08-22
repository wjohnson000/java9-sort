package sort.java9;

import java.io.IOException;
import java.util.stream.Stream;

/**
 * Start a system process, dump the results.
 * 
 * @author wjohnson000
 *
 */
public class Ex02_ListLiveProcesses {
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