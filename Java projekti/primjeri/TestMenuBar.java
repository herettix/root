import java.awt.event.*;
import java.awt.*;
import javax.swing.*;

public class TestMenuBar    
{
    public static void main(String [] args)
    {
        JFrame frame = new TestMenuBarFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}

class TestMenuBarFrame extends JFrame
{
        
    TestMenuBarFrame()
    {
        setTitle("MenuBarTest");
        setSize(300,200);
        Container cp = getContentPane();

        // Kreiramo traku s izbornicima
        JMenuBar  menuBar = new JMenuBar(); 
        setJMenuBar(menuBar);

        // Kreiramo dva izbornika
        JMenu fileMenu = new JMenu("File");
        menuBar.add(fileMenu);

        JMenu editMenu = new JMenu("Edit");
        menuBar.add(editMenu);

        // Dodajmo par itema u fileMenu
        JMenuItem newMenuItem = new JMenuItem("New");
        fileMenu.add(newMenuItem);

        JMenuItem openMenuItem = new JMenuItem("Open");
        fileMenu.add(openMenuItem);
        // Onemogućimo ovaj izbor
        openMenuItem.setEnabled(false);

        // Separirajmo iteme crtom
        fileMenu.addSeparator();

        // Exit item. Umjesto klika miąem moľe se otipkati x
        JMenuItem exitMenuItem = new JMenuItem("Exit", 'X');
        fileMenu.add(exitMenuItem);
    
        exitMenuItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_X, 
                                                       InputEvent.CTRL_MASK));
        // sluąač za exitMenuItem
        exitMenuItem.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                System.exit(0);
            }
        });

        // Dodajmo jedan podizbornik u Edit izbornik
        JMenu optionsMenu = new JMenu("Options");
        editMenu.add(optionsMenu);

        // Dodajmo CheckBox u podizbornik
        JCheckBoxMenuItem readOnly = new JCheckBoxMenuItem("Read-only");
        optionsMenu.add(readOnly);

        // Dodajmo joą dac radio buttona
        optionsMenu.addSeparator();
        ButtonGroup grupa = new ButtonGroup();
        JRadioButtonMenuItem insertItem = new JRadioButtonMenuItem("Insert");
        insertItem.setSelected(true);
        JRadioButtonMenuItem overtypeItem = new JRadioButtonMenuItem("Overtype");
        grupa.add(insertItem);
        grupa.add(overtypeItem);
        optionsMenu.add(insertItem);
        optionsMenu.add(overtypeItem);
    }  
}
