import java.awt.event.*;
import java.awt.*;
import javax.swing.*;

public class TestRadioButton    
{
    public static void main(String [] args)
    {
        JFrame frame = new TestRadioButtonFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}

class TestRadioButtonFrame extends JFrame
{
    private JLabel       labela;        
    private ButtonGroup  grupa;             
    private JPanel       buttonPanel;             
    private static final int DEFAULT_SIZE = 12;
    
    TestRadioButtonFrame()
    {
        setTitle("RadioButtonTest");
        setSize(400,200);
        Container cp = getContentPane();

        labela = new JLabel("University of Zageb", SwingConstants.CENTER);
        labela.setFont(new Font("Serif",Font.PLAIN, DEFAULT_SIZE));
        cp.add(labela, BorderLayout.CENTER);
               
        buttonPanel = new JPanel();
        grupa = new ButtonGroup();

        addRadioButton("small", 8);   
        addRadioButton("medium", 12);   
        addRadioButton("large", 18);   
        addRadioButton("extra large", 36);   

        
        cp.add(buttonPanel, BorderLayout.SOUTH);
    }  

    public void addRadioButton(String name, final int size)
    {
        boolean selected = (size == DEFAULT_SIZE);
        JRadioButton button = new JRadioButton(name, selected);
        grupa.add(button);
        buttonPanel.add(button);
        button.addActionListener(new ActionListener(){
                public void actionPerformed(ActionEvent e){
                    labela.setFont(new Font("Serif", Font.PLAIN, size));
                }
        });

    }
}
