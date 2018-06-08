package filter;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import areafilter.BlurFilter;
//--------------------------------


public class FilterSammlung {

    // HashMap der gesamten Filtersammlung
    private static HashMap <String, Filter> vorhandeneFilter = new HashMap <String, Filter>();


    /**
     *  Methode enthaelt alle erstelleten Filter mit benoetigten Parameter
     */
    public static void initialisieren() {

        vorhandeneFilter.put("blur_3", new BlurFilter(3));
        vorhandeneFilter.put("blur_3", new BlurFilter(5));
    }

    /**
     *  Methode um die ganze HashMap zu returnen. Inklusive aller enthaltener Filter
     * @return gibt die HashMap zurueck
     */
    public static Set<Map.Entry<String,Filter>> holeAlleFilter(){return vorhandeneFilter.entrySet();}

    public static Filter getFilter(String filterName){
        Filter ausgewaehlt = vorhandeneFilter.get(filterName);

        if(ausgewaehlt == null ){
            //throws Exeption ERROR
        } else {return ausgewaehlt;}
        return null;
    }
}
