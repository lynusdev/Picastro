import imp.*;
import java.awt.Color;
import java.util.Random;

/**
 * Beschreiben Sie hier die Klasse Pixeloperationen.
 * 
 * @author (Ihr Name) 
 * @version (eine Versionsnummer oder ein Datum)
 */
public class Pixeloperationen
{
    // Instanzvariablen - ersetzen Sie das folgende Beispiel mit Ihren Variablen
    private int x;

    /**
     * Konstruktor für Objekte der Klasse Pixeloperationen
     */
    public Pixeloperationen()
    {
        // Instanzvariable initialisieren
        x = 0;
    }

    /**
     * Ein Beispiel einer Methode - ersetzen Sie diesen Kommentar mit Ihrem eigenen
     * 
     * @param  y    ein Beispielparameter für eine Methode
     * @return        die Summe aus x und y
     */
    public Picture nurRotkanal(Picture originalbild)
    {
        int breite = originalbild.getWidth();
        int hoehe  = originalbild.getHeight();

        Color[][] pixel = originalbild.getPixelArray();
        Color[][] pixelNeu = new Color[breite][hoehe];

        for(int x=0; x < breite; x++) {
            for(int y=0;y < hoehe; y++) {
                pixelNeu[x][y] = new Color(pixel[x][y].getRed(), 0, 0);
            }
        }

        Picture neuesBild = new Picture();
        neuesBild.setPixelArray(pixelNeu); 
        return neuesBild;
    }
    public Picture nurGruenkanal(Picture originalbild){
        Color[][] pixel = originalbild.getPixelArray(); 
        Color[][] pixelNeu = originalbild.getPixelArray();
        int breite = originalbild.getWidth();
        int hoehe = originalbild.getHeight();

        double gruen;

        for (int x = 0; x < breite; x++){

            for (int y = 0; y < hoehe; y++) {
                 //Rotwert
                gruen=pixel[x][y].getGreen();
                
                pixelNeu[x][y] = new Color((int) 0, (int) gruen, (int) 0);
            }
        }
        //Das Bild ausgeben
        Picture neuesBild = new Picture();        
        neuesBild.setPixelArray(pixelNeu); 
        return neuesBild;
    }
    public Picture nurBlaukanal(Picture originalbild){
        Color[][] pixel = originalbild.getPixelArray(); 
        Color[][] pixelNeu = originalbild.getPixelArray();
        int breite = originalbild.getWidth();
        int hoehe = originalbild.getHeight();

        double blau;

        for (int x = 0; x < breite; x++){

            for (int y = 0; y < hoehe; y++) {
                 //Rotwert
                blau=pixel[x][y].getBlue();
                
                pixelNeu[x][y] = new Color((int) 0, (int) 0, (int) blau);
            }
        }
        //Das Bild ausgeben
        Picture neuesBild = new Picture();        
        neuesBild.setPixelArray(pixelNeu); 
        return neuesBild;
    }
    public Picture graustufenDurchschnitt(Picture originalbild)
    {
        int breite = originalbild.getWidth();
        int hoehe  = originalbild.getHeight();

        Color[][] pixel = originalbild.getPixelArray();
        Color[][] pixelNeu = new Color[breite][hoehe];
        
        for(int x=0; x < breite; x++) {
            for(int y=0;y < hoehe; y++) {
                Color farbe;
                int rotanteil = pixel[x][y].getRed();
                int gruenanteil = pixel[x][y].getGreen();
                int blauanteil = pixel[x][y].getBlue();
                int durchschnitt = (rotanteil + gruenanteil + blauanteil)/3;
                pixelNeu[x][y] = new Color(durchschnitt, durchschnitt, durchschnitt);
            }
        }

        Picture neuesBild = new Picture();
        neuesBild.setPixelArray(pixelNeu); 
        return neuesBild;
    }
    public Picture graustufenMin(Picture originalbild)
    {
        int breite = originalbild.getWidth();
        int hoehe  = originalbild.getHeight();

        Color[][] pixel = originalbild.getPixelArray();
        Color[][] pixelNeu = new Color[breite][hoehe];
        
        for(int x=0; x < breite; x++) {
            for(int y=0;y < hoehe; y++) {
                Color farbe;
                int rotanteil = pixel[x][y].getRed();
                int gruenanteil = pixel[x][y].getGreen();
                int blauanteil = pixel[x][y].getBlue();
                int min = 0;
                if((rotanteil <= gruenanteil)&&(rotanteil<= blauanteil)){
                min = rotanteil;
                }
                if((blauanteil <= gruenanteil)&&(blauanteil<= rotanteil)){
                min = blauanteil;
                }
                if((gruenanteil <= rotanteil)&&(gruenanteil<= blauanteil)){
                min = gruenanteil;
                }
                pixelNeu[x][y] = new Color(min, min, min);
            }
        }

        Picture neuesBild = new Picture();
        neuesBild.setPixelArray(pixelNeu); 
        return neuesBild;
    }
    public Picture graustufenMax(Picture originalbild)
    {
        int breite = originalbild.getWidth();
        int hoehe  = originalbild.getHeight();

        Color[][] pixel = originalbild.getPixelArray();
        Color[][] pixelNeu = new Color[breite][hoehe];
        
        for(int x=0; x < breite; x++) {
            for(int y=0;y < hoehe; y++) {
                Color farbe;
                int rotanteil = pixel[x][y].getRed();
                int gruenanteil = pixel[x][y].getGreen();
                int blauanteil = pixel[x][y].getBlue();
                int max = 0;
                if((rotanteil >= gruenanteil)&&(rotanteil >= blauanteil)){
                max = rotanteil;
                }
                if((blauanteil >= gruenanteil)&&(blauanteil >= rotanteil)){
                max = blauanteil;
                }
                if((gruenanteil >= rotanteil)&&(gruenanteil >= blauanteil)){
                max = gruenanteil;
                }
                pixelNeu[x][y] = new Color(max, max, max);
            }
        }

        Picture neuesBild = new Picture();
        neuesBild.setPixelArray(pixelNeu); 
        return neuesBild;
    }
    public Picture graustufenNatuerlich(Picture originalbild)
    {
        int breite = originalbild.getWidth();
        int hoehe  = originalbild.getHeight();

        Color[][] pixel = originalbild.getPixelArray();
        Color[][] pixelNeu = new Color[breite][hoehe];
        
        for(int x=0; x < breite; x++) {
            for(int y=0;y < hoehe; y++) {
                Color farbe;
                int rotanteil = pixel[x][y].getRed();
                int gruenanteil = pixel[x][y].getGreen();
                int blauanteil = pixel[x][y].getBlue();
                int natuerlich = (299*rotanteil + 587*gruenanteil + 114*blauanteil)/1000;
                pixelNeu[x][y] = new Color(natuerlich, natuerlich, natuerlich);
            }
        }

        Picture neuesBild = new Picture();
        neuesBild.setPixelArray(pixelNeu); 
        return neuesBild;
    }
    public Picture invertiere(Picture originalbild)
    {
        int breite = originalbild.getWidth();
        int hoehe  = originalbild.getHeight();

        Color[][] pixel = originalbild.getPixelArray();
        Color[][] pixelNeu = new Color[breite][hoehe];
        
        for(int x=0; x < breite; x++) {
            for(int y=0;y < hoehe; y++) {                
                pixelNeu[x][y] = new Color(255-pixel[x][y].getRed(), 
                255-pixel[x][y].getGreen(), 255-pixel[x][y].getBlue());
            }
        }

        Picture neuesBild = new Picture();
        neuesBild.setPixelArray(pixelNeu); 
        return neuesBild;
    }
    public Picture tauscheRotGruen(Picture originalbild)
    {
        int breite = originalbild.getWidth();
        int hoehe  = originalbild.getHeight();

        Color[][] pixel = originalbild.getPixelArray();
        Color[][] pixelNeu = new Color[breite][hoehe];
        
        for(int x=0; x < breite; x++) {
            for(int y=0;y < hoehe; y++) {                
                pixelNeu[x][y] = new Color(pixel[x][y].getGreen(), 
                pixel[x][y].getRed(), pixel[x][y].getBlue());
            }
        }

        Picture neuesBild = new Picture();
        neuesBild.setPixelArray(pixelNeu); 
        return neuesBild;
    }
    
    public Picture tauscheGruenBlau(Picture originalbild)
    {  int breite = originalbild.getWidth();
        int  hoehe = originalbild.getHeight();

        Color[][] pixel = originalbild.getPixelArray();
        Color[][] pixelNeu = new Color[breite][hoehe];

        for(int x=0; x < breite; x++) {
            for(int y=0;y < hoehe; y++) {
                int getRed = pixel [x][y].getRed();
                int getGreen = pixel [x][y].getGreen();
                int getBlue = pixel [x][y].getBlue();

                pixelNeu [x][y]= new Color (getRed,getBlue,getGreen);
            }
        }

        Picture neuesBild = new Picture();
        neuesBild.setPixelArray(pixelNeu); 
        return neuesBild;
    }
       public Picture tauscheRotBlau(Picture originalbild)
    {  int breite = originalbild.getWidth();
        int  hoehe = originalbild.getHeight();

        Color[][] pixel = originalbild.getPixelArray();
        Color[][] pixelNeu = new Color[breite][hoehe];

        for(int x=0; x < breite; x++) {
            for(int y=0;y < hoehe; y++) {
                int getRed = pixel [x][y].getRed();
                int getGreen = pixel [x][y].getGreen();
                int getBlue = pixel [x][y].getBlue();

                pixelNeu [x][y]= new Color (getBlue,getGreen,getRed);
            }
        }

        Picture neuesBild = new Picture();
        neuesBild.setPixelArray(pixelNeu); 
        return neuesBild;
    }
}