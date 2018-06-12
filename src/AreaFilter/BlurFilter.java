package AreaFilter;
//==========================================================//

/**
 * Diese Klasse ist die Superklasse der einzelnen Klassen aus der Kategorie Pixel.
 * Hier werden Filter angewandt, die jeden Pixel einzeln auslesen und bearbeiten.
 * @author Felix Fuhrman, Nick Scheib
 * @Version inProgress
 */
public class BlurFilter extends AreaFilter {

    private int radius;

    public BlurFilter(int radius) { this.radius = radius;}


    @Override
    protected int calculate(int[] pixel, int[] maskPixel, int index, int width, int height) {

        int startX = Math.max(Math.min((index % width) - radius, width), 0);
        int startY = Math.max(Math.min((index % width) - radius, height), 0);

        int rot = 0;
        int gruen = 0;
        int blau = 0;

        // R, G und B Werte aller Umgebenden Pixel summieren
        for (int x = startX; x < startX + 2 * radius && x < width; x++) {
            x = Math.max(Math.min(x, width), 0);
            for (int y = startY; y < startY + 2 * radius && y < height; y++) {
                y = Math.max(Math.min(y, height), 0);
                rot += getRot(pixel[((width * y) + x)]);
                gruen += getGruen(pixel[((width * y) + x)]);
                blau += getBlau(pixel[((width * y) + x)]);
            }
        }

        // Pixel zurueckgeben
        return getRGBColor(rot, gruen, blau);

    }

}
