import javax.swing.*; 
import java.awt.*;
import java.awt.event.*; 
public class elpos extends JFrame implements ActionListener {
private final int si=560,vi=260;
private Container glavni;
private JButton but1,but2,but3;
private JLabel lpg; 
//konstruktor za inicijaliziranje varijabli

//glavni prozor i njegovi gumbi
public elpos()
{
setTitle("Elektronsko Poslovanje Trgovine");
setSize(si,vi);
setDefaultCloseOperation(EXIT_ON_CLOSE);
glavni=getContentPane();
glavni.setLayout(null); 

lpg= new JLabel();
lpg.setText("Dobrodošli u ELPOS, sustav elektronskog poslovanja trgovine, odaberite podprogram");
lpg.setSize (500, 30);
lpg.setLocation (30, 30);
lpg.setEnabled(true);
glavni.add (lpg);

but1 = new JButton ();
but1.setText("Skladište");
but1.setSize (140, 35);
but1.setLocation (40, 100);
but1.setEnabled(true);
but1.addActionListener (this);
glavni.add (but1);

but2 = new JButton ();
but2.setText("Blagajna");
but2.setSize (140, 35);
but2.setLocation (200, 100);
but2.setEnabled(true);
but2.addActionListener (this);
glavni.add (but2);

but3 = new JButton ();
but3.setText("Računovođa");
but3.setSize (140, 35);
but3.setLocation (360, 100);
but3.setEnabled(true);
but3.addActionListener (this);
glavni.add (but3);

setVisible(true);}
public void actionPerformed(ActionEvent e) {
//stvaranje instanci klasa 
skladistec noviobj1 = new skladistec();
/*blagajnac noviobj2 = new blagajnac(); 
racunovodac noviobj3 = new racunovodac();*/
//otvaranje instance prozora
if (e.getSource () == but1)
{ noviobj1.skladiste(); }
/*if (e.getSource () == but2)
noviobj2.blagajna();
if (e.getSource () == but3)
noviobj3.racunovoda();*/ } 
//stvaranje instance glavnog programa
public static void main (String[] s)
{ elpos glavn = new elpos ();} }