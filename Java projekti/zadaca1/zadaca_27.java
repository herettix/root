/*Napiši metodu čiji će ulazni parametar biti dvoznamenkasti prirodan broj n. Metoda treba
vračati apsolutnu vrijednost razlike znamenaka broja n*/
public class zadaca_27
{ public static int vrijednost_abs (int x)
 { int p,d,r;
     d=x%10;
     p=x/10;
     r=Math.abs(p-d);
     return r; }}