import java.io.*;
import javax.imageio.*;
import java.awt.*;
import javax.swing.*;

public class SlikaTest
{
    public static void main(String[] args)
    {
        SlikaFrame frame = new SlikaFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}

class SlikaFrame extends JFrame
{
    public SlikaFrame()
    {
        setTitle("SlikaTest");
        setSize(DEFAULT_WIDTH, DEFAULT_HEIGHT);

        Container contentPane = getContentPane(); 
        SlikaPanel panel = new SlikaPanel();
        contentPane.add(panel);
    }

    public static final int DEFAULT_WIDTH  = 720;
    public static final int DEFAULT_HEIGHT = 340;
}

class SlikaPanel extends JPanel
{
    public SlikaPanel()
    {
        try
        {
            slika = ImageIO.read(new File("superSlika.jpeg"));
        }
        catch(IOException e) {
            e.printStackTrace();
        }
    }
    
    public void paintComponent(Graphics g)
    {
        super.paintComponent(g);
        if(slika == null) return;

        int imageWidth = slika.getWidth(this);
        int imageHeight = slika.getHeight(this);

        g.drawImage(slika,0,0,null);

        for(int i=0; i*imageWidth <= getWidth(); i++)
           for(int j=0; j*imageHeight <= getHeight(); j++)
               if(i+j>0)
                   g.copyArea(0,0,imageWidth, imageHeight,
                                  i*imageWidth, j*imageHeight); 
                           
    }

    private Image slika;
}

