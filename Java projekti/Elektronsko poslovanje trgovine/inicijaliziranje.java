import javax.swing.*; 
import java.io.*;
import java.util.ArrayList; 
import java.lang.Object.*;
//inicijaliziranje vrijednosti pomocu konstruktora
public class inicijaliziranje {
static int br1=0,br2=0,br3=0,brp=0;
static int[] a = new int[250];
static int[] b = new int[250];
static double[] c = new double[250];
static double pdv=0.25,marza=0.06,ukupnoz=0,pdvz=0,skladistez=0,marzaz=0; 
//static String[] arri;

//metoda za skladiste
public static void skladistem1() {
try{ 
/*arri = new String[50];
arri[brp]= skladistec.t1.getText () ;*/
//stavi kod na proizvod
a[brp] = brp;
//uzmi količinu proizvoda i stavi ih na vrijednost pripadajućeg polja
b[brp] = Integer.parseInt (skladistec.t2.getText ()); 
//uzmi dobavnu cijenu proizvoda i stavi ga na vrijednost pripadajućeg polja
c[brp] = Double.parseDouble (skladistec.t3.getText()) + Double.parseDouble (skladistec.t3.getText ()) * marza;
c[brp] = c[brp] + (c[brp] * pdv);
//cijena koju plaćamo dobavljaču
skladistez = skladistez + c[brp]*Integer.parseInt(skladistec.t2.getText());
brp++; } 
catch(StringIndexOutOfBoundsException error1) { 
skladistec.t2.setText("Baza podataka puna"); skladistec.t3.setText("Baza podataka puna"); }
catch(NumberFormatException error2) {
skladistec.t2.setText("Nedozvoljeni format broja"); skladistec.t3.setText("Nedozvoljeni format broja"); } }

//metode za blagajnu
public static void blagajnam1() {
//gumb pribroji, uzmi kod proizvoda te oduzmi kolicinu proizvoda u skladistu i dodaj u racun
try{
if(b[Integer.parseInt (blagajnac.t4.getText ())] - Integer.parseInt (blagajnac.t5.getText ())>0){
b[Integer.parseInt (blagajnac.t4.getText ())] = b[Integer.parseInt (blagajnac.t4.getText ())] - Integer.parseInt (blagajnac.t5.getText ());
blagajnac.racun=blagajnac.racun + c[Integer.parseInt (blagajnac.t4.getText ())]*Integer.parseInt (blagajnac.t5.getText ()); 
blagajnac.l6.setText("Ukupan račun do sada je:"+ Math.round(blagajnac.racun*100.0)/100.0+ "kn"); }
else {  blagajnac.t4.setText("Proizvod unešenog koda nije dostupan");} } 
catch(StringIndexOutOfBoundsException error3) { 
 blagajnac.t4.setText("Ne postoji u bazi podataka");  blagajnac.t5.setText("Ne postoji u bazi podataka"); }
catch(NumberFormatException error4) {
 blagajnac.t4.setText("Nedozvoljeni format broja");  blagajnac.t5.setText("Nedozvoljeni format broja"); }}
 
//nracun, dodaj u sveukupnu zaradu te vrati racun na 0
public static void blagajnam2() { ukupnoz = ukupnoz + blagajnac.racun; blagajnac.racun=0;
 blagajnac.l6.setText("Ukupan račun do sada je:"+ Math.round(blagajnac.racun*100.0)/100.0+ "kn"); }

//metode za racunovodstvo
public static void racunovodstvom1() {  
//napisi na labele podatke
pdvz= ukupnoz*pdv;
marzaz= ukupnoz*marza;
racunovodac.l7.setText("Ukupno smo zaradili: " + Math.round(ukupnoz*100.0)/100.0+"kn"); 
racunovodac.l8.setText("Prihod države je: " + Math.round(pdvz *100.0)/100.0+"kn");
racunovodac.l9.setText("Dobavljaču moramo platiti: " +Math.round(skladistez *100.0)/100.0+"kn");
racunovodac.l10.setText("Čistog profita imamo: " + Math.round(marzaz *100.0)/100.0+"kn"); }
public static void racunovodstvom2() { 
//resetiraj postavke
elpos.resetm();  } }