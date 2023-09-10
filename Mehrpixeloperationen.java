import imp.*;
import java.awt.Color;

/**
 * Beschreiben Sie hier die Klasse Mehrpixeloperationen.
 * 
 * @author (Ihr Name) 
 * @version (eine Versionsnummer oder ein Datum)
 */
public class Mehrpixeloperationen
{
    // Instanzvariablen - ersetzen Sie das folgende Beispiel mit Ihren Variablen
    private int x;

    /**
     * Konstruktor für Objekte der Klasse Mehrpixeloperationen
     */
    public Mehrpixeloperationen()
    {
        // Instanzvariable initialisieren
        x = 0;
    }
    public Picture faltung(Picture originalbild, double[][] filter) {
        Color[][] pixel = originalbild.getPixelArray(); 
        Color[][] pixelNeu = originalbild.getPixelArray();
        
        int laenge = filter.length;  
        int halb   = (int) (laenge / 2);
        
        
        for (int x = halb; x < originalbild.getWidth() - halb; x++){
            for (int y = halb; y < originalbild.getHeight() - halb; y++) {
                double rot   = 0.0; 
                double gruen = 0.0; 
                double blau  = 0.0;
                for (int i = 0; i < laenge; i++) {
                    for (int j = 0; j < laenge; j++) {
                        int xx = x - halb; 
                        int yy = y - halb;
                        
                        rot   = rot + filter[i][j] * pixel[xx+i][yy+j].getRed();                         
                        gruen = gruen + filter[i][j] * pixel[xx+i][yy+j].getGreen();                         
                        blau  = blau + filter[i][j] * pixel[xx+i][yy+j].getBlue();
                    }
                }
                if(rot < 0.0)     {rot   = 0.0;}    
                if(rot > 255.0)   {rot   = 255.0;} 
                if(gruen < 0.0)   {gruen = 0.0;}  
                if(gruen > 255.0) {gruen = 255.0;} 
                if(blau < 0.0)    {blau  = 0.0;}   
                if(blau > 255.0)  {blau  = 255.0;}
                pixelNeu[x][y] = new Color((int) rot, (int) gruen, (int) blau);
        
            }
        }
        
        Picture neuesBild = new Picture();        
        neuesBild.setPixelArray(pixelNeu); 
        return neuesBild;
    }
    
    public Picture weichzeichnen(Picture originalbild)
    {
        int a = 10;
        double [][] filter = new double [a][a];
        for (int x = 0; x < a; x++) {
            for (int y = 0; y < a; y++) {
                filter[x][y] = 1.0/(a*a);
            }
        }
        return faltung(originalbild, filter);
    }
    
    public Picture schaerfen(Picture originalbild)
    {
        double [][] filter = {{0,-1,0},{-1,5,-1},{0,-1,0}};

        return faltung(originalbild, filter);
    }
    
    public Picture relief(Picture originalbild)
    {
        double [][] filter = {{-2,-1,0},{-1,1,1},{0,1,2}};

        return faltung(originalbild, filter);
    }
}
