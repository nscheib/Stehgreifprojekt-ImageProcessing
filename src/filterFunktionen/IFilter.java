package filterFunktionen;

import java.awt.image.BufferedImage;
//--------------------------------


/**
 * Ein Interface mithilfe dessen, ein Bild verarbeitet wird
 */
public interface IFilter {

    // Das gewaehlte Bild wird verarbeitet
    BufferedImage process(BufferedImage ... images);
}
