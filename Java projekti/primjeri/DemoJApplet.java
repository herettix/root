import java.awt.*;
import javax.swing.*;

public class DemoJApplet extends JApplet
{
    JTextArea messages = new JTextArea(8, 30);
    JScrollPane pane   = new JScrollPane(messages);
    int i=0;
  
    public DemoJApplet() 
    { i++; messages.append(i+": Constructor called\n"); }
      
    public void init() 
    {
      add(pane); i++;
      messages.append(i+": Init called\n");
    }
  
    public void start()
    {i++; messages.append(i+": Start called\n"); }

    public void stop() 
    {i++; messages.append(i+": Stop called\n"); }

    public void destroy() 
    {i++; messages.append(i+": Destroy called\n"); }
  
    public void paint(Graphics g) 
    {
      super.paint(g);
      i++;  
      messages.append(i+": Paint called\n");
    }
}
