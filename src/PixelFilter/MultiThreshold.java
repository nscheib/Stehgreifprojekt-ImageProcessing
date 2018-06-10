package PixelFilter;
//==========================================================//


/**
 * Diese Klasse berechnet die Farbe verschiedene Grau und Schwarztoene um. Dies geschiet durch die Verschiebung
 * der Bitstellen
 * @author Felix Fuhrman, Nick Scheib
 * @Version inProgress
 */
public class MultiThreshold extends PixelFilter {

    private int [] multiTresh;

    public MultiThreshold(int... multiTresh) { this.multiTresh = multiTresh; }

    @Override
    protected int calculate(int einzelPixel){

        // Ueberprueft, ob der letzte ArrayPlatz kleiner als der Schwellenwert eines einzelnen Pixels ist
        if(getHelligkeit(einzelPixel) > multiTresh[multiTresh.length - 1]){
            return getRGBColor(255, 255,255);
        }
        // Fuer die Arraylaenge, wird ein Pixel um einen Wert veraendert

        for (int i = 1; i >= 0; i--){
            if(getHelligkeit(einzelPixel) >= multiTresh[i]){
                return getRGBColor(multiTresh[i+1], multiTresh[i+1], multiTresh[i+1]);
            }
        }

        return getRGBColor(multiTresh[0], multiTresh[0], multiTresh[0]);

    }
}
