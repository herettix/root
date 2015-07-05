/*2.) Napiši metodu čiji će ulazni parametar biti prirodan broj m, 
a vraćat će broj prostih brojeva koji su manji ili jednaki m*/
public class zadaca_15
{ public static int simetrija(int m)
{ int i,j,bp=0,bg=0; 
for(i=1;i<=m;i++) //prva petlja, provlaci se od 1 do tog broja do kojeg trazimo proste brojeve,m
{  for(j=1;j<=i;j++) //druga petlja, provlaci se od 1 do broja (i) na kojem je prva petlja, da nebi slucajno dijelili s vecim brojem nego sto je potrebno
{ if(i%j==0) bp++; } //ako je broj djeljiv s brojem kjim dijelimo povecaj pomocni brojac 
if(bp<=2) bg++; //nakon zavrsetka druge petlje provjeri jeli broj prost(ima 2 ili manje dijelitelja),povecaj glavni brojac
bp=0; } //vrati pomocni brojac na nulu
return bg; }} //posalji glavni brojac kao rezultat