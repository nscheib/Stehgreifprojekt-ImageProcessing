package AreaFilter;

import Filter.FilterMethodenBib;
import Filter.IFilter;

import java.awt.*;
import java.awt.image.BufferedImage;
//==========================================================//

/**
 * Diese Klasse ist die Superklasse der einzelnen Klassen aus der Kategorie Area.
 * Hier werden Filter angewandt, die bestimmte Bildbereiche ausliest und veraendert.
 * @author Felix Fuhrman, Nick Scheib
 * @Version inProgress
 */
public abstract class AreaFilter extends FilterMethodenBib {


    @Override
    public BufferedImage process(BufferedImage... image){


        int[] imgPixels = image[0].getRGB(0, 0, image[0].getWidth(), image[0].getHeight(), null, 0, image[0].getWidth());
        int[] pixelAusgabe = new int[imgPixels.length];
        int[] mask = null;

        for (int i = 0; i < imgPixels.length; i++) {
            pixelAusgabe[i] = calculate(imgPixels, mask, i, image[0].getWidth(), image[0].getHeight());
        }

        int zaehler = 0;
        BufferedImage image1 = new BufferedImage(image[0].getWidth(), image[0].getHeight(), BufferedImage.TYPE_INT_RGB);

        for (int i = 0; i < image[0].getWidth(); i++) {
            for (int j = 0; j < image[0].getHeight(); j++) {
                image1.setRGB(i, j , pixelAusgabe[zaehler]);
                zaehler++;
            }
        }


        return image1;
    }


    /**
     *  Abstracte Methode Calculate ruft die verarbeitung des Bildes durch einen Filter auf
     * @param pixel enthaelt alle Pixel eines Bildes
     * @param maskPixel enthealt alle Pixel einer Maske
     * @param index gibt den Index mit
     * @param width ist die Breite
     * @param height ist die Hoehe
     * @return gibt alle Parameter zurueck
     */
    protected abstract int calculate(int[]pixel, int[]maskPixel, int index, int width, int height);

}
