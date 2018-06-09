package filterFunktionen;

import java.awt.Color;
import java.util.HashMap;

import bereichsFilter.BlurFilter;
import bereichsFilter.PixelGraphicFilter;
import pixelfilter.*;
import pixelfilter.MultiThreshold;
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

        //BlurFilter (AreaFilter)
        filter.put("blur_3", new BlurFilter(3));
        filter.put("blur_5", new BlurFilter(5));

        //PixelGraphicFilter (AreaFilter)
        filter.put("pixel_20", new PixelGraphicFilter(20));
        filter.put("pixel_40", new PixelGraphicFilter(40));
        filter.put("pixel_60", new PixelGraphicFilter(60));



        //MonochromFilter (Pixelfilter)
        filter.put("monochrom", new Monochromfilter());

        //MultiThreshold (Pixelfilter)
        filter.put("threshold_128", new ThresholdFilter(128));
        filter.put("threshold_192", new ThresholdFilter(192));

        //Multithreshold (Pixelfilter)
        filter.put("multithreshold", new MultiThreshold(64, 128, 192));

        //ColorBandFilter (Pixelfilter)
        filter.put("colorreplacement_64", new ColorReplacementFilter(new Color(64,64,64)));
        filter.put("colorreplacement_160", new ColorReplacementFilter(new Color(128,128,128)));
        filter.put("colorreplacement_255", new ColorReplacementFilter(new Color(192,192,192)));

        //ColorBandFilter (Pixelfilter)
        filter.put("colorband_red", new ColorBandFilter(FarbenSammlung.ROT));
        filter.put("colorband_green", new ColorBandFilter(FarbenSammlung.GRUEN));
        filter.put("colorband_blue", new ColorBandFilter(FarbenSammlung.BLAU));


        //KombinierteFilter
        filter.put("warhol", new ChainFilter(new MultiThreshold(64, 128, 192), new ColorReplacementFilter(new Color(255,255,255)), ));
    }

    public static IFilter getFilter(String filterName, String [] args) {
        IFilter ausgewaehlt = filter.get(filterName,args);

        if(ausgewaehlt != null ){
            return ausgewaehlt;
        } else {
            System.err.println("Es wurde kein Filter gefunden! <Error-FilterBib.getFilter-1>");
        }
        return null;
    }
}
