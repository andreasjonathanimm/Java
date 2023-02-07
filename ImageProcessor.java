import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

/**
* Processes image in the following ways:<br>
* 1. Turn RGB to Grayscale<br>
* 2. Threshold Binary<br>
* 3. Threshold Binary Inverse<br>
* 4. Threshold Truncate<br>
* 5. Threshold To Zero<br>
* 6. Threshold To Zero Inverse<br>
* 7. Otsu Threshold
* @return .png file
*/
public class ImageProcessor {

    /**
     * Turns RGB to Grayscale
     * @return Grayscale value
     */
    public static int toGrayScale(int r, int g, int b) {
        return (r + g + b) / 3;
    }

    /**
     * Thresholds the Grayscale value of an image using the given threshold value to either the maxval or 0
     * @return <b>maxval</b> or 0
     */
    public static int thresholdBinary(int r, int g, int b, int threshold, int maxval) {
        int avg = (r + g + b) / 3;
        avg = (avg > threshold) ? maxval : 0;
        return avg;
    }

    /**
     * Thresholds the Grayscale value of an iamge using the given threshold value to either 0 or the maxval
     * @return 0 or <b>maxval</b>
     */
    public static int thresholdBinaryInverse(int r, int g, int b, int threshold, int maxval) {
        int avg = (r + g + b) / 3;
        avg = (avg > threshold) ? 0 : maxval;
        return avg;
    }

    /**
     * Thresholds the Grayscale value of an image using the given threshold value to either the threshold or the Grayscale value
     * @return <b>threshold</b> or Grayscale value
     */
    public static int thresholdTruncate(int r, int g, int b, int threshold) {
        int avg = (r + g + b) / 3;
        avg = (avg > threshold) ? threshold : avg;
        return avg;
    }

    /**
     * Thresholds the Grayscale value of an image using the given threshold value to either the Grayscale value or 0
     * @return 0 or Grayscale value
     */
    public static int thresholdToZero(int r, int g, int b, int threshold) {
        int avg = (r + g + b) / 3;
        avg = (avg > threshold) ? avg : 0;
        return avg;
    }

    /**
     * Thresholds the Grayscale value of an image using the given threshold value to either 0 or the Grayscale value
     * @return Grayscale value or 0
     */
    public static int thresholdToZeroInverse(int r, int g, int b, int threshold) {
        int avg = (r + g + b) / 3;
        avg = (avg > threshold) ? 0 : avg;
        return avg;
    }

    /**
     * Thresholds the Grayscale value of an image using the Otsu method
     * @return 0 or 255
     */
    public static BufferedImage otsuThreshold(BufferedImage image, int width, int height) {
        int[] histogram = new int[256];
        int total = width * height;

        // Calculate histogram
        for (int i = 0; i < width; i++) {
            for (int j = 0; j < height; j++) {
                int p = image.getRGB(i, j);

                int r = (p >> 16) & 0xFF;
                int g = (p >> 8) & 0xFF;
                int b = p & 0xFF;

                int avg = (r + g + b) / 3;
                histogram[avg]++;
            }
        }

        // Calculate sum
        float sum = 0;
        for (int i = 0; i < 256; i++) {
            sum += i * histogram[i];
        }

        float sumB = 0;
        int wB = 0;
        int wF = 0;

        float varMax = 0;
        int threshold = 0;

        for (int i = 0; i < 256; i++) {
            wB += histogram[i];
            if (wB == 0) {
                continue;
            }

            wF = total - wB;
            if (wF == 0) {
                break;
            }

            sumB += (float) (i * histogram[i]);
            float mB = sumB / wB;
            float mF = (sum - sumB) / wF;

            float varBetween = (float) wB * (float) wF * (mB - mF) * (mB - mF);

            if (varBetween > varMax) {
                varMax = varBetween;
                threshold = i;
            }
        }

        // Threshold the image
        for (int i = 0; i < width; i++) {
            for (int j = 0; j < height; j++) {
                int p = image.getRGB(i, j);

                int a = (p >> 24) & 0xFF;
                int r = (p >> 16) & 0xFF;
                int g = (p >> 8) & 0xFF;
                int b = p & 0xFF;

                int avg = (r + g + b) / 3;
                avg = (avg > threshold) ? 255 : 0;

                p = (a << 24) | (avg << 16) | (avg << 8) | avg;

                image.setRGB(i, j, p);
            }
        }
    return image;
    }

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

                // Turn RGB to Grayscale
                // r = g = b = toGrayScale(r, g, b);

                // Threshold Binary
                // r = g = b = thresholdBinary(r, g, b, 100, 255);

                // Threshold Binary Inverse
                // r = g = b = thresholdBinaryInverse(r, g, b, 100, 255);

                // Threshold Truncate
                // r = g = b = thresholdTruncate(r, g, b, 100);

                // Threshold To Zero
                // r = g = b = thresholdToZero(r, g, b, 100);

                // Threshold to Zero Inverse
                // r = g = b = thresholdToZeroInverse(r, g, b, 100);

                // Set new RGB value
                p = ((a) << 24) | (r << 16) | (g << 8) | b;
                image.setRGB(i, j, p);
            }
        }

        // Otsu Threshold
        image = otsuThreshold(image, width, height);

        // Writes an image to a file
        File outputFile = new File(
            "./test.png" // output file path
        );
        ImageIO.write(image, "png", outputFile);
        System.out.println("Writing complete.");
    }
}