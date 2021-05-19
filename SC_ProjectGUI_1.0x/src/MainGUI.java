
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Image;
import java.awt.Toolkit;
import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.GridLayout;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author User
 */
public class MainGUI {

    public static void introductionDisplay() {
        ScreenSize ss = new ScreenSize();
        IntroductionImage image = new IntroductionImage();
        IntroductionGUI intro = new IntroductionGUI();
        intro.setLayout(new GridLayout(4, 1, 5, 10));

        JFrame jf = new JFrame("Main Frame");

        jf.add(image, BorderLayout.CENTER);
        jf.add(intro, BorderLayout.SOUTH);

        jf.setTitle("Who wants to be a Millionaire");
        jf.setSize(ss.getScreenWidth(), ss.getScreenHeight());
        jf.setExtendedState(JFrame.MAXIMIZED_BOTH);
        jf.setLocation(100, 100);
        jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jf.setVisible(true);
    }

    public static void main(String[] args) {

        introductionDisplay();
    }

}
