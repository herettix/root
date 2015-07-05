import javax.swing.*; 
import java.awt.*;
import java.awt.event.*; 
public class skladistec extends JFrame implements ActionListener  {
private final int si=510,vi=280;
private Container prvi;
public JTextField t1,t2,t3;
public JButton unesi;
private JLabel l1,l2,l3,lp2; 
inicijaliziranje noviobj1 = new inicijaliziranje();

//prozor podprograma skladište i njegovi gumbi
public void skladiste()
{
setTitle("Skladište");
setSize(si,vi);
setDefaultCloseOperation(EXIT_ON_CLOSE);
prvi=getContentPane();
prvi.setLayout(null); 

lp2= new JLabel();
lp2.setText("Dobrodošli! Program za skladište");
lp2.setSize (300, 30);
lp2.setLocation (140, 30);
lp2.setEnabled(true);
prvi.add (lp2);

l1= new JLabel();
l1.setText("Ime proizvoda");
l1.setSize (140, 30);
l1.setLocation (40, 70);
l1.setEnabled(true);
prvi.add (l1);

l2= new JLabel();
l2.setText("Količina proizvoda");
l2.setSize (140, 30);
l2.setLocation (200, 70);
l2.setEnabled(true);
prvi.add (l2);

l3= new JLabel();
l3.setText("Cijena proizvoda");
l3.setSize (140, 30);
l3.setLocation (360, 70);
l3.setEnabled(true);
prvi.add (l3);

t1= new JTextField();
t1.setText("");
t1.setSize (140, 30);
t1.setLocation (20, 110);
t1.setEnabled(true);
prvi.add (t1);

t2= new JTextField();
t2.setText("0");
t2.setSize (140, 30);
t2.setLocation (180, 110);
t2.setEnabled(true);
prvi.add (t2);

t3= new JTextField();
t3.setText("0");
t3.setSize (140, 30);
t3.setLocation (340, 110);
t3.setEnabled(true);
prvi.add (t3);

unesi = new JButton ();
unesi.setText("Unesi u bazu podataka");
unesi.setSize (180, 35);
unesi.setLocation (155, 160);
unesi.setEnabled(true);
unesi.addActionListener (this);
prvi.add (unesi);

setVisible(true);} 
public void actionPerformed(ActionEvent e) {
if (e.getSource () == unesi) { 
//stavi kod na proizvod
noviobj1.a[noviobj1.brp] = noviobj1.brp;
//uzmi količinu proizvoda i stavi ih na vrijednost pripadajućeg polja
noviobj1.b[noviobj1.brp] = Integer.parseInt (t2.getText ());
//uzmi dobavnu cijenu proizvoda i stavi ga na vrijednost pripadajućeg polja
noviobj1.c[noviobj1.brp] = Double.parseDouble (t3.getText()) +
Double.parseDouble (t3.getText ()) * noviobj1.marza;
noviobj1.c[noviobj1.brp] = noviobj1.c[noviobj1.brp] + noviobj1.c[noviobj1.brp] * noviobj1.pdv;
//cijena koju plaćamo dobavljaču
noviobj1.skladistez = noviobj1.skladistez + noviobj1.c[noviobj1.brp]*Integer.parseInt(t2.getText());
noviobj1.brp++; 
unesi.setText("Unesi u bazu podataka"+noviobj1.skladistez);} 
} }