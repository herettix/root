import java.awt.*;
import java.awt.event.*;
import java.awt.geom.*;
import javax.swing.*;
import java.util.*; // ArrayList

public class TestMouseListener
{
    public static void main(String[] args)
    {
        MouseFrame mf = new MouseFrame();
        mf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mf.setVisible(true);
    }
}

class MouseFrame extends JFrame 
{
    public MouseFrame()
    {
        setTitle("MouseFrame");
        setSize(300,200);
        MousePanel mp = new MousePanel();
        Container contentPane = getContentPane();
        contentPane.add(mp);
    }
}

class MousePanel extends JPanel
{
    // Privatni podaci 
    private static final int DULJINA = 10; // duljina stranice kvadrata
    private ArrayList        kvadrati;     // lista kvadrata
    private Rectangle2D      trenutni;     // aktualni kvadrat

    public MousePanel()
    {
        kvadrati = new ArrayList();
        trenutni = null;

        addMouseListener(new MouseHandler());
        addMouseMotionListener(new MouseMotionHandler());
    }

    // Iscrtavanje panela
    public void paintComponent(Graphics g)
    {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;

        for(int i=0; i<kvadrati.size(); ++i) 
            g2.draw((Rectangle2D) kvadrati.get(i));
    }
    
    // Rutine za manipolaciju s listom kvadrata: add, find, remove
    // Metode se jednostavno implemetiraju pomoću metoda klase ArrayList 
    // 
    // Dodaj novi kvadrat s centrom u točki p.
    public void add(Point2D p)
    {
        double x = p.getX();
        double y = p.getY();
        
        trenutni = new Rectangle2D.Double(x-DULJINA/2, y-DULJINA/2,
                                          DULJINA, DULJINA);
        // Koristimo metodu add iz ArrayList
        kvadrati.add(trenutni);
        repaint();
    }
    // Pronađi element u listi koji sadrľi točku p. Vrati null ako takvog nema.
    public Rectangle2D find(Point2D p)
    {
        // Sav posao odrađuje metod contains iz Rectangle2D koja ispituje je li
        // točka unutar pravokutnika.
        for(int i=0; i<kvadrati.size(); ++i){
            // moramo castati -- u Java 5.0 moľe elegantnije ako koristimo 
            // ArrayList<Rectangle2D>
            Rectangle2D rec=(Rectangle2D) kvadrati.get(i);
            if(rec.contains(p)) return (Rectangle2D) kvadrati.get(i);
        }
        return null;
    }
    // Odstrani element iz liste 
    public void remove(Rectangle2D r)
    {
        if(r == null) return;
        if(r == trenutni) trenutni = null; 
        kvadrati.remove(r);
        repaint();
    }
    
    // Rutine za procesiranje događaja. Smjeątene su u dvije unutarnje klase.
    // Privatna unutarnja klasa 
    private class MouseHandler extends MouseAdapter
    {
        // Čim pritisnemo tipku miąa kreiramo novi kvadrat
        public void mousePressed(MouseEvent e)
        {
            // Da li se pritisak dogodio unutar nekog pravokutnika?
            trenutni = find(e.getPoint());
            if(trenutni == null)   // nije
                add(e.getPoint()); // dodaj novi pravokutnik
        }

        // Ako kliknemo dvaput u kvadratu briąemo ga
        public void mouseClicked(MouseEvent e)
        {
            // Da li se pritisak dogodio unutar nekog pravokutnika?
            trenutni = find(e.getPoint());
            if(trenutni != null && e.getClickCount() >=2 )   // je, bar dva puta
                remove(trenutni);                            // briąi pravokutnik
        }

    }
    
    // Privatna unutarnja klasa 
    private class MouseMotionHandler implements MouseMotionListener
    {
        public void mouseMoved(MouseEvent e)
        {
            // Ako se gibanje deąava unutar kvadrata promijeni kursor
            if(find(e.getPoint()) == null) setCursor(Cursor.getDefaultCursor());
            else 
                setCursor(Cursor.getPredefinedCursor(Cursor.CROSSHAIR_CURSOR));
        }
        public void mouseDragged(MouseEvent e)
        {
            // Čim se stisne tipka unutar nekog pravokutnika
            // bit će postavljen trenutni
            if(trenutni != null)
            {
                int x = e.getX();
                int y = e.getY();

                // Vučemo kvadrat
                trenutni.setFrame(x-DULJINA/2, y-DULJINA/2, DULJINA, DULJINA);
                repaint();
            }
        }
    }
}
