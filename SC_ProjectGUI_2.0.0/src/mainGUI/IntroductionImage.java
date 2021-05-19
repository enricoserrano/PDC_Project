
import java.awt.Graphics;
import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JPanel;
import mainGUI.ScreenSize;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author User
 */
public class IntroductionImage extends JPanel{

    public Image image;

    public IntroductionImage() {
        this.image = new ImageIcon("./resources/gameLogo.png").getImage();
    }

    /**
     * Draw the background of this panel.
     *
     * @param g
     */
    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        ScreenSize ss = new ScreenSize();
        int width = (ss.getScreenWidth() - image.getWidth(null)) / 2;
        float height = (float) ((ss.getScreenHeight() - image.getHeight(null)) / -0.25);
        //int width = ss.getScreenWidth() / 2;
        //int height = ss.getScreenHeight() / 2;
        g.drawImage(this.image, width, (int) height,  null);
    }
}

