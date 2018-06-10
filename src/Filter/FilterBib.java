package Filter;

import PixelFilter.ColorReplaceFilter;
import PixelFilter.MonochromeFilter;
import PixelFilter.MultiThreshold;
import PixelFilter.Threshold;
import SpecialFilter.WarHol;

import java.util.HashMap;
//==========================================================//


/**
 * Diese Klasse enthaelt die gesamten Filter als HashMap
 * @author Felix Fuhrman, Nick Scheib
 * @Version inProgress
 */
public class FilterBib {

    // HashMap der gesamten Filtersammlung
    private static HashMap<String, IFilter> filter = new HashMap <String, IFilter>();

    public static IFilter getFilter(String gewaehlterFilter, String[]args){

// Pixel Filter ================================================================

        // Monochrom (PixelFilter)
        filter.put("monochrom", new MonochromeFilter());

        // Threshold (PixelFilter)
        filter.put("threshold_128", new Threshold(128));
        filter.put("threshold_192", new Threshold(192));

        // Multithreshold (PixelFilter)
        filter.put("multithreshold", new MultiThreshold(64, 128, 192));

        // ColorReplacement (PixelFilter)
        filter.put("colorreplacement_64", new ColorReplaceFilter(FilterMethodenBib.getRGBColor(64,64,64)));
        filter.put("colorreplacement_128", new ColorReplaceFilter(FilterMethodenBib.getRGBColor(128,128,128)));
        filter.put("colorreplacement_192", new ColorReplaceFilter(FilterMethodenBib.getRGBColor(192,192,192)));

        //ColorBandFilter (Pixelfilter)
        //filter.put("colorband_red", new ColorBandFilter(red));
        //filter.put("colorband_green", new ColorBandFilter(green));
        //filter.put("colorband_blue", new ColorBandFilter(blue));



// AreaFilter =================================================================

        //BlurFilter (BereichsFilter)
        //filter.put("blur_3", new BlurFilter(3));

        //PixelGraphicFilter (BereichsFilter)
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

}
