package pixelfilter;

import pixelfilter.PixelFilter;
//--------------------------------


/**
 *
 */
public class ThresholdFilter extends PixelFilter {

    private int schwellenWert;

    public ThresholdFilter (int schwellenWert){
        this.schwellenWert = schwellenWert;
    }

}
