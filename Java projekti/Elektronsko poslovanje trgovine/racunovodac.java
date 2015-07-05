import javax.swing.*; 
import java.awt.*;
import java.awt.event.*; 
import java.io.*;
import java.util.ArrayList; 
public class racunovodac implements ActionListener  {
private final int si=510,vi=320;
private Container treci;
private JButton reset,refres;
public static JLabel l7,l8,l9,l10,lp4; 
//inicijaliziranje noviobj3 = new inicijaliziranje();
JFrame trecif = new JFrame ();
//podprozor računovođa i gumbi
public void racunovoda()
{
trecif.setTitle("Računovođa");
trecif.setSize(si,vi);
trecif.setDefaultCloseOperation(trecif.HIDE_ON_CLOSE);
trecif.getContentPane();
trecif.setLayout(null); 
trecif.setResizable(false);


lp4= new JLabel();
lp4.setText("Dobrodošli! Program za računovodstvo");
lp4.setSize (300, 30);
lp4.setLocation (100, 30);
lp4.setEnabled(true);
trecif.add (lp4);

l7= new JLabel();
l7.setText("Ukupno smo zaradili: " + inicijaliziranje.ukupnoz+"kn");
l7.setSize (180, 30);
l7.setLocation (30, 70);
l7.setEnabled(true);
trecif.add (l7);

l8= new JLabel();
l8.setText("Prihod države je: " + inicijaliziranje.pdvz+"kn");
l8.setSize (220, 30);
l8.setLocation (30, 110);
l8.setEnabled(true);
trecif.add (l8);

l9= new JLabel();
l9.setText("Dobavljaču moramo platiti: " +inicijaliziranje.skladistez+"kn");
l9.setSize (240, 30);
l9.setLocation (30, 150);
l9.setEnabled(true);
trecif.add (l9);

l10= new JLabel();
l10.setText("Čistog profita imamo: " + inicijaliziranje.marzaz+"kn");
l10.setSize (220, 30);
l10.setLocation (30, 180);
l10.setEnabled(true);
trecif.add (l10);

refres = new JButton ();
refres.setText("Osvježi podatke");
refres.setSize (180, 35);
refres.setLocation (280, 125);
refres.setEnabled(true);
refres.addActionListener (this);
trecif.add (refres);

reset = new JButton ();
reset.setText("Resetiraj sve");
reset.setSize (180, 35);
reset.setLocation (280, 180);
reset.setEnabled(true);
reset.addActionListener (this);
trecif.add (reset);

trecif.setVisible(true);}
public void actionPerformed(ActionEvent e) {
//refres, osvježi podatke na labelima
if (e.getSource () == refres)
{ inicijaliziranje.racunovodstvom1(); }
//resetaj sve vrijednosti objekta na poc. vrijednost
if (e.getSource () == reset)
{ JOptionPane pane = new JOptionPane();
int n = JOptionPane.showConfirmDialog(null,"Dali ste sigurni da želite resetirati postavke??", "Pozor!!!", JOptionPane.YES_NO_OPTION);
if(n==JOptionPane.YES_OPTION) {
inicijaliziranje.racunovodstvom2(); } else reset.setText("Reraj sve"); 
 } } }