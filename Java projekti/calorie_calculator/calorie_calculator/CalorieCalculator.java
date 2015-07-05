import javax.swing.*;
import javax.swing.JOptionPane;
import java.awt.*;
import java.awt.event.*;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.awt.Color;
import java.awt.Font;
import java.util.*;
import java.io.*;
import java.util.Date;
import java.util.Vector;
import java.util.*;
import java.util.ArrayList; 
import java.util.*;
import java.text.*;

public class CalorieCalculator extends JFrame implements ActionListener {
    public static void main(String[] s) {
        CalorieCalculator b = new CalorieCalculator();
        b.setVisible(true);
    }
    String s = "", f ="";
  
    
    Container c;
    public static JTextField t2, t3, t4, t5, t6, t7, t8, t9, t10, t11, t12;
    JButton b, a, jelo, btnPodaci;
    JLabel ls, lt, lv, ld, lr, la, lp, lc, lpc, lo, lulje, lobrok,
            lbrob, lprsa, lriza, lkcal, lcrta, li, lcopy;
    JRadioButton bm, bz;
    ButtonGroup spol;
    JComboBox<String> ca, cc, co;
    String[] aktivnost = { "0 sati vježbanja tjedno",
            "1-3 sata vježbanja tjedno", "3-5 sati vježbanja tjedno",
            "6-7 sati vježbanja tjedno", "8 i više sati vježbanja tjedno" };
    String[] obrok = { "3 obroka dnevno", "4 obroka dnevno",
            "5 obroka dnevno" };
    String[] cilj = { "Dobivanje mišićne mase",
            "Održavanje tjelesne mase", "Gubitak potkožnog masnog tkiva" };
    String mString = "Muški";
    String zString = "Ženski";
    double z, r, i, g, kcal, pro, uh, ma, proPi, uhRi, maMa, proKo,
            uhKo, maKo;
    int br, broj, brojac=0, mjesta = 0, brp=0;
    public static Vector<Vector<Integer>> redovi;
    int puta1=0;
    String t, h, xSelection;
    Font font;
    public static Vector<Vector<Integer>> mjestaa;
    
    public CalorieCalculator() {
        setTitle("Kalorijski kalkulator");
        setSize(760, 475);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        c = getContentPane();
        c.setLayout(null);
        String s = "";
        

        Font mFont = new Font("Arial", Font.BOLD, 12);
        Font maFont = new Font("Arial", Font.BOLD, 14);
        Font cFont = new Font("Arial", Font.PLAIN, 9);
        font = new Font("Arial", Font.PLAIN, 12);
        
        try
        {
            FileReader fin = new FileReader ("d:\\citaj2.txt");
            BufferedReader redak = new BufferedReader (fin);
            s=redak.readLine ();
        }
        catch (Exception e)
        {
            //gf
        }
    
        try
        {
            FileReader fin2 = new FileReader ("d:\\arhiva2.txt");
            BufferedReader redak2 = new BufferedReader (fin2);
            f=redak2.readLine ();
        }
        catch (Exception e)
        {
            //gf
        }       
        
        Date date = new Date();        

        //label za Izračun
        li = new JLabel("Kalorijski kalkulator");
        li.setSize(200,25);
        li.setLocation (10, 10);
        li.setFont(maFont);
        c.add(li);
        
        // label za spol
        ls = new JLabel("Izaberite spol:");
        ls.setSize(200, 25);
        ls.setLocation(10, 47);
        c.add(ls);

        // radio button za muško
        bm = new JRadioButton();
        bm.setText("Muški");
        bm.setSize(75, 25);
        bm.setLocation(135, 47);
        bm.setSelected(true);
        bm.setMnemonic(KeyEvent.VK_M);
        bm.setActionCommand(mString);
        c.add(bm);

        // radio button za žensko
        bz = new JRadioButton();
        bz.setText("Ženski");
        bz.setSize(120, 25);
        bz.setLocation(210, 47);
        bz.setMnemonic(KeyEvent.VK_Z);
        bz.setActionCommand(zString);
        c.add(bz);

        spol = new ButtonGroup();
        spol.add(bm);
        spol.add(bz);

        // okvir za težinu
        t2 = new JTextField();
        t2.setSize(200, 25);
        t2.setLocation(135, 87);
        c.add(t2);

        // label za težinu
        lt = new JLabel("Unesite težinu (kg):");
        lt.setSize(200, 25);
        lt.setLocation(10, 87);
        c.add(lt);

        // okvir za visinu
        t3 = new JTextField();
        t3.setSize(200, 25);
        t3.setLocation(135, 127);
        c.add(t3);

        // label za visinu
        lv = new JLabel("Unesite visinu (cm):");
        lv.setSize(200, 25);
        lv.setLocation(10, 127);
        c.add(lv);

        // okvir za dob
        t4 = new JTextField();
        t4.setSize(200, 25);
        t4.setLocation(135, 167);
        c.add(t4);

        // label za dob
        ld = new JLabel("Unesite dob:");
        ld.setSize(170, 25);
        ld.setLocation(40, 167);
        c.add(ld);

        // label za aktivnost
        la = new JLabel("Stupanj aktivnosti:");
        la.setSize(200, 25);
        la.setLocation(10, 207);
        c.add(la);

        // padajuća lista za aktivnost
        ca = new JComboBox<String>();
        
        for(int i = 0; i <5; i++)
        {
            ca.addItem(aktivnost[i]);
        }
        ca.setLocation(135, 207);
        ca.setSize(200, 25);
        ca.setSelectedIndex(4);
        c.add(ca);

        // label za cilj
        lc = new JLabel("Odaberite svoj cilj:");
        lc.setSize(200, 25);
        lc.setLocation(10, 247);
        c.add(lc);

        // padajuća lista za cilj
        cc = new JComboBox<String>();
        for(int i = 0; i < 3 ; i++)
        {
            cc.addItem(cilj[i]);
        }
        cc.setLocation(135, 247);
        cc.setSize(200, 25);
        cc.setSelectedIndex(2);
        c.add(cc);

        // label za obroke
        lo = new JLabel("Broj obroka:");
        lo.setSize(200, 25);
        lo.setLocation(10, 287);
        c.add(lo);

        // padajuća lista za obroke
        co = new JComboBox<String>();
        for(int i = 0; i < 3; ++i)
        {
            co.addItem(obrok[i]);
        }
        co.setLocation(135, 287);
        co.setSize(200, 25);
        co.setSelectedIndex(2);
        c.add(co);

        // gumb za izračun
        b = new JButton();
        b.setText("Izračunaj");
        b.setSize(325, 25);
        b.setLocation(10, 335);
        b.setFont(mFont);
        b.addActionListener(this);
        c.add(b);

        setVisible(true);
        
        // gumb za spremanje u file
        jelo = new JButton();
        jelo.setText("Arhiviraj unos");
        jelo.setSize(325, 25);
        jelo.setLocation(345, 358);
        jelo.setFont(mFont);
        jelo.addActionListener(this);
        c.add(jelo);
        
         // gumb za spremanje pregled podataka
        btnPodaci = new JButton();
        btnPodaci.setText("Pregledaj prethodne unose");
        btnPodaci.setSize(325, 25);
        btnPodaci.setLocation(345, 398);
        btnPodaci.setFont(mFont);
        btnPodaci.addActionListener(this);
        c.add(btnPodaci);

        setVisible(true);

        // okvir za rješenje
        t5 = new JTextField();
        t5.setSize(230, 25);
        t5.setLocation(500, 238);
        t5.setEditable(false);
        c.add(t5);

        // label za rješenje
        lr = new JLabel("Vaš bazalni metabolizam:");
        lr.setSize(160, 25);
        lr.setLocation(345, 238);
        lr.setFont(mFont);
        c.add(lr);

        // label za potrošnju
        lp = new JLabel("Vaša potrošnja kalorija:");
        lp.setSize(160, 25);
        lp.setLocation(345, 278);
        lp.setFont(mFont);
        c.add(lp);

        // okvir za potrošnju
        t6 = new JTextField();
        t6.setSize(230, 25);
        t6.setLocation(500, 278);
        t6.setEditable(false);
        c.add(t6);

        // label za potrošnju s obzirom na cilj
        lpc = new JLabel("Vaš ciljani unos kalorija:");
        lpc.setSize(160, 25);
        lpc.setLocation(345, 318);
        lpc.setFont(mFont);
        c.add(lpc);

        // okvir za potrošnju s obzirom na cilj
        t7 = new JTextField();
        t7.setSize(230, 25);
        t7.setLocation(500, 318);
        t7.setEditable(false);
        c.add(t7);

        // label za obrok
        lobrok = new JLabel("Primjer obroka:");
        lobrok.setSize(150, 25);
        lobrok.setLocation(346, 10);
        lobrok.setFont(maFont);
        c.add(lobrok);

        // label za broj obroka
        lbrob = new JLabel("Broj obroka u danu:");
        lbrob.setSize(150, 25);
        lbrob.setLocation(370, 46);
        lbrob.setFont(mFont);
        c.add(lbrob);

        // okvir za broj obroka
        t8 = new JTextField();
        t8.setSize(200, 25);
        t8.setLocation(530, 47);
        t8.setEditable(false);
        c.add(t8);

        // label za kalorija po obroku
        lkcal = new JLabel("Kalorija po obroku:");
        lkcal.setSize(150, 25);
        lkcal.setLocation(370, 86);
        lkcal.setFont(mFont);
        c.add(lkcal);

        // okvir za kalorija po obroku
        t9 = new JTextField();
        t9.setSize(200, 25);
        t9.setLocation(530, 87);
        t9.setEditable(false);
        c.add(t9);

        // label za pileca prsa
        lprsa = new JLabel("Pileća prsa (g):");
        lprsa.setSize(127, 25);
        lprsa.setLocation(393, 126);
        lprsa.setFont(mFont);
        c.add(lprsa);

        // okvir za prsa
        t10 = new JTextField();
        t10.setSize(170, 25);
        t10.setLocation(530, 127);
        t10.setEditable(false);
        c.add(t10);

        // label za rižu
        lriza = new JLabel("Smeđa riža (g):");
        lriza.setSize(126, 25);
        lriza.setLocation(394, 162);
        lriza.setFont(mFont);
        c.add(lriza);

        // okvir za rižu
        t11 = new JTextField();
        t11.setSize(170, 25);
        t11.setLocation(530, 163);
        t11.setEditable(false);
        c.add(t11);

        // label za ulje
        lulje = new JLabel("Maslinovo ulje (g):");
        lulje.setSize(142, 25);
        lulje.setLocation(378, 198);
        lulje.setFont(mFont);
        c.add(lulje);

        // okvir za ulje
        t12 = new JTextField();
        t12.setSize(170, 25);
        t12.setLocation(530, 199);
        t12.setEditable(false);
        c.add(t12);
        
        //label za copyright
        lcopy = new JLabel("© 2012 by Filip Lukacevic. All rights reserved");
        lcopy.setSize(250,25);
        lcopy.setLocation (10, 410);
        lcopy.setFont(cFont);
        c.add(lcopy);
        setResizable(false);
    }

    public void izracunajm() {
        int a = Integer.parseInt(t2.getText());
        int b = Integer.parseInt(t3.getText());
        int c = Integer.parseInt(t4.getText());
        double d = 66 + (13.7 * a) + (5 * b) - (6.8 * c);
        z = d;
        DecimalFormat df1 = new DecimalFormat("0");
        t5.setText("" + df1.format(d));

    }
    
    public void probni() {
        kcal = g / broj;
        DecimalFormat df5 = new DecimalFormat("0");
        t9.setText("" + df5.format(kcal));
        pro = kcal * 0.35 / 4;
        uh = kcal * 0.55 / 4;
        ma = kcal * 0.1 / 9;
        proPi = 21;
        uhRi = 80;
        maMa = 100;
        proKo = pro / proPi * 100;
        uhKo = uh / uhRi * 100;
        maKo = ma / maMa * 100;
        DecimalFormat df6 = new DecimalFormat("0");
        t10.setText("" + df6.format(proKo));
        t11.setText("" + df6.format(uhKo));
        t12.setText("" + df6.format(maKo));
    }
    
    public void izracunajz() {
        int a = Integer.parseInt(t2.getText());
        int b = Integer.parseInt(t3.getText());
        int c = Integer.parseInt(t4.getText());
        double d = 655 + (9.6 * a) + (1.8 * b) - (4.7 * c);
        z = d;
        DecimalFormat df2 = new DecimalFormat("0");
        t5.setText("" + df2.format(d));

    }
    
    public void racuna ()
    {
                if (t == mString) {
            izracunajm();
        } else {
            izracunajz();
        }
        if (ca.getSelectedIndex() == 0)
            r = z * 1.2;
        else if (ca.getSelectedIndex() == 1)
            r = z * 1.35;
        else if (ca.getSelectedIndex() == 2)
            r = z * 1.55;
        else if (ca.getSelectedIndex() == 3)
            r = z * 1.75;
        else if (ca.getSelectedIndex() == 4)
            r = z * 2.0;
        i = r;
        DecimalFormat df3 = new DecimalFormat("0");
        t6.setText("" + df3.format(r));

        if (cc.getSelectedIndex() == 0)
            g = i * 1.15;
        if (cc.getSelectedIndex() == 1)
            g = i * 1;
        if (cc.getSelectedIndex() == 2)
            g = i * 0.8;
        DecimalFormat df4 = new DecimalFormat("0");
        t7.setText("" + df4.format(g));

        if (co.getSelectedIndex() == 0) {
            broj = 3;
            t8.setText("" + broj);
        }
        if (co.getSelectedIndex() == 1) {
            broj = 4;
            t8.setText("" + broj);
        }
        if (co.getSelectedIndex() == 2) {
            broj = 5;
            t8.setText("" + broj);
        }
        probni();
    }
    
    public void spremi ()
    {
        try
        {
            FileWriter fout = new FileWriter ("D:\\arhiva2.txt", true);
            PrintWriter pw = new PrintWriter (fout);
            int podatak = Integer.parseInt(t7.getText());
            int aa = Integer.parseInt(t2.getText());
            int ab = Integer.parseInt(t3.getText());
            int ac = Integer.parseInt(t4.getText());    
            Date date = new Date();
            pw.println (podatak+" (kcal) - " + aa +" (kg) - " + ab + " (cm) - " + ac +" (god)");
            pw.println ((date.toString()));
            pw.println ("\n");
            pw.close();
        }
        catch (Exception e)
        {
            JOptionPane.showMessageDialog(this, "Greška! Nije moguće spremiti podatke");
        }
    }
    public void reset()
    {
            inicijaliziranje.tezina = new int[250];
            inicijaliziranje.visina = new int[250];
            inicijaliziranje.kcal1 = new int[250];
            inicijaliziranje.dob = new int[250];
    }    
    public void actionPerformed(ActionEvent e) {
        Popis noviobj = new Popis();
        if (e.getSource () == b)
        {
            ButtonModel b = spol.getSelection();
            if (b != null)
                t = b.getActionCommand();
            try 
                {
                    int aa = Integer.parseInt(t2.getText());
                }
            catch(Exception q)
                {
                    t2.setText("Greška! Morate unijeti broj");
                    brojac++;
                }
            try 
                {
                    int ab = Integer.parseInt(t3.getText());
                }
                catch(Exception q)
                {
                    t3.setText("Greška! Morate unijeti broj");
                    brojac++;
                }
            try 
            {
                int ac = Integer.parseInt(t4.getText());         
            }
            catch(Exception q)
                {
                    t4.setText("Greška! Morate unijeti broj");
                    brojac++;
                }
                if (brojac == 0) racuna();   
        }
        else if (e.getSource () == jelo)
            {
                spremi ();
                inicijaliziranje.skladistem1();
            }
        else if (e.getSource () == btnPodaci)
            {
                 noviobj.Popis1();
            }
    }
}