package PixelFilter;

//==========================================================//


/**
 * Diese Klasse enthaelt die gesamten Filter als HashMap
 * @author Felix Fuhrman, Nick Scheib
 * @Version inProgress
 */
public class ColorReplaceFilter extends PixelFilter {

    private int farbe1, farbe2;

    public ColorReplaceFilter(int farbe1) { this.farbe1 = farbe1; }

    @Override
    protected int calculate(int einzelPixel) {

        // Legt den Schwellenwert eines einzelnen Pixels fest.
        int helligkeit = Filter.FilterMethodenBib.getHelligkeit(einzelPixel);

        // Wenn Farbe2 leer ist wird eine RandomFarbe generiert. (Farbe2 ist immer leer)
        if (farbe2 == 0){ farbe2 = getRGBColor(((int) (Math.random() * 255)), ((int) (Math.random() * 255)), ((int) (Math.random() * 255))); }

        // Wenn vergleicht den Schwellenwert mit der
        if (getRGBColor(helligkeit, helligkeit, helligkeit) == getRGBColor(farbe1,farbe1,farbe1)) { return getRGBColor(farbe2, farbe2, farbe2); }
        else return einzelPixel;

    }
}
