package SpecialFilter;

import Filter.*;

import java.awt.image.BufferedImage;
import java.util.ArrayList;
//==========================================================//


/**
 * Diese Klasse kann mehrere Filter zusammen verarbeiten
 * @author Felix Fuhrman, Nick Scheib
 * @Version inProgress
 */
public class ChainFilter implements IFilter {

    // ArrayList, in diesem werden alle
    private ArrayList <IFilter> filterliste = new ArrayList<IFilter>();

    /**
     * Methode die ein Bild verarbeitet
     * @param image das aktuelle Bild
     * @return gibt das Bild auf den mehrere Filter angewandt wurde zurueck
     */
    @Override
    public BufferedImage process(BufferedImage... image) {

        /*
         * Fuer jeden Filter aus der ArrayList wird die processMethode aufgerufen
         * und in dem selben Bild gespeichert
         */
        for (IFilter alleFilter : filterliste){
            final long timeStart = System.currentTimeMillis();
            image[0] = alleFilter.process(image);
            final long timeEnd = System.currentTimeMillis();
            System.out.println("Verarbeitungszeit des Filters: "+ alleFilter.toString() + " dauerte " + (timeEnd - timeStart) + " Millisek.");
        }
        //gibt das mit allen Filtern verarbeitet Bild zurueck
        return image[0];
    }

    /**
     * Methode speichert Filter in der ArrayList
     * @param filter sind existierende Filter
     */
    public void mixFilter(IFilter filter){ filterliste.add(filter); }

}
