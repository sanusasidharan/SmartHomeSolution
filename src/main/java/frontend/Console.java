package frontend;

import javax.swing.*;
import java.awt.*;
public class Console {


public static void main(String[] args) {
    JFrame consoleFrame =new JFrame();
    System.out.print("test");
    consoleFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

    JButton submitButton = new JButton("Submit");
    submitButton.setBounds(50,350,100, 30);

    JLabel heading = new JLabel("SMART HOME");
    heading.setBounds(150,10, 100,10);

    JLabel firstPerson = new JLabel("First Person");
    firstPerson.setBounds(350,50, 100,30);
    JLabel secondPerson = new JLabel("Second Person");
    secondPerson.setBounds(350,100, 100,30);
    JLabel thirdPerson = new JLabel("Third Person");
    thirdPerson.setBounds(350,150, 100,30);


    JLabel firstPersonProbability = new JLabel("100%");
    firstPersonProbability.setBounds(500,50, 100,30);
    JLabel secondPersonProbability = new JLabel("90%");
    secondPersonProbability.setBounds(500,100, 100,30);
    JLabel thirdPersonProbability = new JLabel("80%");
    thirdPersonProbability.setBounds(500,150, 100,30);



    JPanel panel = (JPanel)consoleFrame.getContentPane();



    CaptureImage captureImage = new CaptureImage();
    try{
        captureImage.FaceDetector(panel);
    }catch (Exception e){

    }

 /*   JLabel imageLabel = new JLabel();
    imageLabel.setIcon(new ImageIcon("D:\\download1.jfif"));
    //JScrollPane jsp = new JScrollPane(imageLabel);
    imageLabel.setBounds(50,50, 200,200);*/
  //  panel.add(imageLabel);
    panel.add(heading);
    panel.add(firstPerson);
    panel.add(secondPerson);
    panel.add(thirdPerson);
    panel.add(firstPersonProbability);
    panel.add(secondPersonProbability);
    panel.add(thirdPersonProbability);
    panel.add(submitButton);//adding button in JFrame
   // consoleFrame.add(panel);


    consoleFrame.setSize(400,500);//400 width and 500 height
    consoleFrame.setLayout(null);//using no layout managers
    consoleFrame.setVisible(true);//making the frame visible


    submitButton.addActionListener(new CaptureActionListener());
}

}
