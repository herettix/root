import java.awt.event.*;
 import java.awt.*;
  import javax.swing.*;

  public class TestJComponents
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

     JButton    ok = new JButton("OK");
          JButton    ccl= new JButton("cancel");

          JPanel south = new JPanel();
          south.add(ok);
          south.add(ccl);
         add(south, BorderLayout.SOUTH);

          JPanel center = new JPanel(new GridLayout(2,1));
         center.add(jtf);
          center.add(jlb);
          add(center, BorderLayout.CENTER);

          ccl.addActionListener(new ActionListener()
                  {
                      public void actionPerformed(ActionEvent e){
                          System.exit(0);
                      }
                  });
          ok.addActionListener(new ActionListener()
                  {
                    public void actionPerformed(ActionEvent e){
                          String tekst = jtf.getText().trim();
                          jlb.setText(tekst);
                      }
                  });

      }
  }