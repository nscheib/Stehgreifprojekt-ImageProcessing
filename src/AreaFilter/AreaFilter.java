package AreaFilter;

import Filter.FilterMethodenBib;
import Filter.IFilter;

import java.awt.*;
import java.awt.image.BufferedImage;
//==========================================================//

/**
 * Diese Klasse ist die Superklasse der einzelnen Klassen aus der Kategorie Area.
 * Hier werden Filter angewandt, die bestimmte Bildbereiche ausliest und veraendert.
 * @author Felix Fuhrman, Nick Scheib
 * @Version inProgress
 */
public abstract class AreaFilter extends FilterMethodenBib {

    @Override
    public BufferedImage process(BufferedImage... image){

        int[] imgPixels = image[0].getRGB(0, 0, image[0].getWidth(), image[0].getHeight(), null, 0, image[0].getWidth());
        int[] maskPixels = null;
        int[] outputPixels = new int[imgPixels.length];

        if(image.length >= 2){
            maskPixels = image[1].getRGB(0, 0, image[1].getWidth(), image[1].getHeight(), null, 0, image[1].getWidth());

            for (int i = 0; i < imgPixels.length; i++) {
                if(getAlpha(maskPixels[i])>0){

                    // Pixel berechnen
                    outputPixels[i] = calculate(imgPixels, maskPixels, i, image[0].getWidth(), image[0].getHeight());

                    // Maske anwenden
                    outputPixels[i] = blend(imgPixels, outputPixels[i], maskPixels, i);
                }else{
                    // Alle Pixel berechnen (ohne Maske)
                    outputPixels[i] = imgPixels[i];
                }
            }
        }else{

            // Filter fuer jeden Pixel anwenden
            for (int i = 0; i < imgPixels.length; i++) {
                outputPixels[i] = calculate(imgPixels, maskPixels, i, image[0].getWidth(), image[0].getHeight());
            }
        }

        // Ergebnis in eine neues Bild schreiben
        BufferedImage result = new BufferedImage(image[0].getWidth(),
                image[0].getHeight(), BufferedImage.TYPE_INT_RGB);
        result.setRGB(0, 0, result.getWidth(), result.getHeight(),
                outputPixels, 0, result.getWidth());
        return result;
    }

    /**
     * Methode erstellt mithilfe der Parameter aus einem Bild eine exate Kopie
     * @param image ist das aktuelle Bild
     * @param kopie ist am Ende die Kopie des Bildes
     * @param width ist die Breite des Originals
     * @param height ist die Hoehe des Originals
     * @return gibt die fertige Kopie zurueck
     */
    public int[] imgkopie(BufferedImage image, int[]kopie, int width, int height){

        for (int i = 0; i < width; i++){
            for(int l = 0; l < height; l++){
                kopie[i] = image.getRGB( i, l);
            }
        }
        return kopie;
    }

    /**
     *  Abstracte Methode Calculate ruft die verarbeitung des Bildes durch einen Filter auf
     * @param pixel enthaelt alle Pixel eines Bildes
     * @param maskPixel enthealt alle Pixel einer Maske
     * @param index gibt den Index mit
     * @param width ist die Breite
     * @param height ist die Hoehe
     * @return gibt alle Parameter zurueck
     */
    protected abstract int calculate(int[]pixel, int[]maskPixel, int index, int width, int height);

}
