import javax.swing.*; 
import java.awt.*;
import java.awt.event.*; 
public class skladistec extends JFrame implements ActionListener   {
private final int si=510,vi=280;
private Container prvi;
public static JTextField t1,t2,t3;
public JButton unesi,provjeri;
private JLabel l1,l2,l3,lp2; 
public static JTextArea taf1;
//Container cp = getContentPane();

static JFrame prvif = new JFrame(); 
//prozor podprograma skladište i njegovi gumbi
public void skladiste()
{
prvif.setTitle("Skladište");
prvif.setSize(si,vi);
prvif.setDefaultCloseOperation(prvif.HIDE_ON_CLOSE);
prvif.getContentPane();
prvif.setLayout(null); 
prvif.setResizable(false);

lp2= new JLabel();
lp2.setText("Dobrodošli! Program za skladište");
lp2.setSize (300, 30);
lp2.setLocation (140, 30);
lp2.setEnabled(true);
prvif.add (lp2);

l1= new JLabel();
l1.setText("Ime proizvoda");
l1.setSize (140, 30);
l1.setLocation (40, 70);
l1.setEnabled(true);
prvif.add (l1);

l2= new JLabel();
l2.setText("Količina proizvoda");
l2.setSize (140, 30);
l2.setLocation (200, 70);
l2.setEnabled(true);
prvif.add (l2);

l3= new JLabel();
l3.setText("Cijena proizvoda");
l3.setSize (140, 30);
l3.setLocation (360, 70);
l3.setEnabled(true);
prvif.add (l3);

t1= new JTextField();
t1.setText("");
t1.setSize (140, 30);
t1.setLocation (20, 110);
t1.setEnabled(true);
prvif.add (t1);

t2= new JTextField();
t2.setText("0");
t2.setSize (140, 30);
t2.setLocation (180, 110);
t2.setEnabled(true);
prvif.add (t2);

t3= new JTextField();
t3.setText("0");
t3.setSize (140, 30);
t3.setLocation (340, 110);
t3.setEnabled(true);
prvif.add (t3);

unesi = new JButton ();
unesi.setText("Unesi u bazu podataka");
unesi.setSize (180, 35);
unesi.setLocation (45, 160);
unesi.setEnabled(true);
unesi.addActionListener (this);
prvif.add (unesi);

provjeri = new JButton ();
provjeri.setText("Provjeri stanje u skladištu");
provjeri.setSize (220, 35);
provjeri.setLocation (240, 160);
provjeri.setEnabled(true);
provjeri.addActionListener (this);
prvif.add (provjeri);

prvif.setVisible(true);} 


public void actionPerformed(ActionEvent e) {
//unosi podatke u bazu podataka
sklstF noviobjs = new sklstF();
if (e.getSource () == unesi)
{ inicijaliziranje.skladistem1(); }
//pokazuje bazu podataka
if (e.getSource () == provjeri)
{ noviobjs.sklstFm(); }
} }