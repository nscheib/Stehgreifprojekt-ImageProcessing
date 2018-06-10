package AreaFilter;

import Filter.IFilter;

import java.awt.image.BufferedImage;
//==========================================================//

/**
 * Diese Klasse ist die Superklasse der einzelnen Klassen aus der Kategorie Area.
 * Hier werden Filter angewandt, die bestimmte Bildbereiche ausliest und veraendert.
 * @author Felix Fuhrman, Nick Scheib
 * @Version inProgress
 */
public abstract class AreaFilter implements IFilter {

    @Override
    public BufferedImage process(BufferedImage... image){

        // Erzeugt zwei Objekten des Typs BufferedImage
        BufferedImage image1, image2;
/*
        // Wenn das Bild eine Laenge groeßer null hat, speicher es in image1 oder image1 = null
        if(image.length > 0){ image1 = image[0]; }
        else { image1 = null; }

        // Wenn das Bild eine Laenge groeßer 1 hat, speicher es in image2 oder image2 = null
        if(image.length > 1){ image2 = image[1]; }
        else { image2 = null; }


        // Gibt die width des BufferedImage zurueck als int-Wert
        int width = image1.getWidth();
        // Gibt die height des BufferedImage zurueck als int-Wert
        int height = image1.getHeight();

        // index initialisieren
        int index = 0;
*/
        return null;
    }

    protected abstract int calculate(int[]pixel, int[]maskPixel, int[]index, int width, int height);

}
