import imp.*;
import java.awt.Color;
import java.util.Random;

/**
 * Algorithmen zur Änderung der Pixelpositionen eines Pictures
 * z.B. drehen, spiegeln usw.
 *
 * @author Thomas Schaller
 * @version 1.1 (28.11.2019)
 */
public class GeometrischeBildoperationen 
{
    /** spiegeleHorizontal spiegelt das Bild, so dass rechts und links getauscht werden
     * @param originalbild Ein Bild (Picture), das gespiegelt werden soll
     * @return Eine gespiegelte Kopie des Bildes
     */

    public  Picture DreheLinks(Picture originalbild) {
        int breite = originalbild.getWidth();
        int hoehe  = originalbild.getHeight();

        Color[][] pixel = originalbild.getPixelArray();
        Color[][] pixelNeu = new Color[hoehe][breite];

        for(int x=0; x < hoehe; x++) {
            for(int y=0;y < breite; y++) {
                pixelNeu[x][y] = pixel[(breite-1)-y][x];
            }
        }

        Picture neuesBild = new Picture();
        neuesBild.setPixelArray(pixelNeu); 
        return neuesBild;
    }
    public  Picture spiegleVertikal(Picture originalbild) {
        int breite = originalbild.getWidth();
        int hoehe  = originalbild.getHeight();

        Color[][] pixel = originalbild.getPixelArray();
        Color[][] pixelNeu = new Color[breite][hoehe];

        for(int x=0; x < breite; x++) {
            for(int y=0;y < hoehe; y++) {
                pixelNeu[x][y] = pixel[(breite-1)-x][y];
            }
        }
        Picture neuesBild = new Picture();
        neuesBild.setPixelArray(pixelNeu); 
        return neuesBild;
    }
    public  Picture dreheRechts(Picture originalbild) {
        int breite = originalbild.getWidth();
        int hoehe  = originalbild.getHeight();

        Color[][] pixel = originalbild.getPixelArray();
        Color[][] pixelNeu = new Color[hoehe][breite];

        for(int x=0; x < hoehe; x++) {
            for(int y=0;y < breite; y++) {
                pixelNeu[x][y] = pixel[y][(hoehe-1)-x];
            }
        }

        Picture neuesBild = new Picture();
        neuesBild.setPixelArray(pixelNeu); 
        return neuesBild;
    }
    public  Picture spiegleHorizontal(Picture originalbild) {
        int breite = originalbild.getWidth();
        int hoehe  = originalbild.getHeight();

        Color[][] pixel = originalbild.getPixelArray();
        Color[][] pixelNeu = new Color[breite][hoehe];

        for(int x=0; x < breite; x++) {
            for(int y=0;y < hoehe; y++) {
                pixelNeu[x][y] = pixel[x][(hoehe-1)-y];
            }
        }

        Picture neuesBild = new Picture();
        neuesBild.setPixelArray(pixelNeu); 
        return neuesBild;
    }
}
