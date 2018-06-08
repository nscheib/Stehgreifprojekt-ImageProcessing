import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.logging.Filter;

public class ImageProcessing {



    public static void main(String[]args){

        BufferedImage bufferedImage = null, mask = null;
        String filterName = null;

        // Filter initialisieren
        FilterSammlung.initialisieren();



        try{
            bufferedImage = ImageIO.read(new File("/Users/nick/Documents/Dropbox/Hochschule/Semester2/IdeaProjects/Stehgreifprojekt_Image/bildvorlagen/test_image.bmp"));
        }catch(IOException e){
            System.err.println("Es konnte kein Image gefunden werden! <Error-ImageProcessing-1>");
        }

        try{
            mask = ImageIO.read(new File("/Users/nick/Documents/Dropbox/Hochschule/Semester2/IdeaProjects/Stehgreifprojekt_Image/bildvorlagen/test_image.bmp"));
        }catch(IOException e){
            System.err.println("Es konnte keine Makske gefunden werden! <Error-ImageProcessing-2>");
        }

        filterProcess(filterName, bufferedImage, mask);

    }


    public static void filterProcess(String filterName, BufferedImage bufferedImage, BufferedImage mask){

        Filter filter;

        try{
            filter = FilterSammlung.getFilter(filterName);
        }catch(Exception e){
            System.err.println("Es konnte keine Makske gefunden werden! <Error-ImageProcessing-2>");
        }


        /**
         *  Filter/Bildverarbeitung
         */
    }




}
