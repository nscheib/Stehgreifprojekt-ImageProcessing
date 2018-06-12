package Filter;

import AreaFilter.BlurFilter;
import PixelFilter.*;
import SpecialFilter.WarHol;

import java.util.*;
import java.util.logging.Filter;
//==========================================================//


/**
 * Diese Klasse enthaelt die gesamten Filter als HashMap
 * @author Felix Fuhrman, Nick Scheib
 * @Version inProgress
 */
public class FilterBib {

    // HashMap der Filtersammlung, hier sind alle Filter gespeichert
    private static HashMap<String, IFilter> filter = new HashMap <String, IFilter>();


    /**
     * Methode enhaelt verschiedene Filter des Typs PixelFilter und AreaFilter
     * @return gibt den gewaehlten Filter mit den passenden Parametern zurueck
     */
    public static void filtermap() {


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



    }

    public static Set<Map.Entry<String, IFilter>> getFilterMap(){ return filter.entrySet(); }


    public static IFilter getFilter(String filtername) {
        IFilter auswahl = filter.get(filtername);
        return auswahl;
    }
}
