import java.awt.event.*;
import javax.swing.event.*;
import java.awt.*;
import javax.swing.*;
import javax.swing.text.*;

public class TestJComponents2
{
    public static void main(String [] args)
    {
        JFrame frame = new TestJCompFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}

class TestJCompFrame extends JFrame
{
    TestJCompFrame()
    {
        Container cp = getContentPane();
        TestJCompPanel panel = new TestJCompPanel();
        cp.add(panel);
        pack();
    }
}

class TestJCompPanel extends JPanel
{
    JTextField jtf; 
    JLabel     jlb;

    TestJCompPanel()
    {
        setLayout(new BorderLayout());
        jtf = new JTextField("",12);
        jlb = new JLabel("");

        JButton    ccl= new JButton("cancel");
        
        JPanel south = new JPanel();
        south.add(ccl);
        add(south, BorderLayout.SOUTH);

        JPanel center = new JPanel(new GridLayout(2,1));
        center.add(jtf);
        center.add(jlb);
        add(center, BorderLayout.CENTER);

        jtf.getDocument().addDocumentListener(new DocumentListener(){
            public void insertUpdate(DocumentEvent event){
                jlb.setText(jtf.getText().trim());
            }
            public void removeUpdate(DocumentEvent event){
                jlb.setText(jtf.getText().trim());
            }
             public void changedUpdate(DocumentEvent event){ }
        });
        
        ccl.addActionListener(new ActionListener()
                {
                    public void actionPerformed(ActionEvent e){
                        System.exit(0);
                    }
                });

    }
}
