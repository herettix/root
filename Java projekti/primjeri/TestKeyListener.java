import java.awt.event.*;
import javax.swing.*;

public class TestKeyListener
{
    public static void main(String[] args)
    {
        MyFrame frame = new MyFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE );
        frame.setVisible(true);
    }
}

// Svaka komponenta moľe biti KeyListener pa stoga 
// nećemo kreirati panel već će frame sluąati tastaturu.
class MyFrame extends JFrame  implements KeyListener
{
    public MyFrame()
    {
        setTitle("Skupljam ulaz s tastature");
        setSize(300,200);
        addKeyListener(this);
    }


    public void keyTyped(KeyEvent e)
    {
        char c = e.getKeyChar();
        System.out.println("keyTyped : znak = "+c);
    }
    public void keyReleased(KeyEvent e)
    {
        int kod = e.getKeyCode();
        System.out.println("keyReleased: kod = "+kod);
    }
    public void keyPressed(KeyEvent e)
    {
        int kod = e.getKeyCode();
        System.out.println("keyPressed : kod = "+kod);
        if(kod == KeyEvent.VK_SHIFT) 
            System.out.println("keyPressed : SHIFT pritisnut.");
        if(kod == KeyEvent.VK_C && e.isShiftDown() && e.isControlDown())
             System.out.println("keyPressed : SHIFT_CTRL_C pritisnut");

    }

}
