package pixelfilter;

import java.awt.Color;
//--------------------------------


/**
 *
 */
public class ColorReplacementFilter extends PixelFilter {

    private Color farbeEins, farbeZwei;

    public ColorReplacementFilter(Color farbeEins, Color farbeZwei){
        this.farbeEins = farbeEins;
        this.farbeZwei = farbeZwei;
    }

    @Override
    protected int calculate(int farbPixel){

        return farbPixel;
    }
}
