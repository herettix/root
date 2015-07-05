/*Napiši metodu čiji će parametri biti sati, minute i sekunde početka te kraja filma. Metoda
treba vraćati trajanje filma (u satima, minutama i sekundama).
Napomena: film će započeti i završiti u istom danu*/
public class zadaca_30
{
public static String vrijeme(int a,int b,int c,int x,int y,int z)
{
int sati,minute,sekunde,pom;
pom=(x-a)*3600 + (y-b)*60 + (z-c);
sati=pom/3600;
pom%=3600;
minute=pom/60;
pom%=60;

return sati+":"+minute+":"+pom; }} 
