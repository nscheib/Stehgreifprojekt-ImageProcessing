import java.awt.*;
import java.awt.image.BufferedImage;

public class MonochromerFilter extends PixelFilter{

    public BufferedImage transformiere(BufferedImage img, int x){

        for (int i = 0; i < img.getWidth(); i++) {
            for (int j = 0; j < img.getHeight(); j++) {
                int rgb = Start.img.getRGB(i, j);
                Color c = new Color(rgb);
                int grau = (c.getRed() + c.getGreen() + c.getBlue()) / 3;
                Color c2 = new Color(grau, grau, grau);
                img.setRGB(i, j, c2.getRGB());
            }
        }
        return img;
    }

}
