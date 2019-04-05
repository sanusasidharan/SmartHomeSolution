package frontend;

import facedetection.FaceDetectionImpl;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CaptureActionListener implements ActionListener{

    public void actionPerformed(ActionEvent e){

        System.out.println("Testtt");
        try{
            FaceDetectionImpl facedector  = new FaceDetectionImpl();
            facedector.detectFace();
        }catch(Exception ex){

        }

    }
}
