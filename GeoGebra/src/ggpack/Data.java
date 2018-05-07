
package ggpack;

import static java.lang.Math.cos;
import static java.lang.Math.pow;
import static java.lang.Math.sin;

/**
 * Klasa <code>Data</code> przechowuje dane podawane przez użytkownika potrzebne
 * do wygenerowania wykresu oraz wykonuje na nich obliczenia.
 * 
 * @author Jacek Sobiecki
 * @author Piotr Szubert
 */
public class Data {
    protected static double a;
    protected static double b;
    protected static double c;
    protected static int i;
    protected static int k;
    protected static int m;
    protected static double kat;
    protected static double max;
    protected static double min;
    
    /**
     * Oblicza funkcję geogebry.
     * @return opis matematyczny funkcji
     */
    protected static double calculate(){
 double r = c +( a * cos(i*kat)) + (b * pow(sin(k*kat),m));
 return r;
    }
    
    

}
