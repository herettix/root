import java.awt.*;
import java.awt.event.*;
import javax.swing.*;


public class TestButton {
    public static void main(String[] args){
        ButtonFrame frame = new ButtonFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}

class ButtonFrame extends JFrame
{
    public ButtonFrame()
    {
        setTitle("Test s bojom pozadine");
        setSize(300,200);
        Container cp = getContentPane();
        ButtonPanel panel = new ButtonPanel();
        cp.add(panel);
    }
}

class ButtonPanel extends JPanel
{
    public ButtonPanel()
    {
        // Tri buttona
        makeButton("Yellow", Color.YELLOW);
        makeButton("Blue", Color.BLUE);
        makeButton("Red", Color.RED);
        makeButton("Green", Color.GREEN);
        makeButton("Orange", Color.ORANGE);
    }
    
    void makeButton(String labela, final Color bojaPozadine)
    {
        JButton botun = new JButton(labela);
        add(botun);
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
