package SpecialFilter;

import Filter.FilterMethodenBib;
import PixelFilter.ColorReplaceFilter;
import PixelFilter.MultiThreshold;
//==========================================================//


/**
 * Diese Klasse enthaelt eine kombination aus Filtern die mithilfe des ChainFilters verarbeitet werden
 * @author Felix Fuhrman, Nick Scheib
 * @Version inProgress
 */
public class WarHol extends ChainFilter {

    /**
     * Methode gibt die ausgewaehlten Filter fuer die Weiterverarbeitung an den ChainFilter weiter.
     * Dieser FIlter ist erweiterbar
     */
    public WarHol(){

        mixFilter(new MultiThreshold(64,128,192));
        mixFilter(new ColorReplaceFilter(FilterMethodenBib.getRGBColor(64,64,64)));
        mixFilter(new ColorReplaceFilter(FilterMethodenBib.getRGBColor(128,128,128)));
        mixFilter(new ColorReplaceFilter(FilterMethodenBib.getRGBColor(192,192,192)));
        //mixFilter(new ColorReplaceFilter(FilterMethodenBib.getRGBColor(255,255,255)));
        //mixFilter(new BlurFilter(3));

    }
}
