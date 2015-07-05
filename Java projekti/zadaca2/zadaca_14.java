/*Napiši metodu koja će unositi datum u 21 stoljeću 
(dan, mjesec i godina) i ispisivati na koji
dan u tjednu dolazi taj datum. Napomena:
Poznato je da je 1. siječnja 2001. bio ponedjeljak.*/
public class zadaca_14 {
public static String dan(int x,int y,int z)
{ int g,m=0,p=0,u;
String rez="";
switch(y){
case 1: m=0; break;
case 2: m=28; break;
case 3: m=59; break;
case 4: m=89; break;
case 5: m=120; break;
case 6: m=150; break;
case 7: m=181; break;
case 8: m=212; break;
case 9: m=242; break;
case 10: m=273; break;
case 11: m=303; break;
case 12: m=334; break; }
if(z>=2004)
p=(z/4)%10;
g=(z-2001)*365;
x--;
u=(p+g+m+x)%7;
switch(u) {
case 0: rez="ponedjeljak"; break;
case 1: rez="utorak"; break;
case 2: rez="srijeda"; break;
case 3: rez="četvrtak"; break;
case 4: rez="petak"; break;
case 5: rez="subota"; break;
case 6: rez="nedjelja"; break; }
return rez; }}
