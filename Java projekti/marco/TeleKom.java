import javax.swing.*; 
import java.awt.*;
import java.awt.event.*; 
public class TeleKom implements ActionListener {
private final int si=620,vi=280;
private Container glavni;
private JButton but1,but2,but3;
private JLabel lpg,lpg2,lpg3,lpg4,lpg5,lpg6; 
public static JTextField t1,t2,t3,t4;
public static double smsr=0.50,pozivi=0.01,smsi=0.38,pozivir=0.03,cje1,cje2;
private static JComboBox cb1,cb2;
String[] brojevi = {
        "izaberi",
         "091/092",
         "095",
         "097",
         "098/099"};

//public JOptionPane jpl1,jpl2;
JFrame telef = new JFrame ();

//konstruktor za inicijaliziranje varijabli
//glavni prozor i njegovi gumbi
public TeleKom()
{
telef.setTitle("Telekomunikacijski program");
telef.setSize(si,vi);
telef.setDefaultCloseOperation(telef.EXIT_ON_CLOSE);
telef.getContentPane();
telef.setLayout(null); 
telef.setResizable(false);

lpg= new JLabel();
lpg.setText("S Broja:");
lpg.setSize (50, 30);
lpg.setLocation (20, 30);
lpg.setEnabled(true);
telef.add (lpg);

lpg2= new JLabel();
lpg2.setText("Na Broj:");
lpg2.setSize (50, 30);
lpg2.setLocation (370, 30);
lpg2.setEnabled(true);
telef.add (lpg2);

lpg3= new JLabel();
lpg3.setText("SMS:");
lpg3.setSize (50, 30);
lpg3.setLocation (30, 80);
lpg3.setEnabled(true);
telef.add (lpg3);

lpg4= new JLabel();
lpg4.setText("Cijena:");
lpg4.setSize (50, 30);
lpg4.setLocation (380, 80);
lpg4.setEnabled(true);
telef.add (lpg4);

lpg5= new JLabel();
lpg5.setText("Pozivi:");
lpg5.setSize (50, 30);
lpg5.setLocation (30, 160);
lpg5.setEnabled(true);
telef.add (lpg5);

lpg6= new JLabel();
lpg6.setText("Cijena:");
lpg6.setSize (50, 30);
lpg6.setLocation (380, 160);
lpg6.setEnabled(true);
telef.add (lpg6);

t1= new JTextField();
t1.setText(cje1+" HRK");
t1.setSize (80, 30);
t1.setLocation (450, 80);
t1.setEnabled(true);
telef.add (t1);

t2= new JTextField();
t2.setText(cje2+" HRK");
t2.setSize (80, 30);
t2.setLocation (450, 160);
t2.setEnabled(true);
telef.add (t2);

t3= new JTextField();
t3.setText("unesi");
t3.setSize (80, 30);
t3.setLocation (100, 80);
t3.setEnabled(true);
telef.add (t3);

t4= new JTextField();
t4.setText("unesi");
t4.setSize (80, 30);
t4.setLocation (100, 160);
t4.setEnabled(true);
telef.add (t4);

but1 = new JButton ();
but1.setText("Preračunaj");
but1.setSize (120, 35);
but1.setLocation (220, 80);
but1.setEnabled(true);
but1.addActionListener (this);
telef.add (but1);

cb1 = new JComboBox (brojevi);
cb1.setLocation (80, 30);
cb1.setSize(100,30);
cb1.setSelectedIndex(0);
cb1.addActionListener(this);
telef.add (cb1);

cb2 = new JComboBox (brojevi);
cb2.setLocation (430, 30);
cb2.setSize(100,30);
cb2.setSelectedIndex(0);
cb2.addActionListener(this);
telef.add (cb2);

but2 = new JButton ();
but2.setText("Preračunaj");
but2.setSize (120, 35);
but2.setLocation (220, 160);
but2.setEnabled(true);
but2.addActionListener (this);
telef.add (but2);
telef.setVisible(true); }

public static void sms() {
try{
{ if(cb1.getSelectedItem()==cb2.getSelectedItem()){ cje1=smsi*Integer.parseInt (t3.getText ()); }
else cje1=smsr*Integer.parseInt (t3.getText ());
t1.setText(cje1+" HRK");  }}
catch(ArithmeticException error1) { t1.setText("Nedozvoljeni format broja"); }
catch(NumberFormatException error2) { t1.setText("Nedozvoljeni format broja"); } }

public static void poziv() {
try{
// može i {if(cb1.getSelectedIndex()==cb2.getSelectedIndex())
{if(cb1.getSelectedItem()==cb2.getSelectedItem()){ cje2=pozivi*Integer.parseInt (t4.getText ()); }
else { cje2=pozivir*Integer.parseInt (t4.getText ());
t2.setText(cje2+" HRK"); }  } }
catch(ArithmeticException error1) { t2.setText("Nedozvoljeni format broja"); }
catch(NumberFormatException error2) { t2.setText("Nedozvoljeni format broja"); } }
public void actionPerformed(ActionEvent e) {
if(e.getSource () == but1)
{ sms(); }
if(e.getSource () == but2)
{ poziv(); } }
//stvaranje instance glavnog programa
public static void main (String[] s)
{ TeleKom glavn = new TeleKom();} }