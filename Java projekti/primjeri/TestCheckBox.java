import java.awt.event.*;
import java.awt.*;
import javax.swing.*;

public class TestCheckBox    
{
    public static void main(String [] args)
    {
        JFrame frame = new TestCheckBoxFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}

class TestCheckBoxFrame extends JFrame
{
    private JLabel  labela;        
    private JCheckBox bold;             
    private JCheckBox italic;             
    private static final int FONTSIZE = 16;
    
    TestCheckBoxFrame()
    {
        setTitle("CheckBoxTest");
        setSize(300,200);
        Container cp = getContentPane();

        labela = new JLabel("University of Zageb", SwingConstants.CENTER);
        labela.setFont(new Font("Serif",Font.PLAIN, FONTSIZE));
        cp.add(labela, BorderLayout.CENTER);
               
        JPanel buttonPanel = new JPanel();

        bold = new JCheckBox("bold");
        italic = new JCheckBox("italic");

        buttonPanel.add(bold);
        buttonPanel.add(italic);

        cp.add(buttonPanel, BorderLayout.SOUTH);

        ActionListener listener = new ActionListener(){
            public void actionPerformed(ActionEvent e){
                int mode = 0;
                if(bold.isSelected()) mode += Font.BOLD;
                if(italic.isSelected()) mode += Font.ITALIC;
                labela.setFont(new Font("Serif", mode, FONTSIZE));
            }
        };

        bold.addActionListener(listener);
        italic.addActionListener(listener);
    }  
}
