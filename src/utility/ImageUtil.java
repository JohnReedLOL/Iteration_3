package utility;

// @author comcc_000
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.RenderingHints;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

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
    
    public static BufferedImage scale(int width, int height, BufferedImage image) {
        Image i = image;
        i = getScaledImage(i, width, height);
        return (BufferedImage) i;
    }

    public static Image getScaledImage(Image srcImg, int w, int h) {
        BufferedImage resizedImg = new BufferedImage(w, h, BufferedImage.TYPE_INT_ARGB);
        Graphics2D g2 = resizedImg.createGraphics();
        g2.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BILINEAR);
        g2.drawImage(srcImg, 0, 0, w, h, null);
        g2.dispose();
        return resizedImg;
    }

    /*Get-Sets*/

    /*Inner-classes*/

    /*Test Main Method*/
}
