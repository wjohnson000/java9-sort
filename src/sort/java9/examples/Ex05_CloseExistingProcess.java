package sort.java9.examples;

import java.io.IOException;
import java.util.stream.Stream;

/**
 * Find a running process of Windows "notepad" and shut it down.
 * 
 * @author wjohnson000
 *
 */
public class Ex05_CloseExistingProcess {
    public static void main(String... args) throws IOException, InterruptedException {
        Stream<ProcessHandle> liveProcesses = ProcessHandle.allProcesses();
        ProcessHandle notepad = liveProcesses
            .filter(proc -> proc.info().command().orElse("").contains("notepad.exe"))
            .findFirst()
            .orElse(null);

        if (notepad == null) {
            System.out.println("Notepad isn't running");
        } else {
            if (notepad.supportsNormalTermination()) {
                System.out.println("Shutting down 'Notepad'.");
                notepad.destroy();
            } else {
                System.out.println("Shutting down 'Notepad' with extreme prejudice.");
                notepad.destroyForcibly();
            }
        }
    }
}