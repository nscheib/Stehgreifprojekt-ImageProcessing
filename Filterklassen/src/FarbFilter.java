import java.awt.*;
import java.awt.image.BufferedImage;

public class FarbFilter extends PixelFilter{

    public BufferedImage transformiere(BufferedImage img, int loescher){
        for (int i = 0; i < img.getWidth(); i++) {
            for (int j = 0; j < img.getHeight(); j++) {
                int rgb = Start.img.getRGB(i, j);
                int ergebnis;
                int rot = (rgb >> 16) & 0x000000FF;
                int gruen = (rgb >>8 ) & 0x000000FF;
                int blau = (rgb) & 0x000000FF;

                if(loescher == 3) {
                    rot = 0;
                    gruen = 0;
                }else if(loescher == 2){
                    rot = 0;
                    blau = 0;
                }else if(loescher == 1) {
                    gruen = 0;
                    blau = 0;
                }else if(loescher == -1){
                    blau = 0;
                }
                else if(loescher == -2){
                    gruen = 0;
                }
                else if(loescher == -3){
                    rot = 0;
                }
                Color c = new Color(rot, gruen, blau );

                    img.setRGB(i, j, c.getRGB());
            }
        }
        return img;
    }


}
