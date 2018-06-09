import de.hsrm.mi.prog.util.StaticScanner;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class Eingabe {


    private static BufferedImage img;
    private static int anzahl = 0;

    public Eingabe(BufferedImage img){
        this.img = img;
    }
    public static void testFilter() {


        PixelFilter filter;
        String eingabe = StaticScanner.nextString();
        if (eingabe.equals("blau")) {
            filter = new FarbFilter();
            speichereBild(eingabe, filter.transformiere(img, -3));
            speichereBild(eingabe, filter.transformiere(img, -3));
        } else if (eingabe.equals("gruen")) {
            filter = new FarbFilter();
            img = filter.transformiere(img, 2);
            speichereBild(eingabe, filter.transformiere(img, 2));
        } else if (eingabe.equals("rot")) {
            filter = new FarbFilter();
            img = filter.transformiere(img, 1);
            speichereBild(eingabe, filter.transformiere(img, 1));
        } else {
            System.out.println("Fehler");
        }
    }



    public static void speichereBild(String eingabe, BufferedImage png){

        File ausgabe = new File( eingabe + anzahl + ".png");
        anzahl++;
        try {
            ImageIO.write(png, "png", ausgabe);
        }catch (IOException e){
            e.printStackTrace();
        }
    }


}
