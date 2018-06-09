package bereichsFilter;

//--------------------------------

/**
 *
 * Ein filter.IFilter, der das Bild mit einem simplen, linearen Verfahren weichzeichnet.
 * @author Lukas Richter, Benedikt Ringlein
 *
 */
public class BlurFilter extends BereichsFilter {

    private int radius;

    public BlurFilter(int radius) { this.radius = radius; }

    /*@Override
    protected int calculate(int[] pixel, int[] maskPixel, int index, int weite, int hoehe) {

    }*/

}
