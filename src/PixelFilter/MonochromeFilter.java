package PixelFilter;

import java.awt.Color;
//==========================================================//


/**
 * Diese Klasse berechnet die Farbe in einen Grauton um. Dies geschiet durch die Verschiebung
 * der Bitstellen
 * @author Felix Fuhrman, Nick Scheib
 * @Version inProgress
 */
public class MonochromeFilter extends PixelFilter {

    /**
     * Methode veraendert die Farbe eines einzelnen Pixels in einen Grauton
     * @param einzelPixel ist ein einzelner Pixel
     * @return gibt den veraenderten Pixelwert zurueck
     */
    @Override
    protected int calculate(int einzelPixel){

        // Rechnet die Farben eines einzelnen Pixels zusammen, um daraus einen Helligkeitswert zu erhalten
        int helligkeitsWert = Filter.FilterMethodenBib.getHelligkeit(einzelPixel);

        // Gibt den Helligkeitswert als neues Objekt zurueck
        return new Color(helligkeitsWert,helligkeitsWert,helligkeitsWert).getRGB();
    }

}
