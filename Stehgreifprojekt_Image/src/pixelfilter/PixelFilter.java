package pixelfilter;

import java.awt.image.BufferedImage;
import java.util.logging.Filter;

public abstract class PixelFilter implements Filter {

    public BufferedImage process(BufferedImage... img) {

        /**
         * Pixelberechnung
         *
         */
        BufferedImage ergebnis = new BufferedImage(imageArray.getHoehe(), ImageArray.getWeite(), BufferedImage.TYPE_INT_RBG);



        return ergebnis;
    }

}
