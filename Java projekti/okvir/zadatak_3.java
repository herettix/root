/*Napiši program koji će na ekranu crtati prozor kao na slici. Klikom na gumb Mijenjaj se
iznos duljine u centimetrima treba pretvoriti u iznos duljine u inchima (1 inch = 2.54 cm).*/
import javax.swing.*; 
import java.awt.*;
import java.awt.event.*; //importamo klase koje su nam potrebne za sučelje i evente
public class zadatak_3 extends JFrame implements ActionListener {
private final int si=340,vi=200;
private Container z;
private JTextField z1,z2;
private JButton mijenjaj;
private JLabel t1,t2; //definiramo klasu s parametrima za sučelje,evente te gumbe
public zadatak_3 ()
{
setTitle("zadatak_3");
setSize(si,vi);
setDefaultCloseOperation(EXIT_ON_CLOSE);
z=getContentPane();
z.setLayout(null); //definiramo metodu te glavne karakteristike prozora

//textfield s centimetrima
z1= new JTextField();
z1.setText("0");
z1.setSize (100, 30);
z1.setLocation (220, 30);
z1.setEnabled(true);
z.add (z1);

//textfield s inchima
z2= new JTextField();
z2.setText("0");
z2.setSize (100, 30);
z2.setLocation (220, 70);
z2.setEnabled(false);
z.add (z2);

//natpis centimetri
t1= new JLabel();
t1.setText("Centimetri");
t1.setSize (100, 30);
t1.setLocation (20, 30);
t1.setEnabled(true);
z.add (t1);

//natpis inchi
t2= new JLabel();
t2.setText("Inchi");
t2.setSize (100, 30);
t2.setLocation (20, 70);
t2.setEnabled(true);
z.add (t2);

//gumb za mijenjanje 
mijenjaj = new JButton ();
mijenjaj.setText("Mijenjaj");
mijenjaj.setSize (80, 30);
mijenjaj.setLocation (130, 110);
mijenjaj.setEnabled(true);
mijenjaj.addActionListener (this);
z.add (mijenjaj);

//container se moze vidjeti ili ne
setVisible(true); }

public void actionPerformed(ActionEvent e) {
int a = Integer.parseInt (z1.getText ());
double b=a*0.393;
z2.setText(""+b); }  //metoda koja prati događaje i kada se nešto dogodi reagira
public static void main (String[] s)
{ zadatak_3 z = new zadatak_3 ();}} //main metoda koja je potrebna kako bi se program mogao izvršiti bez BlueJ(cmd,JVM...)
//Vlasništvo ostacro[0M3G4], ako vam on nije osobno to poslao, čestitam pirat ste... 
//Pirate: "I don't get it???"
