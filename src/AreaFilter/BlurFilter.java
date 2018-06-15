package AreaFilter;
//==========================================================//

/**
 * Diese Klasse ist die Superklasse der einzelnen Klassen aus der Kategorie Pixel.
 * Hier werden Filter angewandt, die jeden Pixel einzeln auslesen und bearbeiten.
 * @author Felix Fuhrman, Nick Scheib
 * @Version inProgress
 */
public class BlurFilter extends AreaFilter {

    private int radius;

    public BlurFilter(int radius) { this.radius = radius;}


    @Override
    protected int calculate(int[] pixel, int[] maskPixel, int index, int width, int height) {

        int r = 0;
        int g = 0;
        int b = 0;
        int zaehler = 0;

        for (int i = (index - radius); i <= (index + radius); i++) {
            for (int j = index - (radius * width); j <= index + (width * radius); j += width) {
                if(i >= 0 && i < width && j >= 0 && j < height * height) {

                        r += getRot(pixel[i + j]);
                        g += getGruen(pixel[i + j]);
                        b += getBlau(pixel[i + j]);
                        zaehler++;

                }
            }
        }
        r /= zaehler;
        g /= zaehler;
        b /= zaehler;


        return getRGBColor(r, g, b) ;


    }

}
