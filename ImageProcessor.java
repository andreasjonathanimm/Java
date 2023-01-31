import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

/**
* Processes image in the following ways:<br>
* 1. Turn RGB to Grayscale<br>
* 2. Threshold
* @return .png file
*/
public class ImageProcessor {

    public static void main(String[] args) throws IOException {
        // Image size
        int width = 1920;
        int height = 1440;

        // Declares an image in RAM
        BufferedImage image = new BufferedImage(
            width, height, BufferedImage.TYPE_INT_ARGB
        );;

        // Reads an image from a file
        File inputFile = new File(
            "./image.png" // input file path
        );
        image = ImageIO.read(inputFile);
        System.out.println("Reading complete.");

        // Process the image
        width = image.getWidth();
        height = image.getHeight();

        for (int i = 0; i < width; i++) {
            for (int j = 0; j < height; j++) {
                int p = image.getRGB(i, j);

                int a = (p >> 24) & 0xFF;
                int r = (p >> 16) & 0xFF;
                int g = (p >> 8) & 0xFF;
                int b = p & 0xFF;

                // // Turn RGB to Grayscale
                // int avg = (r + g + b) / 3;
                // avg = (avg % 2) * 255;
                // r = g = b = avg;

                int threshold = 100;
                // // Threshold RGB
                // r = (r > threshold) ? 255 : 0;
                // g = (g > threshold) ? 255 : 0;
                // b = (b > threshold) ? 255 : 0;
                
                // Threshold Grayscale
                int avg = (r + g + b) / 3;
                avg = (avg > threshold) ? 255 : 0;
                r = g = b = avg;

                // Set new RGB value
                p = ((a) << 24) | (r << 16) | (g << 8) | b;
                image.setRGB(i, j, p);
            }
        }

        // Writes an image to a file
        File outputFile = new File(
            "./test.png" // output file path
        );
        ImageIO.write(image, "png", outputFile);
        System.out.println("Writing complete.");
    }
}