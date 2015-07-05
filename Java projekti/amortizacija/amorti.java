import javax.swing.*; 
import java.awt.*;
import java.awt.event.*;
import java.io.*; //importamo klase koje su nam potrebne za sučelje i evente
public class amorti extends JFrame implements ActionListener {
JFrame fglc = new JFrame ();
private static final int si1=520,vi1=300,si2=650,vi2=340,si3=840,vi3=340;
public static JTextField tf1,tf2,tf3,tf4,tf5,tf6;
public JButton gum1,gum2,gum3,gum4,insert1,insert2;
private static JLabel l1,l2,l3,l4,l5,l6,l7,l8,l9;  
private JTextArea   taf1,taf2;
private JPanel      buttonPanel1,buttonPanel2;
private JScrollPane scrollPane,scrollPane2;
BufferedReader citac3 = new BufferedReader (new InputStreamReader (System.in));
int god,pos,mje,rat,i,rattt;
double pos2,vrije,nvrije=vrije,mvrije,pos4,izn,kam,anuit,multipla,ukupotp,rr,kamp,otpkv,nglav,ratt;
JFrame frame = new JFrame();
JFrame frame2 = new JFrame();
int puta1=0,puta2=0;
//definiramo klasu s parametrima za sučelje,evente te gumbe

//glavni prozor
public amorti()
{
fglc.setTitle("Amortizacija");
fglc.setSize(si1,vi1);
fglc.setDefaultCloseOperation(fglc.EXIT_ON_CLOSE);
fglc.getContentPane();
fglc.setLayout(null); 
fglc.setResizable(false);

l1= new JLabel();
l1.setText("Program za izračunavanje amortizacije");
l1.setSize (400, 30);
l1.setLocation (120, 30);
l1.setEnabled(true);
fglc.add (l1);

gum1 = new JButton ();
gum1.setText("Amortizacija predmeta");
gum1.setSize (200, 35);
gum1.setLocation (40, 100);
gum1.setEnabled(true);
gum1.addActionListener (this);
fglc.add (gum1);

gum2 = new JButton ();
gum2.setText("Amortizacija kredita");
gum2.setSize (200, 35);
gum2.setLocation (260, 100);
gum2.setEnabled(true);
gum2.addActionListener (this);
fglc.add (gum2);

fglc.setVisible(true);}

//prozor podprograma amortizacija predmet
public void amortip()
{  JFrame fpomc1 = new JFrame ();
fpomc1.setTitle("Amortizacija predmeta");
fpomc1.setSize(si2,vi2);
fpomc1.setDefaultCloseOperation(fpomc1.DISPOSE_ON_CLOSE);
fpomc1.getContentPane();
fpomc1.setLayout(null); 
fpomc1.setVisible(true); 
fpomc1.setResizable(false); 

l2= new JLabel();
l2.setText("Amortizacijska tablica za predmete");
l2.setSize (300, 30);
l2.setLocation (240, 30);
l2.setEnabled(true);
fpomc1.add (l2);

l3= new JLabel();
l3.setText("Broj godina:");
l3.setSize (80, 30);
l3.setLocation (40, 80);
l3.setEnabled(true);
fpomc1.add (l3);

l4= new JLabel();
l4.setText("Postotak po kojemu predmetu opada vrijednost:");
l4.setSize (300, 30);
l4.setLocation (160, 80);
l4.setEnabled(true);
fpomc1.add (l4);

l5= new JLabel();
l5.setText("Početna vrijednost:");
l5.setSize (150, 30);
l5.setLocation (480, 80);
l5.setEnabled(true);
fpomc1.add (l5);

tf1= new JTextField();
tf1.setText("10");
tf1.setSize (60, 30);
tf1.setLocation (40, 120);
tf1.setEnabled(true);
fpomc1.add (tf1);

tf2= new JTextField();
tf2.setText("10");
tf2.setSize (140, 30);
tf2.setLocation (220, 120);
tf2.setEnabled(true);
fpomc1.add (tf2);

tf3= new JTextField();
tf3.setText("1000");
tf3.setSize (80, 30);
tf3.setLocation (500, 120);
tf3.setEnabled(true);
fpomc1.add (tf3);

gum3 = new JButton ();
gum3.setText("Izračunajte vrijednost predmeta");
gum3.setSize (250, 35);
gum3.setLocation (180, 160);
gum3.setEnabled(true);
gum3.addActionListener (this);
fpomc1.add (gum3);
}

//metoda koja pokazuje novi prozor u kojoj će bit smješten text amortizacije kredita/predmeta
public void prozortaf1()
    {
        frame.setDefaultCloseOperation(frame.DISPOSE_ON_CLOSE);
        frame.setVisible(true);
        frame.setSize(650,700);
        frame.setResizable(false); 
        setTitle("Izračun Amortizacije za predmet");
        Container cp = getContentPane();

        taf1 = new JTextArea(32,32);
        scrollPane = new JScrollPane(taf1);
        
        cp.add(scrollPane, BorderLayout.CENTER);
        buttonPanel1 = new JPanel();
        insert1 = new JButton("Osvježi za predmete");
        insert2 = new JButton("Osvježi za kredit");
        buttonPanel1.add(insert1);
        buttonPanel1.add(insert2);

        cp.add(buttonPanel1, BorderLayout.SOUTH); 
        insert1.addActionListener(this); 
        insert2.addActionListener(this); 
        frame.add(cp); }
public void unesi1(){try{ // pokuša izračunati ako su varijable dobro unesene
god=Integer.parseInt (tf1.getText ());
pos=Integer.parseInt (tf2.getText ());
pos2=(double)pos/100;
vrije=Double.parseDouble (tf3.getText ());
nvrije=vrije;        

BufferedReader citac = new BufferedReader (new InputStreamReader (System.in));
//unosi text u novi textarea
taf1.setText("");
taf1.append("\t\tAmortizacijska tablica: \nProučavamo predmet na "+god+" godina"); 
taf1.append(" \nKoji je u početno trenutku vrijedio "+(int)vrije);
taf1.append("\nGodišnje gubi na vrijednosti "+pos);
taf1.append("\n_________________________________________________________");
taf1.append("\nBroj godina \t Vrijednost koju je izgubilo \t Sadašnja vrijednost");
taf1.append("\n_________________________________________________________");

for(int i=1;i<=god;i++)
{ mvrije=nvrije*pos2;
  nvrije=nvrije-mvrije;
taf1.append("\n"+i+".\t\t"+Math.round(mvrije*100.0)/100.0+"\t\t"+Math.round(nvrije*100.0)/100.0); 
} }
//ako je nešto krivo uneseno catchevi pregledavaju
catch(NumberFormatException error1)
{ taf1.setText("\t\tPogresan unos"); }
catch(ArithmeticException error2)
{ taf1.setText("\t\tPogresan unos"); } }

//prozor podprograma amortizacija kredit
private void amortik()
{  JFrame fpomc2 = new JFrame ();
fpomc2.setTitle("Amortizacija kredita");
fpomc2.setSize(600,vi2);
fpomc2.setDefaultCloseOperation(fpomc2.DISPOSE_ON_CLOSE);
fpomc2.getContentPane();
fpomc2.setLayout(null); 
fpomc2.setVisible(true); 
fpomc2.setResizable(false); 

l6= new JLabel();
l6.setText("Amortizacijska tablica za kredite");
l6.setSize (280, 30);
l6.setLocation (240, 30);
l6.setEnabled(true);
fpomc2.add (l6); 

l7= new JLabel();
l7.setText("Broj mjeseci trajanja kredita:");
l7.setSize (250, 30);
l7.setLocation (40, 80);
l7.setEnabled(true);
fpomc2.add (l7);

l8= new JLabel();
l8.setText("Kamata:");
l8.setSize (100, 30);
l8.setLocation (310, 80);
l8.setEnabled(true);
fpomc2.add (l8);

l9= new JLabel();
l9.setText("Glavnica:");
l9.setSize (100, 30);
l9.setLocation (430, 80);
l9.setEnabled(true);
fpomc2.add (l9);

tf4= new JTextField();
tf4.setText("10");
tf4.setSize (80, 30);
tf4.setLocation (40, 120);
tf4.setEnabled(true);
fpomc2.add (tf4);

tf5= new JTextField();
tf5.setText("10");
tf5.setSize (80, 30);
tf5.setLocation (310, 120);
tf5.setEnabled(true);
fpomc2.add (tf5);

tf6= new JTextField();
tf6.setText("1000");
tf6.setSize (100, 30);
tf6.setLocation (430, 120);
tf6.setEnabled(true);
fpomc2.add (tf6);

gum4 = new JButton ();
gum4.setText("Izračunajte otplatu kredita");
gum4.setSize (200, 35);
gum4.setLocation (200, 160);
gum4.setEnabled(true);
gum4.addActionListener (this);
fpomc2.add (gum4);
}

//metoda koja računa amortizaciju kredita
public void unesi2(){ try { 
rat=Integer.parseInt (tf4.getText ());
kam=Double.parseDouble (tf5.getText ());
izn=Double.parseDouble (tf6.getText ());
nglav=izn;
i=1;
anuit = 0;
multipla = 0;
ukupotp = 0 ;
rr=1+kam/100;
    multipla = Math.pow((1+ (kam / 1200)), rat) ;
     if ( kam  < 0.1 )
          {anuit= izn / rat ;}
      else
     {anuit= izn * kam * multipla / (1200 * (multipla -1)) ;}
          anuit =Math.round(anuit*100.0)/100.0;
          ukupotp= (anuit * rat) - izn ;
          ukupotp = Math.round(ukupotp*100.0)/100.0; 
//upisuje vrijednost u text area
BufferedReader citac2 = new BufferedReader (new InputStreamReader (System.in));
taf1.setText("");
taf1.append("\t\tAmortizacijska tablica: \nProučavamo kredit na "+rat+" mjeseci"); 
taf1.append("\nTreba otplatiti "+(int)izn);
taf1.append("\nGodišnja kamatna stopa iznosi "+kam);
taf1.append("\n______________________________________________________________________________________");
taf1.append("\nBroj mjeseci \t Anuitet \t  Vrijednost Kamate\t");
taf1.append("Vrijednost koju treba otplatiti");
taf1.append("\n______________________________________________________________________________________\n"); 
rattt=rat;
while(i<=rat) {if(nglav==0) break;
ratt=(double)rattt/12;
otpkv=anuit*Math.pow(rr,-ratt);
kamp=anuit-otpkv;
if((nglav-anuit)>=0)
nglav=nglav-anuit;
else { anuit=nglav; nglav=0; }
taf1.append("\n"+i+".\t"+Math.round(anuit*100.0)/100.0+"\t           "+Math.round(kamp*100.0)/100.0);
taf1.append("\t\t         "+Math.round(nglav*100.0)/100.0);
//+"\t"+Math.round(otpkv*100.0)/100.0); 
i++; rattt--; }
} catch(NumberFormatException error3)
{ taf1.setText("\t\t\tPogresan unos"); }
catch(ArithmeticException error4)
{ taf1.setText("\t\t\tPogresan unos"); } }

//metoda za događaje
public void actionPerformed(ActionEvent e) {
//2 gumba na glavnom prozoru
if (e.getSource () == gum1)
{ amortip(); }
if (e.getSource () == gum2)
{ amortik(); } 
//gumb na amortizaciji predmeta, gumb na amortizaciji kredita
if (e.getSource () == gum3)
{ if(puta1==0) { prozortaf1(); puta1=1; } else frame.setVisible(true); }
if (e.getSource () == gum4)
{ if(puta1==0) { prozortaf1(); puta1=1; } else frame.setVisible(true); }
if (e.getSource () == insert1)
{unesi1(); }
if (e.getSource () == insert2)
{unesi2(); } }

public static void main (String[] s)
{ amorti glavn = new amorti ();} }