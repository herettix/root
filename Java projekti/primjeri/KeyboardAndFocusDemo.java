
/*
   This applet demonstrates Focus events and Key events.  A colored square
   is drawn on the applet.  By pressing the arrow keys, the user can move
   the square up, down, left, or right.  By pressing the keys
   R, G, B, or K, the user can change the color of the square to red,
   green, blue, or black, respectively.  Of course, none of the keys
   will have any effect if the applet does not have the keyboard input
   focus.  The applet changes appearance when it has the input focus.
   A cyan-colored border is drawn around it.  When it doesn not have
   the input focus, the message "Click to activate" is displayed.
*/


import java.awt.*;
import java.awt.event.*;
import java.applet.Applet;


public class KeyboardAndFocusDemo extends Applet 
                  implements KeyListener, FocusListener, MouseListener {
                         // (Note:  MouseListener is implemented only so that
                         //         the applet can request the input focus when
                         //         the user clicks on it.)

   Color squareColor = Color.red;  // The color of the square.
   
   int squareTop, squareLeft;  // Coordinates of the top-left corner of the square.
   
   static final int squareSize = 40;  // Length of a side of the square.
   
   boolean focussed = false;   // This is true when this applet has the input focus.
   
   Image OSC;           // Off-screen image.
   Graphics OSG;        // A graphics context for drawing to OSC.
   int width, height;   // Width and height of applet (OSC is 6 pixels smaller).
                        //    It is assumed that the applet size doesn't change.
                           
                           
   public void init() {
        // Initializew the applet; set it up to receive keyboad
        // and focus events.
      setBackground(Color.white);
      addFocusListener(this);
      addKeyListener(this);
   }
   
   
   public void update(Graphics g) {
        // Redefine update so it doesn't erase the applet before calling
        // paint().
      paint(g);
   }
   
   
   public void paint(Graphics g) {
         // Draw the contents of the applet.

      if (OSC == null) {  // create the OSC; this will only be done once
         width = getSize().width;
         height = getSize().height;
         OSC = createImage(width-6,height-6);
         OSG = OSC.getGraphics();
         squareLeft = width/2 - squareSize/2;
         squareTop  = height/2 - squareSize/2;
      }

      OSG.setColor(Color.white);             // Draw the picture in the OSC
      OSG.fillRect(0,0,width-6,height-6);
      OSG.setColor(squareColor);
      OSG.fillRect(squareLeft,squareTop,squareSize,squareSize);

      g.drawImage(OSC,3,3,this);

      if (focussed)                   // Draw a 3-pixel border.  If the applet
         g.setColor(Color.cyan);      //   has focus, draw it in cyan; otherwise,
      else                            //   draw it in the background color, white.
         g.setColor(Color.white);
      g.drawRect(0,0,width-1,height-1);
      g.drawRect(1,1,width-3,height-3);
      g.drawRect(2,2,width-5,height-5);

      if (!focussed) {                // If the applet does not have the focus,
         g.setColor(Color.magenta);   //    print a message for the user.
         g.drawString("Click to activate",7,20);
      }

   }  // end paint()
   
   
   public void focusGained(FocusEvent evt) {
         // the applet now has the input focus
      focussed = true;
      repaint();  // redraw with cyan border
   }
   
   public void focusLost(FocusEvent evt) {
         // the applet has now lost the input focus
      focussed = false;
      repaint();  // redraw without cyan border
   }
   
   
   public void keyTyped(KeyEvent evt) {
          // The user has typed a character, while the
          // apple thas the input focus.  If it is one
          // of the keys that represents a color, change
          // the color of the square and redraw the applet.
          // (Note: I could just as well have done this
          // in the keyPressed method, by comparing
          // getKeyCode() to KeyEvent.VK_B, etc.)
          
      char ch = evt.getKeyChar();  // the character typed.

      if (ch == 'B' || ch == 'b') {
         squareColor = Color.blue;
         repaint();
      }
      else if (ch == 'G' || ch == 'g') {
         squareColor = Color.green;
         repaint();
      }
      else if (ch == 'R' || ch == 'r') {
         squareColor = Color.red;
         repaint();
      }
      else if (ch == 'K' || ch == 'k') {
         squareColor = Color.black;
         repaint();
      }

   }  // end keyTyped()
   
   
   public void mousePressed(MouseEvent evt) {
        // Request the input focus when the user clicks on
        // the applet.  (On most platforms, there is no need
        // for this.  However, Sun's own Java implementation
        // requires it.)
      requestFocus();
   }   
   
   
   public void keyPressed(KeyEvent evt) { 
          // Called when the user has pressed a key, which can be
          // a special key such as an arrow key.  If the key pressed
          // was one of the arrow keys, move the square (unless moving
          // it would move it off the canvas).
          
      int key = evt.getKeyCode();  // keyboard code for the key that was pressed
      
      if (key == KeyEvent.VK_LEFT) {
         squareLeft -= 8;
         if (squareLeft < 0)
            squareLeft = 0;
         repaint();
      }
      else if (key == KeyEvent.VK_RIGHT) {
         squareLeft += 8;
         if (squareLeft > width - 6 - squareSize)
            squareLeft = width - 6 - squareSize;
         repaint();
      }
      else if (key == KeyEvent.VK_UP) {
         squareTop -= 8;
         if (squareTop < 0)
            squareTop = 0;
         repaint();
      }
      else if (key == KeyEvent.VK_DOWN) {
         squareTop += 8;
         if (squareTop > height - 6 - squareSize)
            squareTop = height - 6 -squareSize;
         repaint();
      }

   }  // end keyPressed()


   public void keyReleased(KeyEvent evt) { 
      // empty method, required by the KeyListener Interface
   }
   
   public void mouseEntered(MouseEvent evt) { }  // Required by the
   public void mouseExited(MouseEvent evt) { }   //    MouseListener
   public void mouseReleased(MouseEvent evt) { } //       interface.
   public void mouseClicked(MouseEvent evt) { }


} // end class KeyboardAndFocusDemo