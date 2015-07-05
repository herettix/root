import javax.swing.*; 
import java.awt.*;
import java.awt.event.*; 
public class blagajnac implements ActionListener {
private final int si=510,vi=340;
private Container drugi;
public static JTextField t4,t5;
private JButton pribroji,nrac;
public static JLabel l4,l5,l6,lp3; 
JFrame drugif = new JFrame ();
public static double racun=0;

//podprozor blagajna i gumbi
public void blagajna() {
drugif.setTitle("Blagajna");
drugif.setSize(si,vi);
drugif.setDefaultCloseOperation(drugif.HIDE_ON_CLOSE);
drugif.getContentPane();
drugif.setLayout(null); 
drugif.setResizable(false);

lp3= new JLabel();
lp3.setText("Dobrodošli! Program za blagajnu");
lp3.setSize (300, 30);
lp3.setLocation (140, 30);
lp3.setEnabled(true);
drugif.add (lp3);

l4= new JLabel();
l4.setText("Unesi šifru proizvoda");
l4.setSize (120, 30);
l4.setLocation (30, 70);
l4.setEnabled(true);
drugif.add (l4);

l5= new JLabel();
l5.setText("Količina proizvoda");
l5.setSize (120, 30);
l5.setLocation (160, 70);
l5.setEnabled(true);
drugif.add (l5);

l6= new JLabel();
l6.setText("Ukupan račun do sada je:"+ racun+ "kn");
l6.setSize (200, 30);
l6.setLocation (160, 160);
l6.setEnabled(true);
drugif.add (l6);

t4= new JTextField();
t4.setText("");
t4.setSize (120, 30);
t4.setLocation (30, 110);
t4.setEnabled(true);
drugif.add (t4);

t5= new JTextField();
t5.setText("0");
t5.setSize (120, 30);
t5.setLocation (160, 110);
t5.setEnabled(true);
drugif.add (t5);

pribroji = new JButton ();
pribroji.setText("Pribroji postojećem računu");
pribroji.setSize (220, 35);
pribroji.setLocation (40, 200);
pribroji.setEnabled(true);
pribroji.addActionListener (this);
drugif.add (pribroji);

nrac = new JButton ();
nrac.setText("Novi račun");
nrac.setSize (180, 35);
nrac.setLocation (280, 200);
nrac.setEnabled(true);
nrac.addActionListener (this);
drugif.add (nrac);

drugif.setVisible(true);}
public void actionPerformed(ActionEvent e) {
//gumb pribroji, uzmi kod proizvoda te oduzmi kolicinu proizvoda u skladistu i dodaj u racun
if (e.getSource () == pribroji)
{ inicijaliziranje.blagajnam1();}
//gumb  nracun, dodaj u sveukupnu zaradu te vrati racun na 0
if (e.getSource () == nrac)
{ inicijaliziranje.blagajnam2();} 
} } 