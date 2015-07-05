import javax.swing.*; 
import java.io.*;
import java.util.ArrayList; 
import java.lang.Object.*;
import java.util.Date;
import java.util.Vector;
import java.util.*;
import java.util.ArrayList; 
import java.util.*;
import java.text.*;
//inicijaliziranje vrijednosti pomocu konstruktora
public class inicijaliziranje {
    public static int[] tezina = new int[250];
    public static int[] visina = new int[250];
    public static int[] dob = new int[250];
    public static int[] kcal1 = new int[250];
    public static int brp=0;
    //static String[] arri;

    //metoda za skladiste
    public static void skladistem1() {
        try
        {
            kcal1[brp] = Integer.parseInt (CalorieCalculator.t7.getText());
            tezina[brp] = Integer.parseInt (CalorieCalculator.t2.getText());
            visina[brp] = Integer.parseInt (CalorieCalculator.t3.getText());
            dob[brp] = Integer.parseInt (CalorieCalculator.t4.getText());            
            brp++;
        }
        catch (Exception e)
        {
            //f
        }
    }
}