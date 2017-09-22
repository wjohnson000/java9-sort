package sort.java9.examples;

import java.awt.Taskbar;
import java.awt.Taskbar.Feature;

public class Ex12_Taskbar {
    public static void main(String...args) {
        System.out.println("Is Taskbar supported? " + Taskbar.isTaskbarSupported());
        if (Taskbar.isTaskbarSupported()) {
            Taskbar taskbar = Taskbar.getTaskbar();
            System.out.println("Menu? " + taskbar.isSupported(Feature.MENU));
            System.out.println("Icon? " + taskbar.isSupported(Feature.ICON_IMAGE));
            System.out.println("Prog? " + taskbar.isSupported(Feature.PROGRESS_VALUE));
            System.out.println("User? " + taskbar.isSupported(Feature.USER_ATTENTION));
            System.out.println("User? " + taskbar.isSupported(Feature.USER_ATTENTION_WINDOW));
        }
    }
}
