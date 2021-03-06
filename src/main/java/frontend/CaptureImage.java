package frontend;

import com.github.sarxos.webcam.*;

import javax.imageio.ImageIO;
import javax.swing.*;
import org.openimaj.image.processing.face.detection.*;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.awt.image.RenderedImage;
import java.io.File;
import java.io.IOException;
import java.util.*;
import java.util.List;


public class CaptureImage {

    private static final HaarCascadeDetector detector = new HaarCascadeDetector();
    private Webcam webcam = null;
    private BufferedImage img= null;
    private List<DetectedFace> faces = null;

    public void FaceDetector(JPanel panel) throws IOException {
        webcam = Webcam.getDefault();
        webcam.setViewSize(WebcamResolution.VGA.getSize());

        int count = 0;
        webcam.open(false);

        img = webcam.getImage();

        File outputfile = new File("src/main/resources/CameraCapture/CapturedImage_"+System.currentTimeMillis()+".jpg");
        ImageIO.write((RenderedImage) img, "jpg", outputfile);

        Image scaledImage = img.getScaledInstance(200,200, Image.SCALE_DEFAULT);
        JLabel imageLabel = new JLabel();
        imageLabel.setIcon(new ImageIcon(scaledImage));
        imageLabel.setBounds(50,50, 200,200);
        panel.add(imageLabel);
        panel.setPreferredSize(WebcamResolution.VGA.getSize());

        webcam.close();




        webcam.close();



    }
}
