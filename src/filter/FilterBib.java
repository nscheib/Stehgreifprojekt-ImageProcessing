package filter;

import java.awt.*;
import java.util.HashMap;

import bereichsFilter.BlurFilter;
import bereichsFilter.PixelGraphicFilter;
import pixelfilter.ColorBandFilter;
import pixelfilter.ColorReplacementFilter;
import pixelfilter.Monochromfilter;
import pixelfilter.Threshold;
//--------------------------------

/**
 * Enthält und verwaltet alle schon erstellten IFilter und deren Einstellungen(Parametern)
 */
public class FilterBib {

    // HashMap der gesamten Filtersammlung
    private static HashMap <String, IFilter> filter = new HashMap <String, IFilter>();


    /**
     *  Methode enthaelt alle erstelleten IFilter mit benoetigten Parameter
     */
    public static void initialisieren() {

        //BlurFilter (BereichsFilter)
        filter.put("blur_3", new BlurFilter(3));
        filter.put("blur_5", new BlurFilter(5));

        //PixelGraphicFilter (BereichsFilter)
        filter.put("pixel_20", new PixelGraphicFilter(20));
        filter.put("pixel_40", new PixelGraphicFilter(40));
        filter.put("pixel_60", new PixelGraphicFilter(60));



        //MonochromFilter (Pixelfilter)
        filter.put("monochrom", new Monochromfilter());

        //Threshold (Pixelfilter)
        filter.put("threshold_64", new Threshold(64));
        filter.put("threshold_128", new Threshold(128));
        filter.put("threshold_192", new Threshold(192));

        //Multithreshold (Pixelfilter)
        filter.put("multithreshold_64", new Threshold(64, 128, 192));

        //ColorBandFilter (Pixelfilter)
        filter.put("colorreplacement_98", new ColorBandFilter(new Color(64,64,64)));
        filter.put("colorreplacement_160", new ColorBandFilter(new Color(128,128,128)));
        filter.put("colorreplacement_255", new ColorBandFilter(new Color(192,192,192)));

        //ColorBandFilter (Pixelfilter)
        filter.put("colorband_red", new ColorBandFilter(red));
        filter.put("colorband_green", new ColorBandFilter(green));
        filter.put("colorband_blue", new ColorBandFilter(blue));


        //KombinierteFilter
        filter.put("warhol", new ChainFilter(new Threshold(64, 128, 192), new ColorReplacementFilter(new Color(255,255,255)), ));
    }

    public static IFilter getFilter(String filterName, String [] args) {
        IFilter ausgewaehlt = filter.get(filterName);

        if(ausgewaehlt != null ){
            return ausgewaehlt;
        } else {
            System.err.println("Es wurde kein Filter gefunden! <Error-FilterBib.getFilter-1>");
        }
        return null;
    }
}
