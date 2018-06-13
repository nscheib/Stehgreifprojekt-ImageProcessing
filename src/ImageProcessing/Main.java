package ImageProcessing;

import Filter.FilterBib;
import Filter.IFilter;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Map;
//==========================================================//


/**
 * Das Programm erstellt mithilfe von verschiedenen Filtern, ein neues Bild, welches abgespeichert wird.
 * Hierzu kann wahlweise eine Maske hinzugefügt werden, dass nur einen Teilbereich des Bildes veraendert.
 *
 * @author Felix Fuhrman, Nick Scheib
 * @version inProgress
 */
public class Main {

    private static BufferedImage image = null, mask = null;
    private static String filtername = " ";

    /**
     * Methode welche das Programm startet
     * @param args sind die Parameter welche in der Commandozeile mitgegeben wurden
     */
    public static void main(String[] args) {

        // Initialisiert die Map mit allen Filtern aus der Klasse FilterBib
        FilterBib.filtermap();

        // Starten den Verarbeitungsprozess test oder ein einzelner Filter
        if (args[0].equals("test")) { alleFilter(args, mask); }
        else {
            readImg(args);
            procImage(args, image, mask, args[0]);
            saveImg(args, image, filtername);
        }

    } // END MAIN

    private static void readImg(String[] args) {

        try {
            // Das in der Commandozeile gewaehlte Bild wird in einer Variablen gespeichert
            image = ImageIO.read(new File(args[1]));
        } catch (IOException e) {
            e.printStackTrace();
        }

    } // END METHODE

    /**
     * Methode ist die Schnittstelle zum Bildverarbeitungsprozess
     * @param args sind die Parameter welche in der Commandozeile mitgegeben wurden
     * @param image ist das aktuelle Bild
     * @param mask ist die Benutzte Maske
     * @param filtername ist der aktuelle Name des Filters
     * @return gibt das bearbeitet Bild zurueck
     */
    private static BufferedImage procImage(String[] args, BufferedImage image, BufferedImage mask, String filtername) {

        // holt sich den Namen des Filters und die Parameter aus der Map
        IFilter filterOut = FilterBib.getFilter(filtername);

        try {
            // Zum ueberpruefen und abspeichern der Maske
            if (args[2].equalsIgnoreCase("-m")) { mask = ImageIO.read(new File(args[3])); }

            double time1 = System.currentTimeMillis();

            // Startet die Verarbeitung des Bildes || Bild + Maske, speichert das Ergebnis in Image
            if (mask == null) {
                image = filterOut.process(image);
            } else if (mask != null) {
                image = filterOut.process(image, mask);
            }

            // Ausgabe Filter und benoetigte Zeit
            System.out.println("Es wurde folgender Filter benutzt: <" + filtername + "> mit folgender Verarbeitungszeit in Millisekunden: " + (System.currentTimeMillis() - time1));

            // Gibt das Bild zum weiter verarbeiten zurueck
            return image;

        } catch(IOException e) {
            System.err.println("Es konnte keine Maske gefunden werden! <Error-Main.procImage-1>");
            e.printStackTrace();
        }
        return null;

    } // END METHODE


    /**
     * Methode speichert das Bild als .bmp Datei ab
     * @param args sind die Parameter welche in der Commandozeile mitgegeben wurden
     * @param image ist das aktuelle Bild
     * @param filtername ist der aktuelle Name des Filters
     */
    private static void saveImg(String[] args, BufferedImage image, String filtername) {

        try {
            // equalsIgnorCase ignoriert die Groß-/Kleinschreibung eines Wortes
            // speichert das bearbeitete Bild, mit dem in der Commandozeile eingegeben Namen ab
            if(args[0].equals("test")) {
                ImageIO.write(image, "bmp", new File("outputImage" + "_" + filtername + ".bmp"));
            } else if(args[2].equalsIgnoreCase("-m")) {
                ImageIO.write(image, "bmp", new File(args[4]));
            } else { ImageIO.write(image, "bmp", new File(args[2])); }
        } catch(IOException e) {
            System.err.println("Es konnte kein Bild gespeichert werden! <Error-Main.saveImg-1>");
            e.printStackTrace();
        }

    } // END METHODE


    /**
     * Methode welche alle Filter in ein einzelnes Bild abspeichert
     * @param args sind die Parameter welche in der Commandozeile mitgegeben wurden
     * @param mask ist die Benutzte Maske
     * @return gibt den aktuellen Filternamen zurueck
     */
    public static String alleFilter(String[]args, BufferedImage mask) {

        try {
            // Fall ein Filter gewaehlt wird, wird dieser gespeichert
            if(args[2].equalsIgnoreCase("-m")) { mask = ImageIO.read(new File(args[3])); }

            double time2 = System.currentTimeMillis();

            // Für jeden Filter in der HashMap wird dieser auf das Bild angewand und das Bild gespeichert
            for(Map.Entry<String,IFilter> filter : FilterBib.getFilterMap()) {
                image = ImageIO.read(new File(args[1]));
                filtername = filter.getKey();
                procImage(args, image, mask, filtername);
                saveImg(args, image, filtername);
            }
            System.out.println("Die gesamte Verarbeitungzeit, aller Filter dauerte: " + (System.currentTimeMillis() - time2) + " Millisek.");

        } catch(Exception e) {
            System.err.println("Es konnte kein Bild gespeichert werden! <Error-Main.alleFilter-1>");
            e.printStackTrace();
        }
        return filtername;
    }

}
