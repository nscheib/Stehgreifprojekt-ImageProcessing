package pixelfilter;

import java.awt.Color;

import filterFunktionen.FarbenSammlung;
//--------------------------------


public class ColorBandFilter extends PixelFilter {

    private FarbenSammlung farbSammlung;

    public ColorBandFilter(FarbenSammlung farbSammlung){ this.farbSammlung = farbSammlung; }

    @Override
    protected int calculate(int farbPixel){

        switch(farbSammlung){
            case ROT:
                return new Color((farbPixel & 0xff), 0, 0).getRGB();
            case GRUEN:
                return new Color(0, ((farbPixel >> 8) & 0xff), 0).getRGB();
            case BLAU:
                return new Color(0, 0, ((farbPixel  >> 16) & 0xff)).getRGB();
            default:
                return 0;
        }

    }
}
