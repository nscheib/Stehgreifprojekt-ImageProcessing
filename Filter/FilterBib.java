package Filter;

import AreaFilter.BlurFilter;
import ImageProcessing.Main;
import PixelFilter.*;
import SpecialFilter.WarHol;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;
//==========================================================//


/**
 * Diese Klasse enthaelt die gesamten Filter als HashMap
 * @author Felix Fuhrman, Nick Scheib
 * @Version inProgress
 */
public class FilterBib {

    /**
     * Methode enhaelt verschiedene Filter des Typs PixelFilter und AreaFilter
     * @param gewaehlterFilter ist der Filter aus dem Commandozeilenbefehl
     * @return gibt den gewaehlten Filter mit den passenden Parametern zurueck
     */
    public static IFilter getFilter(String gewaehlterFilter, String[]args){

        // HashMap der Filtersammlung, hier sind alle Filter gespeichert
        HashMap<String, IFilter> filter = new HashMap <String, IFilter>();

// Pixel Filter ================================================================

        // Monochrom
        filter.put("monochrom", new MonochromeFilter());

        // Threshold (PixelFilter)
        filter.put("threshold_128", new Threshold(128));
        filter.put("threshold_192", new Threshold(192));

        // Multithreshold
        filter.put("multithreshold", new MultiThreshold(64, 128, 192));

        // ColorReplacement
        filter.put("colorreplacement_64", new ColorReplaceFilter(FilterMethodenBib.getRGBColor(64,64,64)));
        filter.put("colorreplacement_128", new ColorReplaceFilter(FilterMethodenBib.getRGBColor(128,128,128)));
        filter.put("colorreplacement_192", new ColorReplaceFilter(FilterMethodenBib.getRGBColor(192,192,192)));

        //ColorBandFilter
        filter.put("colorband_rot", new ColorBandFilter("rot"));
        filter.put("colorband_gruen", new ColorBandFilter("gruen"));
        filter.put("colorband_blau", new ColorBandFilter("blau"));



// AreaFilter =================================================================

        //BlurFilter
        filter.put("blur_3", new BlurFilter(3));
        filter.put("blur_5", new BlurFilter(5));

        //PixelGraphicFilter
        //filter.put("pixel_20", new PixelGraphicFilter(20));
        //filter.put("pixel_40", new PixelGraphicFilter(40));
        //filter.put("pixel_60", new PixelGraphicFilter(60));



// Special Filter =============================================================

        // Warhole (Special)
        filter.put("warhol", new WarHol());



// RETURN =====================================================================

        // Gibt den aktuell gewaehlten Filter zurueck
        return filter.get(gewaehlterFilter);



    }

    //public static Set<HashMap.Entry<String, IFilter>> getHasMap() { return filter.entrySet(); }

}
