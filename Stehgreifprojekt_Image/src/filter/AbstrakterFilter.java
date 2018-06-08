package filter;

import java.awt.image.BufferedImage;
import java.util.logging.Filter;

/**
 * Abstrakter Filter entheaelt benoetigte Methoden fuer die Klasse Filter
 */
public abstract class AbstrakterFilter implements Filter {


    public abstract AbstrakterFilter(BufferedImage... img);



}
