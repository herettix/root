/*Napiši program koji će crtati prozor kao na slici. Klikom na gumb OK gumb se treba
pomaknuti u slučajnom smjeru za 10 pixela.
Napomena: pri pomicanju gumba treba voditi računa da niti jedan dio gumba ne izadje izvan
okvira prozora.*/
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;
public class zadatak_5 extends JFrame implements ActionListener {
public int x=125,y=125,a=0;
private final int si=300,vi=300;
private Container z;
private JButton ok;
public zadatak_5 ()
{
setTitle("zadatak_5");
setSize(si,vi);
setDefaultCloseOperation(EXIT_ON_CLOSE);
z=getContentPane();
z.setLayout(null);

ok = new JButton ();
ok.setText("OK");
ok.setSize (80, 30);
ok.setLocation (x,y);
ok.setEnabled(true);
ok.addActionListener (this);
z.add (ok);

setVisible(true); } 
public void actionPerformed(ActionEvent e) {
Random ran = new Random(); //stvori novi objekt ran iz klase Random
a = ran.nextInt(4); //postavi neku random vrijednost intigeru a
//Vlasništvo ostacro[0M3G4], ako vam on nije osobno to poslao, čestitam pirat ste... 
//Pirate: "I don't get it???"
switch(a) {
case 0: if(x+10<=300) ok.setLocation (x+10,y); else ok.setLocation (x-10,y); break;
case 1: if(x-10>=0)ok.setLocation (x-10,y); else ok.setLocation (x+10,y); break;
case 2: if(y+10<=300) ok.setLocation (x,y+10); else ok.setLocation (x,y-10); break;
case 3: if(y-10>=0) ok.setLocation (x,y-10); else ok.setLocation (x,y+10); break; } } //zavisi o slucaju pomakni ok gumb
public static void main (String[] s)
{ zadatak_5 z = new zadatak_5 (); } }