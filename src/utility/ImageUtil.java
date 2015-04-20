package utility;

// @author comcc_000
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.RenderingHints;
import java.awt.image.BufferedImage;
import java.awt.image.RescaleOp;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;

public class ImageUtil {

    /*Properties*/

    /*Constructors*/

    /*Methods*/
    public static final Image getImage(String filename) {
        return extractImage(filename);
    }

    private static final BufferedImage extractImage(String filename) {
        File file = openFile(filename);
        BufferedImage img = extractImage(file);
        return img;
    }

    private static final BufferedImage extractImage(File file) {
        try {
            return ImageIO.read(file);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    private static final File openFile(String filename) {
        return new File(filename);
    }

    public static BufferedImage scaleBufferedImage(int width, int height, BufferedImage image) {
        Image i = image;
        i = scaleImage(i, width, height);
        return (BufferedImage) i;
    }

    public static Image scaleImage(Image srcImg, int w, int h) {
        BufferedImage resizedImg = new BufferedImage(w, h, BufferedImage.TYPE_INT_ARGB);
        Graphics2D g2 = resizedImg.createGraphics();
        g2.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BILINEAR);
        g2.drawImage(srcImg, 0, 0, w, h, null);
        g2.dispose();
        return resizedImg;
    }

    /**
     * Takes in a BufferedImage and a percentage and produces a new
     * BufferedImage that is darker by that percentage amount.
     *
     * @param bufferedImage - image to be copied and darkened.
     * @param percentage - percentage to darken that BufferedImage by. If this
     * value were 10 it would darken the image by 10%.
     * @return The darkened image.
     */
    public BufferedImage produceBufferedImageDarkenedByPercentage(BufferedImage bufferedImage, int percentage) {
        if (percentage < 0 || percentage > 100) {
            throw new IllegalArgumentException("Illegal percentage");
        }
        final int remainder = 100 - percentage;
        final float remaining_light = (float) remainder;
        RescaleOp op = new RescaleOp(remaining_light, 0, null);
        // If the destination image (second parameter of op.filter) is null, a [new] BufferedImage will be created.
        BufferedImage darkened_image = op.filter(bufferedImage, null);
        return darkened_image;
    }

    public static ImageIcon getImageIcon(String filename) {
        BufferedImage bi = extractImage(filename);
        return new ImageIcon(bi);
    }
    
    /*Get-Sets*/

    /*Inner-classes*/

    /*Test Main Method*/
}
