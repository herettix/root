import java.awt.event.*;
import java.awt.*;
import javax.swing.*;
import java.io.*;
import java.util.ArrayList; 
import java.lang.Object.*;
import java.util.Date;
import java.util.Vector;
import java.util.*;
import java.util.ArrayList; 
import java.util.*;
import java.text.*;
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

public class Popis extends JFrame implements ActionListener
{
    private JTextArea   textArea;
    private JScrollPane scrollPane;
    private JPanel      buttonPanel;
    public JButton     wrap,insert, btnPregled;

    //pravi prozor
   public void Popis1()
    {
        JFrame frame = new Popis();
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setVisible(true);
        frame.setSize(600,700);
        setTitle("Prijašnji unosi");
        Container cp = getContentPane();

        textArea = new JTextArea(32,32);
        scrollPane = new JScrollPane(textArea);
        // po defaultu ContentPane ima  BorderLayout manager
        cp.add(scrollPane, BorderLayout.CENTER);
               
        buttonPanel = new JPanel();
        insert = new JButton("Osvježi");
        buttonPanel.add(insert);
        
        btnPregled = new JButton("Otvori text file");
        buttonPanel.add(btnPregled);

        cp.add(buttonPanel, BorderLayout.SOUTH); 
        insert.addActionListener(this); 
        frame.add(cp);
    }

public void actionPerformed(ActionEvent e) {
    //unosi podatke u bazu podataka
    if (e.getSource () == insert)
    { 
        try
        {
            BufferedReader citac = new BufferedReader (new InputStreamReader (System.in));
            textArea.setText("");
            textArea.append("\t\tPrijašnji unosi");
            textArea.append("\n\nUnos (kcal)");
            textArea.append("\tTežina(kg)");
            textArea.append("\tVisina(cm)");
            textArea.append("\tDob(god)");            
            textArea.append("\tDatum\n");
            Date datum = new Date();
                for(int i=0;i<inicijaliziranje.brp;i++) 
                { 
                    textArea.append("\n"+inicijaliziranje.kcal1[i]+"\t"+inicijaliziranje.tezina[i]+"\t"+inicijaliziranje.visina[i]+"\t"+inicijaliziranje.dob[i]+"\t"+datum.toString()); 
                } 
            }
        catch (Exception e2)
        {
            e2.printStackTrace();
        }
    }        
}
}