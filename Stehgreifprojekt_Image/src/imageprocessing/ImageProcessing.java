package imageprocessing;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.logging.Filter;

import filter.FilterSammlung;
//--------------------------------


public class ImageProcessing {


    public static void main(String[]args){

        BufferedImage bufferedImage = null, mask = null;
        String outputFile, filterName = " ", maskFile = " ";


        // Die Hashmap wird initialisiert
        FilterSammlung.initialisieren();


        // Bild wird in bufferedImage geladen
        try{
            bufferedImage = ImageIO.read(new File("/Users/nick/Documents/Dropbox/Hochschule/Semester2/IdeaProjects/Stehgreifprojekt_Image/bildvorlagen/test_image.bmp"));
        }catch(IOException e){
            System.err.println("Es konnte kein Image gefunden werden! <Error-imageprocessing.ImageProcessing-1>");
        }


        // Maske wird in bufferedImage geladen
        try{
            mask = ImageIO.read(new File("/Users/nick/Documents/Dropbox/Hochschule/Semester2/IdeaProjects/Stehgreifprojekt_Image/bildvorlagen/test_image.bmp"));
        }catch(IOException e){
            System.err.println("Es konnte keine Makske gefunden werden! <Error-imageprocessing.ImageProcessing-2>");
        }


        // Startet den Filterprocess mit dem Bild, der Maske und den gewaehlten Filtername
        filterProcess(filterName, bufferedImage, mask);

    }


    public static void filterProcess(String filterName, String outputFile, BufferedImage bufferedImage, BufferedImage mask, BufferedImage img){

        // Speichert den  gewaehlten Filter in filtertyp ab
        Filter filterTyp;
        try{
            filterTyp = FilterSammlung.getFilter(filterName);
        }catch(Exception e){
            System.err.println("Es wurde kein "+ filterName +" gefunden werden! <Error-imageprocessing.ImageProcessing-3>");
        }


        // die Maske und das Bild wird mit dem Filter verarbeitet
        BufferedImage result;

        if(mask == null) {
            result = filterTyp.prozess(img);
        } else {
            result = filterTyp.prozess(img, mask);
        }


        // Filter wird als .bmp Datei gespeichert
        try {
            ImageIO.write(result, "bmp", new File(outputFile));
        } catch (IOException e) {
            System.err.println("Die Datei " + outputFile + " konnte nicht gespeichert werden. <Error-imageprocessing.ImageProcessing-4>");
        }
    }




}
