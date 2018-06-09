import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.File;
import de.hsrm.mi.prog.util.StaticScanner;

public class Start {
    public static BufferedImage img;
    public static void main(String[] args){

        bildEinlesen();
        testFilter();


    }

    private static void bildEinlesen() {
        Start.img = null;
        try {
            img = ImageIO.read(new File("test_image.bmp"));
        }catch (IOException e){
            e.printStackTrace();
        }
    }

    public static void testFilter(){
        /*

        */
        Eingabe abfrage = new Eingabe(img);
        abfrage.testFilter();




    }


    public static void speichereBild(String eingabe){
        File ausgabe = new File( eingabe + ".png");
        try {
            ImageIO.write(img, "png", ausgabe);
        }catch (IOException e){
            e.printStackTrace();
        }
    }




}
