/*Napiši metodu čiji će ulazni parametri biti tri prirodna broja (a, b i c). Ukoliko stranice
zadovoljavaju nejednakost trokuta, metoda treba ispisati je li trokut jednakostraničan,
jednakokračan ili raznostraničan.*/
public class zadaca_8 {
public static String vrsta_trokuta(float x,float y,float z)
{  float m=x; String tro;
if(y>=m)
m=y;
else if(z>=m)
m=z;

if(x+y>m || x+z>m || y+z>m)
{ if(x==y || x==z || y==z)
tro="Trokut je jednakokračan";
else if(x==y && x==z)
tro="Trokut je jednakostraničan";
else tro="Trokut je raznostraničan"; }
else tro="Uneseni brojevi nemogu biti duljine stranica trokuta"; 
return tro;} }

