package frontend;

//import com.deeplearning.RecognitionImageFile;
import com.deeplearning.RecognitionImageFile;
import facedetection.FaceDetectionImpl;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileReader;
import java.util.*;



public class CaptureActionListener implements ActionListener{

    public void actionPerformed(ActionEvent e){

        System.out.println("Testtt");
        try{
            FaceDetectionImpl facedector  = new FaceDetectionImpl();
            facedector.detectFace();

            RecognitionImageFile recogImage = new RecognitionImageFile();


            File faceList = new File("src/main/resources/FaceCapture/");

            List<Map<String, String>> listRecognisedImage = new ArrayList<Map<String, String>>();

            for(int index  =  0  ;  index  < faceList.listFiles().length  ; index  ++  ){
                listRecognisedImage.add(recogImage.evalulateImageRecognization(faceList.listFiles()[index]));
            }

           /* for(Map<String,String> map: listRecognisedImage){

            }*/

           System.out.println("List print :" + listRecognisedImage);



        }catch(Exception ex){

        }

    }




}
