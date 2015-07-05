import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Kalkulator
{
    public static void main(String[] args)
    {
        KalkulatorFrame frame = new KalkulatorFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}

class KalkulatorFrame extends JFrame
{
    public KalkulatorFrame()
    {
        setTitle("Kalkulator");
        Container cp = getContentPane();
        KalkulatorPanel panel = new KalkulatorPanel();
        cp.add(panel);
        // Izračunaj veličinu prozora
        pack();
    }
}

class KalkulatorPanel extends JPanel
{
    private boolean start;
    private String lastCommand;
    private double result;
    private JPanel panel;
    private JButton display;

    public KalkulatorPanel()
    {
        // U konstruktoru konstruiramo interface
        setLayout(new BorderLayout());

        // Inicijalizacija
        result = 0;
        lastCommand = "=";
        start = true;

        display = new JButton("0");
        display.setEnabled(false);   // sluľi samo za prikaz rezultata
        add(display, BorderLayout.NORTH);

        // ActionListener za brojke
        ActionListener insert  = new InsertListener();
        // ActionListener za operacije
        ActionListener command = new CommandListener();

        panel = new JPanel();
        // 4 x 4 grid
        panel.setLayout(new GridLayout(4,4));

        addButton("7",insert);
        addButton("8",insert);
        addButton("9",insert);
        addButton("/",command);

        addButton("4",insert);
        addButton("5",insert);
        addButton("6",insert);
        addButton("*",command);

        addButton("1",insert);
        addButton("2",insert);
        addButton("3",insert);
        addButton("-",command);

        addButton("0",insert);
        addButton(".",insert);
        addButton("=",command);
        addButton("+",command);

        add(panel,BorderLayout.CENTER);
    }

    private void addButton(String label, ActionListener listener)
    {
        JButton botun = new JButton(label);
        panel.add(botun);                 
        botun.addActionListener(listener);
    }

    private class InsertListener implements ActionListener
    {
        public void actionPerformed(ActionEvent e)
        {
            String input = e.getActionCommand(); // daje labelu botuna
            if(start)
            {                        // Tek smo počeli
                display.setText(""); // očisti display
                start=false;
            }
            // dodaj novi tekst na stari
            display.setText(display.getText()+input);
        }
    }

    private class CommandListener implements ActionListener
    {
        public void actionPerformed(ActionEvent e)
        {
            String command = e.getActionCommand(); // daje labelu botuna

            if(start)
            {
                if(command.equals("-")) // unarni minus
                {
                     display.setText(command);
                     start=false;
                }
                else
                {
                    lastCommand=command;
                }
            }
            else
            {
                calculate(Double.parseDouble(display.getText()));
                lastCommand = command;
                start=true;  // novi početak
            }
        }
    }

    public void calculate(double x)
    {
        if(lastCommand.equals("+")) result += x;
        else if(lastCommand.equals("-")) result -= x;
        else if(lastCommand.equals("*")) result *= x;
        else if(lastCommand.equals("/")) result /= x;
        else if(lastCommand.equals("=")) result = x;
        display.setText(""+result);

    }
}
