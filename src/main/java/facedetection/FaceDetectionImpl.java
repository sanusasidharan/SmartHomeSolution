package facedetection;

import org.openimaj.image.ImageUtilities;
import org.openimaj.image.processing.face.detection.DetectedFace;
import org.openimaj.image.processing.face.detection.HaarCascadeDetector;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.util.List;

public class FaceDetectionImpl {

    public void  detectFace() throws Exception{

        // Face detector to be used
        HaarCascadeDetector dector  = new HaarCascadeDetector();
        BufferedImage img= null;
        List<DetectedFace> faces = null;

        // Get the file from Camera Capture

        File cameraCapture2  = new File("testMe");
          cameraCapture2.createNewFile();
        File cameraCapture  = new File("src/main/resources/CameraCapture");

        for(int index  =  0  ;  index  < cameraCapture.listFiles().length  ; index  ++  ){

            faces  = dector.detectFaces(ImageUtilities.createFImage(ImageIO.read(cameraCapture.listFiles()[index])));

            for(int face  =  0 ; face < faces.size()  ; face ++){
                
                DetectedFace detectedFace  = faces.get(face);
                File faceFile  =  new File("src/main/resources/FaceCapture/Facefile_" + System.currentTimeMillis() + ".jpeg" );
                ImageUtilities.createBufferedImage(detectedFace.getFacePatch());
                boolean jpeg = ImageIO.write(ImageUtilities.createBufferedImage(detectedFace.getFacePatch()),"jpeg",faceFile);
            }
            cameraCapture.listFiles()[index].delete();

        }

    }

    public static void main(String arg[]) throws Exception{
        System.out.println("hello");
        FaceDetectionImpl  facedector  = new FaceDetectionImpl();
        facedector.detectFace();
    }
}
