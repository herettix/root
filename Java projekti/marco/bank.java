import javax.swing.*; 
import java.awt.*;
import java.awt.event.*; 
import java.io.*;
public class bank extends JFrame implements ActionListener {
private final int si=560,vi=440;
private Container glavni;
private JButton but1,but2,insert1;
private JLabel lpg,l1,l2,l3,l4,l5,l6,l7,l8,l9,l10,l11;
public JTextField t1,t2,t3,t4,t5,t6,t7,t8,t9,t10;
private JTextArea   taf1;
private JPanel buttonPanel1;
private JScrollPane scrollPane;
public double hrk=1,eur=7.51,usd=5.71,cfh=6.24;
private JComboBox cb1;
private JCheckBox chb1;
int puta1=0,rat,i,rattt;
double izn,kam,anuit,multipla,ukupotp,rr,kamp,otpkv,nglav,ratt,ukuu,nakn=0,naknn,depo,depok,depou,ukuk,depoum;
JFrame bankar = new JFrame ();
JFrame frame = new JFrame();
String val="kn";
String[] valute = {
        "valuta",
         "HRK",
         "EUR",
         "USD",
         "CFH"};
//glavni prozor programa
public bank()
{
bankar.setTitle("Program za izračun kredita");
bankar.setSize(si,vi);
bankar.setDefaultCloseOperation(bankar.EXIT_ON_CLOSE);
bankar.getContentPane();
bankar.setLayout(null); 
bankar.setResizable(false);

lpg= new JLabel();
lpg.setText("Izračunajte sami svoj kredit");
lpg.setSize (220, 30);
lpg.setLocation (180, 30);
lpg.setEnabled(true);
bankar.add (lpg);

l1= new JLabel();
l1.setText("Iznos kredita:");
l1.setSize (100, 30);
l1.setLocation (30, 80);
l1.setEnabled(true);
bankar.add (l1);

l2= new JLabel();
l2.setText("Kamatna stopa:");
l2.setSize (100, 30);
l2.setLocation (230, 80);
l2.setEnabled(true);
bankar.add (l2);

l3= new JLabel();
l3.setText("Rok otplate (u mjesecima):");
l3.setSize (200, 30);
l3.setLocation (380, 80);
l3.setEnabled(true);
bankar.add (l3);

t1= new JTextField();
t1.setText("1000");
t1.setSize (90, 30);
t1.setLocation (30, 120);
t1.setEnabled(true);
bankar.add (t1);

t2= new JTextField();
t2.setText("10");
t2.setSize (90, 30);
t2.setLocation (230, 120);
t2.setEnabled(true);
bankar.add (t2);

t3= new JTextField();
t3.setText("10");
t3.setSize (90, 30);
t3.setLocation (380, 120);
t3.setEnabled(true);
bankar.add (t3);

cb1 = new JComboBox (valute);
cb1.setSize(60,40);
cb1.setLocation (140, 120);
cb1.setSelectedIndex(1);
cb1.addActionListener(this);
bankar.add (cb1);

l4= new JLabel();
l4.setText("Naknada kredita:");
l4.setSize (200, 30);
l4.setLocation (30, 160);
l4.setEnabled(true);
bankar.add (l4);

l5= new JLabel();
l5.setText("Depozit:");
l5.setSize (200, 30);
l5.setLocation (230, 160);
l5.setEnabled(true);
bankar.add (l5);

l6= new JLabel();
l6.setText("Kamata na depozit:");
l6.setSize (200, 30);
l6.setLocation (380, 160);
l6.setEnabled(true);
bankar.add (l6);

t4= new JTextField();
t4.setText("0");
t4.setSize (90, 30);
t4.setLocation (30, 200);
t4.setEnabled(true);
bankar.add (t4);

t5= new JTextField();
t5.setText("0");
t5.setSize (90, 30);
t5.setLocation (230, 200);
t5.setEnabled(true);
bankar.add (t5);

t6= new JTextField();
t6.setText("0");
t6.setSize (90, 30);
t6.setLocation (380, 200);
t6.setEnabled(true);
bankar.add (t6);

chb1 = new JCheckBox ();
chb1.setText ("Prikaži otplatnu tablicu kredita");
chb1.setSize (220, 30);
chb1.setLocation (40, 240);
chb1.setSelected(true);
//chb1.addActionListener (this);
bankar.add (chb1);


but1 = new JButton ();
but1.setText("Izračunaj");
but1.setSize (120, 35);
but1.setLocation (260, 240);
but1.setEnabled(true);
but1.addActionListener (this);
bankar.add (but1);

l7= new JLabel();
l7.setText("Anuitet:");
l7.setSize (100, 30);
l7.setLocation (40, 290);
l7.setEnabled(true);
bankar.add (l7);

l8= new JLabel();
l8.setText("Ukupno kamate:");
l8.setSize (100, 30);
l8.setLocation (160, 290);
l8.setEnabled(true);
bankar.add (l8);

l9= new JLabel();
l9.setText("Ukupna otplata:");
l9.setSize (100, 30);
l9.setLocation (280, 290);
l9.setEnabled(true);
bankar.add (l9);

l10= new JLabel();
l10.setText("Iznos kredita");
l10.setSize (150, 15);
l10.setLocation (400, 290);
l10.setEnabled(true);
bankar.add (l10);

l11= new JLabel();
l11.setText("koji se isplaćuje:");
l11.setSize (150, 15);
l11.setLocation (400, 305);
l11.setEnabled(true);
bankar.add (l11);

t7= new JTextField();
t7.setText("");
t7.setSize (90, 30);
t7.setLocation (40, 330);
t7.setEnabled(true);
bankar.add (t7);

t8= new JTextField();
t8.setText("");
t8.setSize (90, 30);
t8.setLocation (160, 330);
t8.setEnabled(true);
bankar.add (t8);

t9= new JTextField();
t9.setText("");
t9.setSize (90, 30);
t9.setLocation (280, 330);
t9.setEnabled(true);
bankar.add (t9);

t10= new JTextField();
t10.setText("");
t10.setSize (90, 30);
t10.setLocation (400, 330);
t10.setEnabled(true);
bankar.add (t10);

bankar.setVisible(true); }
//metoda za ispis u text polja
public void unesi1()
{ try{
rat=Integer.parseInt (t3.getText ());
kam=Double.parseDouble (t2.getText ());
izn=Double.parseDouble (t1.getText ());
nakn=Double.parseDouble (t4.getText ());
depo=Double.parseDouble (t5.getText ());
depok=Double.parseDouble (t6.getText ());
depou=depo*(depok/100)+depo;
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
          naknn=(nakn/100)*izn;
naknn=Math.round(naknn*100.0)/100.0;
          ukuu=anuit*rat;
ukuu=Math.round(ukuu*100.0)/100.0;
          ukuk=izn-depou-naknn;
ukuk=Math.round(ukuk*100.0)/100.0;
} catch(NumberFormatException error3)
{ t7.setText("Pogresan unos");  t8.setText("Pogresan unos"); t9.setText("Pogresan unos");}
catch(ArithmeticException error4)
{ t7.setText("Pogresan unos"); t8.setText("Pogresan unos"); t9.setText("Pogresan unos");}}
//prozor tablice
public void prozortaf1()
    {
        frame.setDefaultCloseOperation(frame.DISPOSE_ON_CLOSE);
        frame.setVisible(true);
        frame.setSize(680,700);
        frame.setResizable(false); 
        frame.setTitle("Izračun Amortizacije za predmet");
        Container cp = getContentPane();

        taf1 = new JTextArea(32,32);
        scrollPane = new JScrollPane(taf1);
        
        cp.add(scrollPane, BorderLayout.CENTER);
        buttonPanel1 = new JPanel();
        insert1 = new JButton("Osvježi");
        buttonPanel1.add(insert1);

        cp.add(buttonPanel1, BorderLayout.SOUTH); 
        insert1.addActionListener(this); 
        frame.add(cp); }   
//metoda za ispis u tablicu        
public void unesi2(){ try { 
rat=Integer.parseInt (t3.getText ());
kam=Double.parseDouble (t2.getText ());
izn=Double.parseDouble (t1.getText ());
nakn=Double.parseDouble (t4.getText ());
depo=Double.parseDouble (t5.getText ());
depok=Double.parseDouble (t6.getText ());
depou=depo*(depok/100)+depo;
depoum=depou*-1;
naknn=(nakn/100)*izn;
naknn=Math.round(naknn*100.0)/100.0;
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
          ukuu=Math.round(ukuu*100.0)/100.0;
          ukuk=izn-depou-naknn;
          ukuk=Math.round(ukuk*100.0)/100.0;
//upisuje vrijednost u text area
BufferedReader citac2 = new BufferedReader (new InputStreamReader (System.in));
taf1.setText("");
taf1.append("\t\tTablica za izračunavanje kredita: \nProučavamo kredit na "+rat+" mjeseci"); 
taf1.append("\nTreba otplatiti "+(int)izn+" "+val);
taf1.append("\nGodišnja kamatna stopa iznosi "+kam+"%");
taf1.append("\nNaknada kredita iznosi "+nakn+"% i jednokratno ju plaćate:"+naknn+" "+val);
taf1.append("\nDepozit iznosi"+depo+" "+val+", a kamata na depozit iznosi "+depok+" %");
taf1.append("\n____________________________________________________________________________________________");
taf1.append("\nBroj mjeseci \t Anuitet \t  Vrijednost Kamate\t");
taf1.append("Otplatna kvota \t         Vrijednost koju treba otplatiti");
taf1.append("\n____________________________________________________________________________________________\n"); 
rattt=rat;
//ako ne postoji depozit
if(depou==0){
while(i<=rat) {
ratt=(double)rattt/12;
otpkv=anuit*Math.pow(rr,-ratt);
kamp=anuit-otpkv;
if((nglav-anuit)>=0)
nglav=nglav-anuit;
else { anuit=nglav; nglav=0; }
taf1.append("\n"+i+".\t"+Math.round(anuit*100.0)/100.0+" "+val+"\t           "+Math.round(kamp*100.0)/100.0+" "+val);
taf1.append("\t\t  "+""+Math.round(otpkv*100.0)/100.0+" "+val+"\t         "+Math.round(nglav*100.0)/100.0+" "+val);
i++; rattt--; } }
//ako postoji depozit
else if(depou>0){
while(nglav>depoum) {
ratt=(double)rattt/12;
otpkv=anuit*Math.pow(rr,-ratt);
kamp=anuit-otpkv;
if((nglav-anuit)>=depoum)
nglav=nglav-anuit;
else { anuit=-1*nglav; nglav=depoum; }
taf1.append("\n"+i+".\t"+Math.round(anuit*100.0)/100.0+" "+val+"\t           "+Math.round(kamp*100.0)/100.0+" "+val);
taf1.append("\t\t  "+""+Math.round(otpkv*100.0)/100.0+" "+val+"\t         "+Math.round(nglav*100.0)/100.0+" "+val);
i++; rattt--; } }
} catch(NumberFormatException error3)
{ taf1.setText("\t\t\tPogresan unos"); }
catch(ArithmeticException error4)
{ taf1.setText("\t\t\tPogresan unos"); } }

//metoda za izabiranje valuta        
public void izaberi() {
if(cb1.getSelectedIndex()==1) { val="kn";  }
else if(cb1.getSelectedIndex()==2) { val="€";  }
else if(cb1.getSelectedIndex()==3) { val="$";  }
else if(cb1.getSelectedIndex()==4) { val="CFH"; }  }


//metoda koja pregledava radnje nad gumbima    
public void actionPerformed(ActionEvent e) { 
if(e.getSource () == but1) { if(chb1.isSelected()==false) { unesi1(); t7.setText(anuit+" "+val); t8.setText(ukupotp+" "+val); t9.setText(ukuu+" "+val); t10.setText(ukuk+" "+val); } 
else { if(puta1==0) { izaberi(); prozortaf1(); unesi2(); puta1=1; } else {frame.setVisible(true); izaberi(); unesi2(); } } } 
if (e.getSource () == insert1)
{izaberi(); unesi2(); } }
public static void main (String[] s)
{ bank glavn = new bank();} }