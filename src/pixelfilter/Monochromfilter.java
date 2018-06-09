package pixelfilter;

import java.awt.Color;
//--------------------------------


public class Monochromfilter extends PixelFilter {

    @Override
    protected int calculate(int farbPixel){

        int rot = (farbPixel & 0xff);
        int gruen = ((farbPixel >> 8) & 0xff);
        int blau = (farbPixel >> 16) & 0xff;

        int helligkeit = (rot + gruen + blau) /3;

        return new Color(helligkeit, helligkeit, helligkeit).getRGB();
    }

}
