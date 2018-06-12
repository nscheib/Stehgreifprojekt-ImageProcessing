package Filter;

import java.awt.image.BufferedImage;
//==========================================================//


/**
 * Diese Klasse enthaelt einige nuetzliche Methoden die in verschiedenen Klassen benutz werden koennen
 * @author Felix Fuhrman, Nick Scheib
 * @Version inProgress
 */
public abstract class FilterMethodenBib implements IFilter{

    /**
     * Mit dieser Methode werden Bilder verarbeitet
     * @param image ist das geladene Bild
     */
    @Override
    public abstract BufferedImage process(BufferedImage... image);

    /**
     * Gibt den Alpha-Wert eines einzelnen Pixels zurueck
     * @param einzelPixel ein einzelner Pixel aus einem Bild
     * @return den Wert zwischen 0 und 255
     */
    public static int getAlpha(int einzelPixel){
        return ((einzelPixel >> 24) & 0xff);
    }

    /**
     * Gibt den roten Farbanteil eines einzelnen Pixels zurueck
     * @param einzelPixel ein einzelner Pixel aus einem Bild
     * @return den Wert zwischen 0 und 255
     */
    public static int getRot(int einzelPixel){
        return ((einzelPixel >> 16) & 0xFF);
    }

    /**
     * Gibt den gruen Farbanteil eines einzelnen Pixels zurueck
     * @param einzelPixel ein einzelner Pixel aus einem Bild
     * @return den Wert zwischen 0 und 255
     */
    public static int getGruen(int einzelPixel){
        return ((einzelPixel >> 16) & 0xFF);
    }

    /**
     * Gibt den gruen Farbanteil eines einzelnen Pixels zurueck
     * @param einzelPixel ein einzelner Pixel aus einem Bild
     * @return den Wert zwischen 0 und 255
     */
    public static int getBlau(int einzelPixel){
        return (einzelPixel & 0xFF);
    }

    /**
     * Mit dieser Methode wird der int-Wert eines einzelnen Pixel berechnet
     *
     * Wiki: Bitweises "oder", produziert eine 1, sobald einer seiner Operanden eine 1 ist
     * Wiki-Beispiel: 0b10111011 = 0b10001000 | 0b00111011
     *
     * @param rot der Rotanteil in einem Pixel
     * @param gruen der Gruenanteil in einem Pixel
     * @param blau der Blauanteil in einem Pixel
     * @return den erstellten int-Wert
     */
    public static int getRGBColor( int rot, int gruen, int blau){
        return (0xFF << 24) | (rot << 16) | (gruen << 8) | (blau);
    }

    /**
     * Mit dieser Methode wird der Helligkeitswert eines einzelnen Pixel zurueckgegeben
     * @param einzelPixel ein einzelner Pixel aus einem Bild
     * @return den Helligkeits/Grauwert eines einzelnen Pixels
     */
    public static int getHelligkeit(int einzelPixel){
        return ((getRot(einzelPixel) + getGruen(einzelPixel) + getBlau(einzelPixel)) / 3);
    }

}
