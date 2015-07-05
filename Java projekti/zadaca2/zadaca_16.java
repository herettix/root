/*1.) Napiši metodu čiji će ulazni parametar biti prirodan broj n.
Metoda treba vraćati n-ti po redu simetričan broj.*/
public class zadaca_16 {
public static int simetricni(int n)
{ int i=11,p,d,t=0,c=0,br=1,nbroj=0,znbroj=0;
while(br<=n) //petlja koja broji koliko zasada imamo simetricnih brojeva ide do n-tog broja 
{ 
  if(i>=11 && i<=99) { d=i%10; p=i/10; }             //ifovi traze znamenke broja na kojem smo sada
  else if(i>=100 && i<=999) { t=i%10; d=i/10%10; p=i/100; } //napomena sa poljima bi sve bilo puno lakse
  else { c=i%10; t=i/10%10; d=i/100%10; p=i/1000; }

  if(i>=11 && i<=99) { nbroj=d*10+p; }  //ifovi koji sklapaju novi broj ovisno o tome koliko znamenaka ima
  else if(i>=100 && i<=999) { nbroj=t*100+d*10+p; }
  else { nbroj=c*1000+t*100+d*10+p; }
if(nbroj==i)      //if koji gleda dali je broj simetrican,ako je povecaj brojac simetricnosti
{ br++; znbroj=i; } // i stavi da nam je zadnjinovi broj jednak tom broju
i++; }  //povecavamo broj na kojem smo sada
return znbroj; }} //vracamo zadnji novi broj,tj. vracamo n-ti po redu simetrican broj