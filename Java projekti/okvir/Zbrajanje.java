import javax.swing.*;
import java.awt.*;
public class Zbrajanje extends JFrame
{
private final int sirina = 380;
private final int visina = 240;
private Container c;
private JTextField t1;
private JButton a,b,d,e,f,g,h,i,j,k,a1,a2;
private JButton a3,a4,a5,a6,a7,a8,a9,a0,ap;
private JButton am,amn,azb,mc,mr,ms,mp,sqrt;
private JButton arac,ad,aplmin,azar,ajed,apl;
public Zbrajanje()
{
setTitle ("Kalkulator");
setSize (sirina, visina);
setDefaultCloseOperation (EXIT_ON_CLOSE);
c = getContentPane ();
c.setLayout (null);
//prvi okvir za tekst
t1 = new JTextField ();
t1.setSize (350, 25);
t1.setLocation (5, 5);
c.add (t1);
//gumb1
a = new JButton ();
a.setText ("Backspace");
a.setSize (100, 25);
a.setLocation (70, 35);
c.add (a);
//gumb2
b = new JButton ();
b.setText ("CE");
b.setSize (80, 25);
b.setLocation (180, 35);
c.add (b);
//gumb3
d = new JButton ();
d.setText ("C");
d.setSize (80, 25);
d.setLocation (270, 35);
c.add (d);
//gumb4
mc = new JButton ();
mc.setText ("MC");
mc.setSize (55, 25);
mc.setLocation (5, 70);
c.add (mc);
//gumb5
mr = new JButton ();
mr.setText ("MR");
mr.setSize (55, 25);
mr.setLocation (5, 100);
c.add (mr);
//gumb
ms = new JButton ();
ms.setText ("MS");
ms.setSize (55, 25);
ms.setLocation (5, 130);
c.add (ms);
//gumb6
mp = new JButton ();
mp.setText ("M+");
mp.setSize (55, 25);
mp.setLocation (5, 160);
c.add (mp);
//gumb7
a7 = new JButton ();
a7.setText ("7");
a7.setSize (45, 25);
a7.setLocation (80, 70);
c.add (a7);
//gumb8
a8 = new JButton ();
a8.setText ("8");
a8.setSize (45, 25);
a8.setLocation (130, 70);
c.add (a8);
//gumb9
a9 = new JButton ();
a9.setText ("9");
a9.setSize (45, 25);
a9.setLocation (180, 70);
c.add (a9);
//gumb9
ad = new JButton ();
ad.setText ("/");
ad.setSize (45, 25);
ad.setLocation (230, 70);
c.add (ad);
//gumb9
sqrt = new JButton ();
sqrt.setText ("sqrt");
sqrt.setSize (60, 25);
sqrt.setLocation (280, 70);
c.add (sqrt);

//2dio
a4 = new JButton ();
a4.setText ("4");
a4.setSize (45, 25);
a4.setLocation (80, 100);
c.add (a4);
//gumb8
a5 = new JButton ();
a5.setText ("5");
a5.setSize (45, 25);
a5.setLocation (130, 100);
c.add (a5);
//gumb9
a6 = new JButton ();
a6.setText ("6");
a6.setSize (45, 25);
a6.setLocation (180, 100);
c.add (a6);
//gumb9
amn = new JButton ();
amn.setText ("*");
amn.setSize (45, 25);
amn.setLocation (230, 100);
c.add (amn);
//gumb9
ap = new JButton ();
ap.setText ("%");
ap.setSize (60, 25);
ap.setLocation (280, 100);
c.add (ap);

//3dio
a1 = new JButton ();
a1.setText ("1");
a1.setSize (45, 25);
a1.setLocation (80, 130);
c.add (a1);
//gumb8
a2 = new JButton ();
a2.setText ("2");
a2.setSize (45, 25);
a2.setLocation (130, 130);
c.add (a2);
//gumb9
a3 = new JButton ();
a3.setText ("3");
a3.setSize (45, 25);
a3.setLocation (180, 130);
c.add (a3);
//gumb9
am = new JButton ();
am.setText ("-");
am.setSize (45, 25);
am.setLocation (230, 130);
c.add (am);
//gumb9
arac = new JButton ();
arac.setText ("1/x");
arac.setSize (60, 25);
arac.setLocation (280, 130);
c.add (arac);

//4dio
a0 = new JButton ();
a0.setText ("0");
a0.setSize (45, 25);
a0.setLocation (80, 160);
c.add (a0);
//gumb8
aplmin = new JButton ();
aplmin.setText ("+/-");
aplmin.setSize (45, 25);
aplmin.setLocation (130, 160);
c.add (aplmin);
//gumb9
azar = new JButton ();
azar.setText (",");
azar.setSize (45, 25);
azar.setLocation (180, 160);
c.add (azar);
//gumb9
apl = new JButton ();
apl.setText ("+");
apl.setSize (45, 25);
apl.setLocation (230, 160);
c.add (apl);
//gumb9
ajed = new JButton ();
ajed.setText ("=");
ajed.setSize (60, 25);
ajed.setLocation (280, 160);
c.add (ajed);

setVisible (true);
} }