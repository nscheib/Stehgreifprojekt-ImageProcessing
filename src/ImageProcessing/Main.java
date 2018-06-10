package ImageProcessing;

import Filter.IFilter;
import static Filter.FilterBib.getFilter;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
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

    /**
     * Methode welche das Programm startet
     * @param args sind die Parameter welche in der Commandozeile mitgegeben wurden
     */
    public static void main(String[] args) {

        // Liest und speichert das Bild in der Variablen image und startet den Verarbeitungsprozess
        readImg(args);
        // Starten den Verarbeitungsprozess
        procImage(args);
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

    private static BufferedImage procImage(String[] args) {

        IFilter filterOut = getFilter(args[0], args);

        try {
             // "test" erstellt fuer jeden Filter ein Bild
            if (args[0].equals("test")) {
                final long timeStart1 = System.currentTimeMillis();
                getFilter(args[0], args);
                final long timeEnd1 = System.currentTimeMillis();
                System.out.println("Verarbeitungszeit: " + (timeEnd1 - timeStart1) + " Millisek.");
            } else {
                // Zum ueberpruefen und abspeichern der Maske
                if (args[2].equalsIgnoreCase("-m")) { mask = ImageIO.read(new File(args[3])); }

                // Zeiterfassung START
                final long timeStart2 = System.currentTimeMillis();

                // Startet die Verarbeitung des Bildes (+ Maske), speichert das Ergebnis in Image
                if (mask == null) {
                    image = filterOut.process(image);
                } else if (mask != null) {
                    image = filterOut.process(image, mask);
                }

                // Zeiterfassung ENDE
                final long timeEnd2 = System.currentTimeMillis();

                // Ausgabe Filter und benoetigte Zeit
                System.out.println("Es wurde folgender Filter benutzt:" + filterOut.toString());
                System.out.println("Die gesamte Verarbeitungzeit: " + (timeEnd2 - timeStart2) + " Millisek.");

                // Gibt das Bild zum weiter verarbeiten zurueck
                return image;
            }
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
            System.err.println("Es konnte kein Bild gepsiechert werden! <Error-Main.saveImg-1>");
            e.printStackTrace();
        }

    } // END METHODE


}
