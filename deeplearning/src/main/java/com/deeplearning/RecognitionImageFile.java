package com.deeplearning;

import org.apache.commons.io.FilenameUtils;
import org.datavec.image.loader.NativeImageLoader;
import org.deeplearning4j.nn.multilayer.MultiLayerNetwork;
import org.deeplearning4j.util.ModelSerializer;
import org.nd4j.linalg.api.ndarray.INDArray;
import org.nd4j.linalg.dataset.api.preprocessor.DataNormalization;
import org.nd4j.linalg.dataset.api.preprocessor.ImagePreProcessingScaler;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

public class RecognitionImageFile {

    int height = 28;
    int width = 28;
    int channels = 1;
    MultiLayerNetwork model;

    /** Location to save and extract the training/testing data */
    public static final String DATA_PATH = FilenameUtils.concat("src/main/resources/", "neuralnetwork");



    public Map<String,String> evalulateImageRecognization(File imageFile) throws Exception{


        File locationToSave = new File(DATA_PATH + "/smart_home_model.zip");
        model = ModelSerializer.restoreMultiLayerNetwork(locationToSave);

        // Use NativeImageLoader to convert to numerical matrix
        NativeImageLoader loader = new NativeImageLoader(height, width, channels);

        // Get the image into an INDarray
        INDArray image = loader.asMatrix(imageFile);

        DataNormalization scaler = new ImagePreProcessingScaler(0, 1);
        scaler.transform(image);

        // Pass through to neural Net
        INDArray output = model.output(image);


        Map<String,String> scores  = new HashMap<String, String>();
        String[] lables = {"chitra","eby","indu","rafeek","retheeh","saju","sanooj","sanu","saranya","vasantha"};
        for(int index  = 0  ; index < lables.length ; index ++ ){
            scores.put(lables[index],output.getColumn(index).toString());
        }

        System.out.println("scores :: " + scores);

        return  scores;
    }

    public static void main(String[] args) throws Exception{

        File imageFile  =  new File("src/main/resources/FaceCapture/Facefile_1554521778049.jpeg");

        RecognitionImageFile recognize  = new RecognitionImageFile();

        recognize.evalulateImageRecognization(imageFile);
    }

}
