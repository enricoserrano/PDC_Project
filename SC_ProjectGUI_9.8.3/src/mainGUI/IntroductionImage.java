
import java.awt.Graphics;
import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JPanel;
import mainGUI.ScreenSize;

/**
 * This class allows the program to read the game logo file and displays it in
 * the start screen
 *
 * @author Enrico Serrano 19071299, Chea 16938895, Leandro Machado 18041563
 */
public class IntroductionImage extends JPanel {

    public Image image;

    public IntroductionImage() {
        this.image = new ImageIcon("./resources/gameLogo.png").getImage();
    }

    /**
     * Draw the background oof the program
     *
     *
     */
    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        ScreenSize ss = new ScreenSize();
        int width = (ss.getScreenWidth() - image.getWidth(null)) / 2;
        float height = (float) ((ss.getScreenHeight() - image.getHeight(null)) / -0.25);
        g.drawImage(this.image, width, (int) height, null);
    }
}
