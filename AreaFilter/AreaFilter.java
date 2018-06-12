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

        // Erzeugt zwei Objekten des Typs BufferedImage
        BufferedImage image1, image2;

        // Wenn das Bild eine Laenge groeßer null hat, speicher es in image1 oder image1 = null
        image1 = (image.length > 0) ? image[0] : null;

        // Wenn das Bild eine Laenge groeßer 1 hat, speicher es in image2 oder image2 = null
        image2 = (image.length > 1) ? image[1] : null;


        // Gibt die width des BufferedImage zurueck als int-Wert
        int width = image1.getWidth();
        // Gibt die height des BufferedImage zurueck als int-Wert
        int height = image1.getHeight();

        // index initialisieren
        int index = 0;

        // Gesamte Pixelanzahl wird in einem int Objekt gespeichert
        int[] pixel = new int[ (width * height) ];

        // Gesamte Pixelanzahl wird in einem int Objekt gespeichert
        int[] maskPixel = new int[ (width * height) ];

        // Erstellt eine Maske
        if (image2 != null) { maskPixel = imgkopie(image2, maskPixel, width, height); }
        else { System.out.println("Es wird keine Maske genutzt!"); }

        // Ruft die Methode calculate des gewaehlten Filters auf und veraendert ein Area mit mehreren Pixel
        for (int i = 0; i < width; i++) {
            for (int l = 0; l < height; l++) {
                if ( image2 == null || image2.getRGB(i,l) == new Color(255,255,255).getRGB()) {
                    image1.setRGB(i, l, calculate(pixel, maskPixel, index, width, height));
                }
            }
        }

        return image1;
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
