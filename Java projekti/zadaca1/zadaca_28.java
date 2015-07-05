/*Napiši metodu čiji će ulazni parametar biti troznamenkasti prirodan broj n. Metoda treba
vračati broj koji se dobije okretanjem broja n.*/
public class zadaca_28
{
public static int okretanje(int x)
{ int p,d,t;
 p=x/100;
 d=x/10%10;
 t=x%10;
 int o=t*100+d*10+p;
return o; }}