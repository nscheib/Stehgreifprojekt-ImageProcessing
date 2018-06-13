package PixelFilter;

import Filter.IFilter;
import Filter.FilterMethodenBib;

import java.awt.*;
import java.awt.image.BufferedImage;
//==========================================================//

/**
 * Diese Klasse ist die Superklasse der einzelnen Klassen aus der Kategorie Pixel.
 * Hier werden Filter angewandt, die jeden Pixel einzeln auslesen und bearbeiten.
 * @author Felix Fuhrman, Nick Scheib
 * @Version inProgress
 */
public abstract class PixelFilter extends FilterMethodenBib{

    /**
     *  Methode durchlauft jeden Pixel des Bildes und ruft die entsprechende Methode des gewaehlten Filters auf
     * @param image das ausgewaehlte Bild
     * @return gibt das bearbeitet Bild zurueck
     */
    @Override
    public BufferedImage process(BufferedImage... image){

        // Erzeugt zwei Objekten des Typs BufferedImage
        BufferedImage image1, image2;

        // Wenn das Bild eine Laenge groeßer null hat, speicher es in image1 oder image1 = null
        image1 = (image.length > 0) ? image[0] : null;

        // Wenn das Bild eine Laenge groeßer 1 hat, speicher es in image2 oder image2 = null
        image2 = (image.length > 1) ? image[1] : null;

        // Gibt die width des BufferedImage zurueck als int-Wert
        int width = image1.getWidth();
        // Gibt die height des BufferedImage zurueck als int-Wert
        int height = image1.getHeight();

        // Durchlauft das Bild Pixel fuer Pixel in der Hoehe und Breite
        for (int u = 0; u < width; u++) {
            for (int v = 0; v < height; v++) {

                // Ruft die Methode calculate des gewaehlten Filters auf und veraendert den einzelnen Pixel
                if (image2 == null || image2.getRGB(u, v) == new Color(255,255,255).getRGB()) {
                    image1.setRGB(u, v, calculate(image[0].getRGB(u, v)));
                }

            }
        }
        return image1;
    }

    /**
     *  Abstrakte Klasse calculate wird benoetigt um aus dem gewaehlten Filter, die Farbe eines Pixels zu erhalten
     * @param pixelColor ist ein intWert in welchem der FarbenCode eines Pixels gespeichert ist
     * @return gibt den FarbPixel zurueck
     */
    protected abstract int calculate(int pixelColor);

}
