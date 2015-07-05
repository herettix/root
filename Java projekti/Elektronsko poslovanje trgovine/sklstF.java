import java.awt.event.*;
import java.awt.*;
import javax.swing.*;
import java.io.*;
import java.util.ArrayList; 
import java.lang.Object.*;

public class sklstF extends JFrame implements ActionListener
{
    private JTextArea   textArea;
    private JScrollPane scrollPane;
    private JPanel      buttonPanel;
    public JButton     wrap,insert;

    //pravi prozor
   public void sklstFm()
    {
        JFrame frame = new sklstF();
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setVisible(true);
        frame.setSize(500,700);
        setTitle("Stanje u Skladištu");
        Container cp = getContentPane();

        textArea = new JTextArea(32,32);
        scrollPane = new JScrollPane(textArea);
        // po defaultu ContentPane ima  BorderLayout manager
        cp.add(scrollPane, BorderLayout.CENTER);
               
        buttonPanel = new JPanel();
        insert = new JButton("Osvježi");
        buttonPanel.add(insert);

        cp.add(buttonPanel, BorderLayout.SOUTH); 
        insert.addActionListener(this); 
        frame.add(cp);
    }

public void actionPerformed(ActionEvent e) {
//unosi podatke u bazu podataka
if (e.getSource () == insert)
{ BufferedReader citac = new BufferedReader (new InputStreamReader (System.in));
textArea.setText("");
textArea.append("\t\tPopis Skladišta");
textArea.append("\n\n\tKod");
textArea.append("\tKolicina");
textArea.append("\tVrijednost jednog artikla\n");
for(int i=0;i<inicijaliziranje.brp;i++) { textArea.append("\n"+i+".\t"+inicijaliziranje.a[i]+"\t"+inicijaliziranje.b[i]+"\t"+Math.round(inicijaliziranje.c[i]*100.0)/100.0+"\t"); } }
}}