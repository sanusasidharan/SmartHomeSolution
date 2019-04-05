package facerecognition;

import org.apache.commons.io.FilenameUtils;
import org.datavec.image.loader.NativeImageLoader;
import org.deeplearning4j.nn.multilayer.MultiLayerNetwork;
import org.deeplearning4j.util.ModelSerializer;
import org.nd4j.linalg.api.ndarray.INDArray;
import org.nd4j.linalg.dataset.api.preprocessor.DataNormalization;
import org.nd4j.linalg.dataset.api.preprocessor.ImagePreProcessingScaler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.util.List;

public class RecognizeFaceImpl {

    private static Logger log = LoggerFactory.getLogger(RecognizeFaceImpl.class);

    /** Location to save and extract the training/testing data */
    public static final String DATA_PATH = FilenameUtils.concat("src/main/resources/", "neuralnetwork");

    int height = 28;
    int width = 28;
    int channels = 1;
    MultiLayerNetwork model;

    public RecognizeFaceImpl() throws Exception {
        File locationToSave = new File(DATA_PATH + "smart_home_model.zip");
        model = ModelSerializer.restoreMultiLayerNetwork(locationToSave);

    }

    public void evalulateImageRecognization(File  imageFile) throws Exception{

        // Use NativeImageLoader to convert to numerical matrix
        NativeImageLoader loader = new NativeImageLoader(height, width, channels);

        // Get the image into an INDarray
        INDArray image = loader.asMatrix(imageFile);

        DataNormalization scaler = new ImagePreProcessingScaler(0, 1);
        scaler.transform(image);

        // Pass through to neural Net
        INDArray output = model.output(image);


    }



}
