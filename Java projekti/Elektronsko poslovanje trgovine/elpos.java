import javax.swing.*; 
import java.awt.*;
import java.awt.event.*; 
public class elpos implements ActionListener {
private final int si=560,vi=260;
private Container glavni;
private JButton but1,but2,but3;
private JLabel lpg; 
private int puta1=0,puta2=0,puta3=0;
JFrame elposf = new JFrame ();
//konstruktor za inicijaliziranje varijabli

//glavni prozor i njegovi gumbi
public elpos()
{
elposf.setTitle("Elektronsko Poslovanje Trgovine");
elposf.setSize(si,vi);
elposf.setDefaultCloseOperation(elposf.EXIT_ON_CLOSE);
elposf.getContentPane();
elposf.setLayout(null); 
elposf.setResizable(false);

lpg= new JLabel();
lpg.setText("Dobrodošli u ELPOS, sustav elektronskog poslovanja trgovine, odaberite podprogram");
lpg.setSize (500, 30);
lpg.setLocation (30, 30);
lpg.setEnabled(true);
elposf.add (lpg);

but1 = new JButton ();
but1.setText("Skladište");
but1.setSize (140, 35);
but1.setLocation (40, 100);
but1.setEnabled(true);
but1.addActionListener (this);
elposf.add (but1);

but2 = new JButton ();
but2.setText("Blagajna");
but2.setSize (140, 35);
but2.setLocation (200, 100);
but2.setEnabled(true);
but2.addActionListener (this);
elposf.add (but2);

but3 = new JButton ();
but3.setText("Računovođa");
but3.setSize (140, 35);
but3.setLocation (360, 100);
but3.setEnabled(true);
but3.addActionListener (this);
elposf.add (but3);

elposf.setVisible(true);}

//reset programa
public static void resetm() {  
inicijaliziranje.a = new int[250];
inicijaliziranje.b = new int[250];
inicijaliziranje.c = new double[250];
inicijaliziranje.brp=0;
inicijaliziranje.ukupnoz=0;
inicijaliziranje.pdvz=0;
inicijaliziranje.skladistez=0;
inicijaliziranje.marzaz=0; 
}

public void actionPerformed(ActionEvent e) {
skladistec noviobj1 = new skladistec();
blagajnac noviobj2 = new blagajnac(); 
racunovodac noviobj3 = new racunovodac();
//otvaranje instance prozora
if (e.getSource () == but1)
{ if(puta1==0) { noviobj1.skladiste(); puta1=1; } else noviobj1.prvif.setVisible(true);}
if (e.getSource () == but2)
{ if(puta2==0) { noviobj2.blagajna(); puta2=1; }else noviobj2.drugif.setVisible(true);}
if (e.getSource () == but3)
{ if(puta3==0) { noviobj3.racunovoda(); puta3=1; }else noviobj3.trecif.setVisible(true);} } 
//stvaranje instance glavnog programa
public static void main (String[] s)
{ elpos glavn = new elpos ();} }