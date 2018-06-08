import java.util.HashMap;
import java.util.logging.Filter;

public class FilterSammlung {

    // HashMap Filtersammlung
    private static HashMap <String, Filter> existierenderFilter = new HashMap <String, Filter>();


    public static void initialisieren() {

        /**
         * Filtersammlung
         * mit Objekterstellung
         * und Variablen
         */
        existierenderFilter.get("blur_3", new BlurFilter(3));
        existierenderFilter.get("blur_3", new BlurFilter(5));
    }

    public static Filter getFilter(String filterName){

        Filter auswahl = .get(filterName);
        return auswahl;
    }
}
