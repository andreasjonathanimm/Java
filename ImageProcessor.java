import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

public class ImageProcessor {
    public static void main(String[] args) throws IOException {
        int width = 1920;
        int height = 1440;

        BufferedImage image = new BufferedImage(
            width, height, BufferedImage.TYPE_INT_ARGB
        );;

        File inputFile = new File(
            "D:/Jojo_Data/java/Logo Unsri - Lalu Ahmad.png"
        );

        image = ImageIO.read(inputFile);

        System.out.println("Reading complete.");

        width = image.getWidth();
        height = image.getHeight();

        for (int i = 0; i < width; i++) {
            for (int j = 0; j < height; j++) {
                int p = image.getRGB(i, j);

                int a = (p >> 24) & 0xFF;
                int r = (p >> 16) & 0xFF;
                int g = (p >> 8) & 0xFF;
                int b = p & 0xFF;
                int avg = (r + g + b) / 3;
                avg = (avg % 2) * 255;
                r = g = b = avg;

                p = ((a) << 24) | (r << 16) | (g << 8) | b;
                image.setRGB(i, j, p);
            }
        }

        File outputFile = new File(
            "D:/Jojo_Data/java/test.png"
        );

        ImageIO.write(image, "png", outputFile);
        System.out.println("Writing complete.");
    }
}