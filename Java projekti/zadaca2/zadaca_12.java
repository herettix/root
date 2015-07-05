/*12. Napiši metodu čiji će ulazni parametar biti prirodan broj n. 
Metoda treba vračati i n , pri čemu je i imaginarna*/
public class zadaca_12 {
public static String imag(int x)
{ x%=4;
switch(x)
{ 
case 1: return "i";
case 2: return "-1"; 
case 3: return "-i";
default: return "1";
  }}}