package bereichsFilter;

import java.awt.image.BufferedImage;

import filterFunktionen.IFilter;
//--------------------------------


public abstract class AreaFilter implements IFilter {

    /**
     *  Methode die den gewaehlten Filter der Sorte PixelFilter benutzt + Maske (wenn diese gewaehlt)
     * @param images
     * @return
     */
    @Override
    public BufferedImage process(BufferedImage ... images){

        return null;
    }

}
