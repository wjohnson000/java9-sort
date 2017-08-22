package sort.java9;

import java.awt.Taskbar;
import java.awt.Taskbar.Feature;

public class Ex11_Taskbar {
    public static void main(String...args) {
        System.out.println("Is Taskbar supported? " + Taskbar.isTaskbarSupported());
        if (Taskbar.isTaskbarSupported()) {
            Taskbar tb = Taskbar.getTaskbar();
            System.out.println("Menu? " + tb.isSupported(Feature.MENU));
            System.out.println("Icon? " + tb.isSupported(Feature.ICON_IMAGE));
            System.out.println("Prog? " + tb.isSupported(Feature.PROGRESS_VALUE));
            System.out.println("User? " + tb.isSupported(Feature.USER_ATTENTION));
            System.out.println("User? " + tb.isSupported(Feature.USER_ATTENTION_WINDOW));
        }
    }
}
