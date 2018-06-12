package PixelFilter;
//==========================================================//


/**
 * Diese Klasse berechnet die Farbe in einen Schwarzton um. Dies geschiet durch die Verschiebung
 * der Bitstellen
 * @author Felix Fuhrman, Nick Scheib
 * @Version inProgress
 */
public class Threshold extends PixelFilter {

    private int schwellenWert;

    public Threshold(int schwellenWert){ this.schwellenWert = schwellenWert;}

    /**
     * Methode veraendert von einem bestimmten Schwellenwert(grauWert) die Farbe in Graustufen
     * @param einzelPixel ist ein einzelner Pixel
     * @return gibt den veraenderten Pixelwert zurueck
     */
    @Override
    protected int calculate(int einzelPixel) {

        // Rechnet die Farben eines einzelnen Pixels zusammen, um daraus einen helleren Grauton zu erhalten
        int grauWert = Filter.FilterMethodenBib.getHelligkeit(einzelPixel);

        if(schwellenWert <= grauWert){
            // Die Farben werden in Schwarz durch Verschiebung der Bitstellen, geaendert
            return getRGBColor(255,255,255);
        } else if (schwellenWert > grauWert){
            // Die Farben werden in Weiß durch Verschiebung der Bitstellen, geaendert
            return getRGBColor(0,0,0);
        } else {
            return 0;
        }

    }

}
