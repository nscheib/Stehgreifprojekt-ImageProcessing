package PixelFilter;
//==========================================================//


/**
 * Diese Klasse berechnet die Farbe in einen Schwarzton um. Dies geschiet durch die Verschiebung
 * der Bitstellen
 * @author Felix Fuhrman, Nick Scheib
 * @Version inProgress
 */
public class ColorBandFilter extends PixelFilter {

    private String colorBand;

    public ColorBandFilter(String colorBand) { this.colorBand = colorBand; }

    /**
     * Methode aendert das gesamten Farbspektrum in eine einzige Farbe um
     * @param einzelPixel ist ein einzelner Pixel
     * @return gibt den veraenderten Pixelwert zurueck
     */
    @Override
    protected int calculate(int einzelPixel) {

        switch(colorBand) {
            case "rot": return getRGBColor(getRot(einzelPixel), 0, 0 );
            case "gruen": return getRGBColor(0, getGruen(einzelPixel), 0 );
            case "blau": return getRGBColor(0,0, getBlau(einzelPixel));
            default: return getRGBColor(0,0,0);
        }

    }

}
