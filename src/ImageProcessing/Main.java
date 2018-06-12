package ImageProcessing;

import Filter.IFilter;
import static Filter.FilterBib.getFilter;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
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
    private static HashMap<String, IFilter> filter;

    /**
     * Methode welche das Programm startet
     * @param args sind die Parameter welche in der Commandozeile mitgegeben wurden
     */
    public static void main(String[] args) {

        // Liest und speichert das Bild in der Variablen image und startet den Verarbeitungsprozess
        readImg(args);

        // Starten den Verarbeitungsprozess
        // "test" erstellt fuer jeden Filter ein Bild
        procImage(args, image, mask, filter);

        // Speichert das veraenderte Bild ab
        saveImg(args);

    } // END MAIN


    private static void readImg(String[] args) {

        try {
            // Das in der Commandozeile gewaehlte Bild wird in einer Variablen gespeichert
            image = ImageIO.read(new File(args[1]));
        } catch (IOException e) {
            e.printStackTrace();
        }

    } // END METHODE

    private static BufferedImage procImage(String[] args, BufferedImage image, BufferedImage mask, HashMap<String, IFilter> filter) {

        IFilter filterOut = getFilter(args[0], args);

        try {
            // Zum ueberpruefen und abspeichern der Maske
            if (args[2].equalsIgnoreCase("-m")) { mask = ImageIO.read(new File(args[3])); }

            // Zeiterfassung START
            long timeStart2 = System.currentTimeMillis();

            if (args[0].equalsIgnoreCase("test")){
                Main.alleFilter(filter, args);
            } else {
                // Startet die Verarbeitung des Bildes (+ Maske), speichert das Ergebnis in Image
                if (mask == null) {
                    image = filterOut.process(image);
                } else if (mask != null) {
                    image = filterOut.process(image, mask);
                }
            }

            // Ausgabe Filter und benoetigte Zeit
            System.out.println("Es wurde folgender Filter benutzt:" + filterOut.toString());
            System.out.println("Die gesamte Verarbeitungzeit: " + (System.currentTimeMillis() - timeStart2) + " Millisek.");

            // Gibt das Bild zum weiter verarbeiten zurueck
            return image;

        } catch(IOException e) {
            System.err.println("Es konnte keine Maske gefunden werden! <Error-Main.procImage-1>");
            e.printStackTrace();
        }
        return null;

    } // END METHODE


    private static void saveImg(String[] args) {

        try {
            // equalsIgnorCase ignoriert die Groß-/Kleinschreibung
            // speichert das bearbeitete Bild, mit dem in der Commandozeile eingegeben Namen ab
            if (args[2].equalsIgnoreCase("-m")) { ImageIO.write(image, "bmp", new File(args[4])); }
            else { ImageIO.write(image, "bmp", new File(args[2])); }
        } catch (IOException e) {
            System.err.println("Es konnte kein Bild gespeichert werden! <Error-Main.saveImg-1>");
            e.printStackTrace();
        }

    } // END METHODE


    public static void alleFilter(HashMap<String, IFilter> filter, String[]args) {

        Iterator iterator = filter.entrySet().iterator();

        long timeStart1 = System.currentTimeMillis();
        while (iterator.hasNext()) {

            Map.Entry aktFilter = (Map.Entry)iterator.next();

            try {
                image = ImageIO.read(new File(args[1]));
                if (args[2].equalsIgnoreCase("-m")) { mask = ImageIO.read(new File(args[3])); }

                IFilter imageOut = getFilter(aktFilter.getKey().toString(), args);
                System.out.println(imageOut.toString());

                ImageIO.write(filter.get(aktFilter.getKey().toString()).process(image, mask), "bmp", new File("outPutImage" + "_" + aktFilter.getKey().toString() + ".bmp"));

            } catch(Exception e) {
                System.err.println("Es konnte kein Bild gespeichert werden! <Error-Main.alleFilter-1>");
                e.printStackTrace();
            }
        }
        System.out.println("Die gesamte Verarbeitungzeit: " + (System.currentTimeMillis() - timeStart1) + " Millisek.");
    }

}
