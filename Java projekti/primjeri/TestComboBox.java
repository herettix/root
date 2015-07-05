import java.awt.event.*;
import java.awt.*;
import javax.swing.*;

public class TestComboBox    
{
    public static void main(String [] args)
    {
        JFrame frame = new TestComboBoxFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}

class TestComboBoxFrame extends JFrame
{
    private JLabel       labela;        
    private JComboBox    cbox;              
    private static final int DEFAULT_SIZE = 16;
    
    TestComboBoxFrame()
    {
        setTitle("ComboBoxTest");
        setSize(300,200);
        Container cp = getContentPane();

        labela = new JLabel("University of Zageb", SwingConstants.CENTER);
        labela.setFont(new Font("Serif",Font.PLAIN, DEFAULT_SIZE));
        cp.add(labela, BorderLayout.CENTER);
               
        cbox = new JComboBox();
        cbox.setEditable(true);    

        cbox.addItem("Serif");     
        cbox.addItem("SansSerif");     
        cbox.addItem("Monospaced");    
        cbox.addItem("Dialog");    
        cbox.addItem("DialogInput");    

        JPanel comboPanel = new JPanel();
        comboPanel.add(cbox);
        cp.add(comboPanel, BorderLayout.SOUTH);


        cbox.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                labela.setFont(new Font(
                        (String) cbox.getSelectedItem(), Font.PLAIN, 
                        DEFAULT_SIZE )
                    );
            }
        });
    }  
}
