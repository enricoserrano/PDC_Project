package mainGUI;

import java.awt.Dimension;
import java.awt.Toolkit;
import javax.swing.JFrame;

/**
 *
 * @author User
 */
public class ScreenSize {

    private static int screenWidth;
    private static int screenHeight;

    public static int getScreenWidth() {
        return screenWidth;
    }

    public static void setScreenWidth(int screenWidth) {
        ScreenSize.screenWidth = screenWidth;
    }

    public static int getScreenHeight() {
        return screenHeight;
    }

    public static void setScreenHeight(int screenHeight) {
        ScreenSize.screenHeight = screenHeight;
    }

    public ScreenSize() {
        Toolkit kit = Toolkit.getDefaultToolkit();
        Dimension screenSize = kit.getScreenSize();
        this.screenWidth = screenSize.width;
        this.screenHeight = screenSize.height;
    }

}
