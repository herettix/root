import javax.swing.*;
import java.awt.*;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import java.awt.event.*;
import java.util.*;


public class FrizerI_2012 extends JFrame implements ActionListener 
{
    private final int sirina = 1000;
    private final int visina = 400;
    private Container c;
    private JTextField t1;
    private JButton izr, n;
    private static JRadioButton m, z, kra, sre, dug, jad;
    private ButtonGroup b1, b2;
    private JTextArea tx1;
    private JTextField f1, f2, f3, p;
    private JLabel label1, label2, label3;
    public static int laz=0, cijena=0,dat1,vrje1,vrje2;
    
    
    public FrizerI_2012 ()
    {
        setTitle ("FrizerI 2012");
        setSize (sirina, visina);
        setDefaultCloseOperation (EXIT_ON_CLOSE);
        
        c = getContentPane ();
        c.setLayout (null);
        
   
   //pozdrav
   tx1 = new JTextArea ();
   tx1.setSize (950, 50);
   tx1.setLocation (5, 5);
   tx1.setEditable (false);
   tx1.setFont(new Font("Comic Sans MS", Font.BOLD, 17));
   tx1.setLineWrap(true);
   tx1.setWrapStyleWord(true);
   tx1.setBackground(Color.lightGray);
   tx1.setText ("Dobrodošli u FrizerI 2012! Pomoću ovog programa možete se u par klikova mišem naručiti u naš frizerski salon!");
   c.add (tx1);
        
   //prvo biranje
   label1 = new JLabel ();
   label1.setSize (200, 25);
   label1.setLocation (5, 60);
   label1.setText ("Spol:");
   label1.setFont(new Font("Helvetica", Font.BOLD, 20));
   c.add (label1);
   
   m = new JRadioButton ();
   m.setText ("Muški");
   m.setSize (80, 25);
   m.setLocation (10, 90);
   m.setSelected (true);
   m.addActionListener (this);
   c.add (m);

   z = new JRadioButton ();
   z.setText ("ženski");
   z.setSize (80, 25);
   z.setLocation (10, 120);
   z.addActionListener (this);
   c.add (z);
   setVisible (true);
   
   b1 = new ButtonGroup ();
   b1.add (m);
   b1.add (z);
   
   
   //drugo biranje
   label2 = new JLabel ();
   label2.setSize (200, 25);
   label2.setLocation (5, 170);
   label2.setText ("Dužina kose:");
   label2.setFont(new Font("Helvetica", Font.BOLD, 20));
   c.add (label2);
   
   kra = new JRadioButton ();
   kra.setText ("Kratka");
   kra.setSize (80, 25);
   kra.setLocation (10, 200);
   kra.addActionListener (this);
   kra.setSelected (true);
   c.add (kra);
   
   sre = new JRadioButton ();
   sre.setText ("Srednja");
   sre.setSize (80, 25);
   sre.setLocation (10, 230);
   sre.addActionListener (this);
   c.add (sre);
   setVisible (true);
   
   dug = new JRadioButton ();
   dug.setText ("Duga");
   dug.setSize (80, 25);
   dug.setLocation (10, 260);
   dug.addActionListener (this);
   c.add (dug);
   setVisible (true);
   
   jad = new JRadioButton ();
   jad.setText ("Jako duga");
   jad.setSize (120, 25);
   jad.setLocation (10, 290);
   jad.addActionListener (this);
   c.add (jad);
   setVisible (true);
   
   b2 = new ButtonGroup ();
   b2.add (kra);
   b2.add (sre);
   b2.add (dug);
   b2.add (jad);
   
   //label cijena
   label3 = new JLabel ();
   label3.setSize (200, 25);
   label3.setLocation (250, 60);
   label3.setText ("CIJENA");
   label3.setFont(new Font("Helvetica", Font.BOLD, 20));
   c.add (label3);
   
   //textfield cijena
   f1 = new JTextField ();
   f1.setSize (200, 50);
   f1.setLocation (250, 90);
   f1.setText ("30kn");
   c.add (f1);

   //textfield datum
   f2 = new JTextField ();
   f2.setSize (200, 50);
   f2.setLocation (250, 240);
   f2.setText ("Dan narudžbe je:");
   c.add (f2);
   
   //izracunaj gumb
   izr = new JButton ();
   izr.setSize (200, 25);
   izr.setLocation (250, 150); 
   izr.setText ("Izračunaj");
   izr.setEnabled(true);
   izr.addActionListener (this);
   c.add (izr);
   
   //naruci se gumb
   n = new JButton ();
   n.setSize (200, 25);
   n.setLocation (250, 200);
   n.setText ("Naručise!");
   n.setEnabled (true);
   n.addActionListener (this);
   c.add (n); }
   
   //ifovi
public static void ifovi() {
    if (m.isSelected() && kra.isSelected())
    cijena=29;
    
    if (m.isSelected () && sre.isSelected())
    cijena=39;
    
    if (m.isSelected () && dug.isSelected ())
    cijena=49;
    
    if (m.isSelected () && jad.isSelected ())
    cijena=69;
    
    if (z.isSelected() && kra.isSelected())
    cijena=19;
    
    if (z.isSelected () && sre.isSelected())
    cijena=29;
    
    if (z.isSelected () && dug.isSelected ())
    cijena=79;
    
    if (z.isSelected () && jad.isSelected ())
    cijena=129;  }
public static void naruci()
{dat1= 1 + (int)(Math.random() * (32 - 1)); 
vrje1=8+(int)(Math.random()*(16-8));
vrje2=(int)(Math.random()*60);}
       public void actionPerformed (ActionEvent e)
   { if (e.getSource () == izr) { ifovi(); f1.setText (cijena+" kn"); }
if (e.getSource () == n) { naruci(); f2.setText (dat1+".5.2012. "+vrje1+"."+vrje2); } }
}