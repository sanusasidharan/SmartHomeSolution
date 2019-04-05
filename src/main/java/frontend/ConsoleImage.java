package frontend;

import javax.swing.*;
import java.awt.*;

public class ConsoleImage extends Canvas{

    public void paint(Graphics g) {

        Toolkit t=Toolkit.getDefaultToolkit();
        Image i=t.getImage("D:\\download.jfif");
        g.drawImage(i, 120,100,this);

    }

    public static void main(String[] args) {
        JFrame consoleFrame =new JFrame();
        ConsoleImage personImage = new ConsoleImage();


        consoleFrame.add(personImage);
        consoleFrame.setSize(400,500);//400 width and 500 height
        //consoleFrame.setLayout(new FlowLayout());
        consoleFrame.setVisible(true);//making the frame visible
    }
}