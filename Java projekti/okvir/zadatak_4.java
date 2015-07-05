/*Napiši program koji će crtati prozor kao na slici. Klikom na gumb Kodiraj se tekst iz gornjeg
okvira za tekst treba kodirati i tako kodiran prepisati u donji okvir za tekst. Tekst ćemo
kodirati tako da svaki znak zamijenimo znakom čiji je ASCII kôd za jedan veći od ASCII
kôda odgovarajućeg znaka. Klikom na gumb Dekodiraj se tekst iz donjeg okvira za tekst treba
dekodirati i tako dekodiran prepisati u gornji okvir za tekst.*/
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
public class zadatak_4 extends JFrame implements ActionListener {
private final int si=360;
private final int vi=220;
private Container z;
private JButton kod,dekod;
private JTextField obicni,kodirani;
public zadatak_4 () {
setTitle ("zadatak 4");
setSize(si,vi);
setDefaultCloseOperation(EXIT_ON_CLOSE);
z=getContentPane();
z.setLayout(null);

kod = new JButton ();
kod.setText("Kodiraj");
kod.setSize (140, 30);
kod.setLocation (20, 70);
kod.setEnabled(true);
kod.addActionListener (this);
z.add (kod);

dekod = new JButton ();
dekod.setText("Dekodiraj");
dekod.setSize (140, 30);
dekod.setLocation (180, 70);
dekod.setEnabled(true);
dekod.addActionListener (this);
z.add (dekod);

obicni= new JTextField();
obicni.setText("Obični tekst");
obicni.setSize (300, 30);
obicni.setLocation (20, 20);
obicni.setEnabled(true);
z.add (obicni);

kodirani= new JTextField();
kodirani.setText("");
kodirani.setSize (300, 30);
kodirani.setLocation (20, 120);
kodirani.setEnabled(true);
z.add (kodirani);

setVisible(true); } 
public void actionPerformed(ActionEvent e) {
if (e.getSource () == kod) //ako je radnja izvršena nad objektom(gumbom) kod onda izvrši ovo
{ String s1,s2="";
int t1;
s1=obicni.getText(); //uzmi text iz textfielda obicni
for(int i=0;i<s1.length();i++)
{char t=s1.charAt(i);
t1=(int)t+1;
s2=s2+(char)t1; } //prebaci ga u ascii+1 te natrag u string
kodirani.setText(s2); } //stavi text iz s2 Stringa u textfield kodirani

if (e.getSource () == dekod) //ako je radnja izvršena nad objektom(gumbom) dekod onda izvrši ovo
{ String s3,s4="";
int t2;
s3=kodirani.getText();
for(int i=0;i<s3.length();i++)
{char te=s3.charAt(i);
t2=(int)te+1;
s4=s4+(char)t2; }
obicni.setText(s4); } }
public static void main (String[] s)
{ zadatak_4 z = new zadatak_4 (); } }
//Vlasništvo ostacro[0M3G4], ako vam on nije osobno to poslao, čestitam pirat ste... 
//Pirate: "I don't get it???"