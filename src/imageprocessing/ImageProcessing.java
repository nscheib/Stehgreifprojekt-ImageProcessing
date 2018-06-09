package imageprocessing;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import filter.FilterBib;
import filter.IFilter;
//--------------------------------


public class ImageProcessing {

    public static void main(String[]args){

        BufferedImage bufferedImage = null, image = null, mask = null;
        String outputFile = " ", filterName = " ", maskFile = " ";

        // Die Hashmap wird initialisiert
        FilterBib.initialisieren();

        // Ruft den Process zum Bild/Maske laden, verarbeiten und speichern auf
        filterProcess(filterName, outputFile, bufferedImage, mask, image,args);

    }

    public static void filterProcess(String filterName, String outputFile, BufferedImage bufferedImage, BufferedImage mask, BufferedImage image, String [] args){

        try{
            // Bild wird aus den args gelesen und in image gespeichert
            image = ImageIO.read(new File(args[1]));
            if(args[2].equalsIgnoreCase("-m")){ mask = ImageIO.read(new File(args[3])); }
            if(args[0].equals("test")){ FilterBib.getFilter(args[0], args); }
            else {

                // die Maske und das Bild wird mit dem IFilter verarbeitet
                IFilter ergebnis = FilterBib.getFilter(args[0], args);
                if(mask == null ){ image = ergebnis.process(image); }
                else { image = ergebnis.process(image, mask); }
                System.out.println(ergebnis.toString());

                // Das gewaehlte Bild(+Maske) wird als .bmp Datei gespeichert
                if(args[2].equalsIgnoreCase("-m")){ ImageIO.write(image, "bmp", new File(args[4])); }
                else { ImageIO.write(image, "bmp", new File(args[2])); }

            }

        }catch(IOException e){
            System.err.println("Es konnte kein Image gefunden werden! <Error-Imageprocessing.filterProcess-1>");
        }

    }

}
