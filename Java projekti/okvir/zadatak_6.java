/*Napiši program koji će crtati ekran i na njemu jedan gumb. Kada se program učita na gumbu
treba pisati tekst Broj: 0. Svakim klikom na gumb tekst na gumbu se treba izmijeniti i to tako
da se izmijeni broj pokraj teksta Broj (nakon prvog klika na gumbu treba pisati Broj: 1, nakon
drugog Broj: 2,...)*/
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
public class zadatak_6 extends JFrame implements ActionListener {
public int x=0;
private final int si=160;
private final int vi=100;
private Container z;
private JButton gumb;
public zadatak_6 () {
setTitle ("zadatak 6");
setSize(si,vi);
setDefaultCloseOperation(EXIT_ON_CLOSE);
z=getContentPane();
z.setLayout(null);

gumb = new JButton ();
gumb.setText("Broj:" +x);
gumb.setSize(100,30);
gumb.setLocation(20,20);
gumb.setEnabled(true);
gumb.addActionListener (this);
z.add(gumb);

setVisible(true); }
public void actionPerformed(ActionEvent e) 
{x++; gumb.setText("Broj:" +x); }  //ako je izvrsen događaj, povecaj brojac x te promjeni natpis na gumbu
public static void main (String[] s)
{ zadatak_6 z = new zadatak_6 (); }}
//Vlasništvo ostacro[0M3G4], ako vam on nije osobno to poslao, čestitam pirat ste... 
//Pirate: "I don't get it???"