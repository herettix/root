/*Napiši metodu čiji će ulazni parametri biti realni i imaginarni dio dvaju kompleksnih
brojeva. Metoda treba vračati a-zbroj kompleksnih brojeva; b-umnožak kompleksnih brojeva
c-zbroj apsolutnih vrijednosti kompleksnih brojeva*/

public class zadaca_29
{
static int r,i;
public static String imaginarni_A(int x,int y,int z,int w)
{  r=x+z;
   i=y+w;
return r + "+" + i + 'i';  }

public static String imaginarni_B(int x,int y,int z,int w)
{  r=x*z - y*w;
   i=x*w + y*z;
return r + "+" + i + 'i'; }

public static double imaginarni_C(int x,int y,int z,int w)
{ 
  r=x+z;
  i=y+w;
  double raz=Math.sqrt(Math.pow((double)r,2)+Math.pow((double)i,2));
return raz;}
}
