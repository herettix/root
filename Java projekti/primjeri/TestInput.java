import javax.swing.*;

public class TestInput
{
    public static void main(String[] args)
    {
        // najjednostavniji oblik 
        String ime = JOptionPane.showInputDialog("Unesite svoje ime");
        System.out.println("Ime = "+ime);
        
        // S defaultom
        String prezime = JOptionPane.showInputDialog("Unesite svoje prezime", "Anonymous");
        System.out.println("Prezime = "+prezime);

        // S roditeljem, naslovom i tipom poruke
        String nadimak = JOptionPane.showInputDialog(null, "Unesite svoj nadimak", "foo",
                 JOptionPane.QUESTION_MESSAGE);
        System.out.println("Nadimak = "+nadimak);

        String[] izbor = new String[] {"sjever", "jug", "istok", "zapad"};
        String smjer = (String) JOptionPane.showInputDialog(null, "Daj mi smjer", "bar", 
                     JOptionPane.INFORMATION_MESSAGE , null, izbor, "sjever");
        System.out.println("Smjer   = "+smjer );


        int k=JOptionPane.showOptionDialog(null, "OptionDialog", "title",
         JOptionPane.YES_NO_OPTION,  JOptionPane.INFORMATION_MESSAGE , null, izbor, "istok");
        System.out.println("k   = "+k );

        k=JOptionPane.showOptionDialog(null, "OptionDialog", "title",
         JOptionPane.YES_NO_OPTION,  JOptionPane.INFORMATION_MESSAGE , null, null, null);
        System.out.println("k   = "+k );
    }
}
