import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class TestWindowListener {
    public static void main(String[] args){
        SmartFrame frame = new SmartFrame();
        frame.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE );
        frame.setVisible(true);
    }
}

class SmartFrame extends JFrame
{
    public SmartFrame()
    {
        setTitle("Prazan prozor !?");
        setSize(300,200);
        WindowListener wl = new Terminator();
        addWindowListener(wl);
    }
}

class Terminator extends WindowAdapter
{
    public void windowClosing(WindowEvent e){
        int i=JOptionPane.showConfirmDialog(null, "Zatvoriti ili ne zatvoriti???",
                                            "Exit", JOptionPane.YES_NO_OPTION,
                                             JOptionPane.WARNING_MESSAGE);
        if(i == JOptionPane.OK_OPTION)
            System.exit(0);
    }
}
