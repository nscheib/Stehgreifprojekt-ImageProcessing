package pixelfilter;

//--------------------------------


/**
 *
 */
public class MultiThreshold extends PixelFilter {

    private int[] multithreshold;

    public MultiThreshold(int... multithreshold){
        this.multithreshold = multithreshold;
    }

    @Override
    protected int calculate(int schwellenwert){
        return schwellenwert;
    }
}
