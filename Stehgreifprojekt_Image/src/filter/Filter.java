package filter;

import java.awt.image.BufferedImage;


/**
 * Schnittstelle fuer die Verarbeitung
 */
public interface Filter {

    //
    BufferedImage process(BufferedImage... img);

    //
    int getProgress();

}
