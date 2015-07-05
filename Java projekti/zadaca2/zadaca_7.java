/*Ulaz:3 prirodna broja,x,y,z. Ukoliko učitani brojevi zadovoljavaju nejednakost 
trokuta (zbroj bilo koja dva broja je veći od trećeg), metoda treba
vraćati opseg trokuta odnosno poruku "Uneseni bro...*/
public class zadaca_7 {
public static String trokut(float x,float y,float z)
{ float m=x;
if(y>=m)
m=y;
if(z>=m)
m=z;
float o=(x+y+z)/2;
if(m==z)
{ if(x+y>m)  return o+""; }
else if(m==x)
{ if(y+z>m)  return o+""; }
else if(m==y)
{ if(x+z>m)  return o+""; }  
return "Uneseni brojevi nemogu biti duljine stranica trokuta";  }}