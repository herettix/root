import java.awt.*;
import java.awt.event.*;
import javax.swing.*;


public class TestBorder3 {
    public static void main(String[] args){
        Border3Frame frame = new Border3Frame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}

class Border3Frame extends JFrame
{
    public Border3Frame()
    {
        setTitle("Test s bojom pozadine");
        setSize(300,200);
        Container cp = getContentPane();
        Border3Panel panel = new Border3Panel();
        cp.add(panel);
    }
}

class Border3Panel extends JPanel
{
    public Border3Panel()
    {
        setLayout(new BorderLayout());
        JPanel botPanel = new JPanel();
        // Tri buttona koji se sada dodaju u panel (Flow Layout Manager)
        makeButton(botPanel,"Yellow", Color.YELLOW);
        makeButton(botPanel,"Blue",   Color.BLUE);
        makeButton(botPanel,"Red",    Color.RED);
        // Dodaj panel na jug
        add(botPanel, BorderLayout.SOUTH);
    }
    
    void makeButton(JPanel panel, String labela, final Color bojaPozadine)
    {
        JButton botun = new JButton(labela);
        panel.add(botun);
        botun.addActionListener(new 
                ActionListener()
                {
                     public void actionPerformed(ActionEvent e) {
                     // metoda iz JComponent klase
                     setBackground(bojaPozadine);
                }
                });
        // Referenca botun sada nestaje, ali to nije bitno jer ju čuva ButtonPanel
    }

 }
