import java.awt.event.*;
import java.awt.*;
import javax.swing.*;

public class TestTextArea    
{
    public static void main(String [] args)
    {
        JFrame frame = new TestTextAreaFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}

class TestTextAreaFrame extends JFrame
{
    private JTextArea   textArea;
    private JScrollPane scrollPane;
    private JPanel      buttonPanel;
    private JButton     wrap;
    
    TestTextAreaFrame()
    {
        setTitle("TextAreaTest");
        setSize(300,300);
        Container cp = getContentPane();

        textArea = new JTextArea(8,40);
        scrollPane = new JScrollPane(textArea);
        // po defaultu ContentPane ima  BorderLayout manager
        cp.add(scrollPane, BorderLayout.CENTER);
               
        buttonPanel = new JPanel();
        JButton insert = new JButton("insert");
        buttonPanel.add(insert);

        wrap = new JButton("wrap");
        buttonPanel.add(wrap);

        cp.add(buttonPanel, BorderLayout.SOUTH);

        insert.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                textArea.append("<a href=\"..\">..</a> ");
            }
        });

        wrap.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                boolean mode = textArea.getLineWrap();
                textArea.setLineWrap(!mode);
               // textArea.setWrapStyleWord(true);
                scrollPane.revalidate();
                wrap.setText(mode ? "wrap" : "no wrap");
            }
        });
    }
    
}
