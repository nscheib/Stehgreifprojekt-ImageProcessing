import java.awt.image.BufferedImage;

public abstract class PixelFilter {

    protected BufferedImage img;


    public abstract BufferedImage transformiere(BufferedImage img, int i);
}
