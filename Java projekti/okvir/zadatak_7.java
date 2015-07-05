/*Napiši program koji će na ekranu crtati prozor i dva gumba (Gumb 1 i Gumb 2). Na početku
će biti aktivan samo prvi gumb (Gumb 1), klikom na prvi gumb on postaje neaktivan a
aktivan postaje drugi gumb. Klikom na drugi gumb on postaje neaktivan a aktivan postaje
ponovo prvi gumb,...*/
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
public class zadatak_7 extends JFrame implements ActionListener
{
public boolean ab=true,cd=false;
private final int si = 450;
private final int vi = 350;
private Container z;
private JTextField z1;
private JButton but1, but2;
public zadatak_7 ()
{
setTitle ("Zadatak 7");
setSize(si, vi);
setDefaultCloseOperation (EXIT_ON_CLOSE);
z = getContentPane ();
z.setLayout (null);

but1 = new JButton ();
but1.setText("Button 1");
but1.setSize (100, 35);
but1.setLocation (150, 50);
but1.setEnabled(ab);
but1.addActionListener (this);
z.add (but1);

but2 = new JButton ();
but2.setText("Button 2");
but2.setSize (100, 35);
but2.setLocation (150, 120);
but2.setEnabled(cd);
but2.addActionListener (this);
z.add (but2);

setVisible(true); } 
public void actionPerformed(ActionEvent e) {
    if (ab==true) {                          //ako je izvrsena radnja na ab onda radi to i to inace to i to
        but2.setEnabled(true);
        but1.setEnabled(false); ab=false;
    } else {
        but2.setEnabled(false);
        but1.setEnabled(true); ab=true; } 
}
/*public void actionPerformed(ActionEvent e) {             //drugi nacin rjesavanja ovog zadatka
if (e.getSource () == but1){ but2.setEnabled(true); but1.setEnabled(false); }
else { but2.setEnabled(false); but1.setEnabled(true); } }*/
public static void main (String[] s)
{ zadatak_7 z = new zadatak_7 (); } }