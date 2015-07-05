import java.awt.*;
import java.awt.event.*;
public class Prihod
{
	Frame frm = new Frame();
	Label title = new Label("Porezna uprava-kalkulator prihoda");
	Label countyName = new Label("Burlington County");
	Button calcButton = new Button("Izračunaj");
	Button resetButton = new Button("Reset");
	Button eXit = new Button("Izlaz");
	Label prompt = new Label("Unesite svoje ime ===============>");
	Label prompt1 = new Label("Unesite svoje primanje ==============>");
	Label prompt2 = new Label("Broj uzdržavanih osoba ==>");
	TextField taxVal = new TextField(8);
	TextField nameIs = new TextField(8);
	TextField dependYes = new TextField(8);
	Label taxBill = new Label("' -Koliko iznosi Vaš porez? -'");
	Font bigFont = new Font("Helvectia", Font.ITALIC, 16);
	Panel pnlN = new Panel();
	Panel pnlS = new Panel();
	Panel pnlE = new Panel();
	Panel pnlW = new Panel();
	Panel pnlC = new Panel();
WindowListener wl = new WindowAdapter()
		{
			public void windowClosing(WindowEvent ev)
			{
				System.exit(0);
			}
		};
	ActionListener al = new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				if(e.getSource()==calcButton)
				{
					pnlE.add(resetButton);
					boolean wHat, tHaw, notStupi, Fredda;
					String name = new String(nameIs.getText());
					double value = Double.parseDouble(taxVal.getText());
					double tax = .2 * value;
					double aftdeduct = tax - 10000;
					int dependVal = Integer.parseInt(dependYes.getText());
					int dependMinus = 2000 * dependVal;
					int check = -1;
					double finish = aftdeduct - dependMinus;
					double isIt = finish;
					double cLick = -1 * isIt;
					double dumb = -1 * dependVal;
					double Dutch = -1 * isIt;
					notStupi = (dumb <= dependVal);
					Fredda = (Dutch <= isIt);
					tHaw = (isIt - cLick <= isIt);
					wHat = (isIt - cLick >= isIt);
					String checkEr = new String("Dogodila se pogreška.Ne možete imati negativan broj uzdržavanih osoba!");
					String chedda = new String("Dogodila se pogreška.Ne možete imati negativan prihod!");
					if (notStupi)
						checkEr = ("iznosi");
					if (Fredda)
						chedda = ("Vas porez");
					if (tHaw)
						taxBill.setText(""+chedda+" "+checkEr+" "+cLick+"kn,"+name+"!");
					if (wHat)
						taxBill.setText(""+name+", "+chedda+" "+checkEr+" "+isIt+"kn!");
					pnlW.remove(calcButton);
				};
				if(e.getSource()==eXit)
				{
					System.exit(0);
				}
				if(e.getSource()==resetButton)
				{
					taxVal.setText("");
					nameIs.setText("");
					dependYes.setText("");
					taxVal.requestFocus();
					taxBill.setText("' -Koliko iznosi Vaš porez? -'");
					pnlE.remove(resetButton);
					pnlW.add(calcButton);
				}
			}
		};
		public Prihod()
		{
			frm.setLayout(new BorderLayout());
			title.setFont(bigFont);
			countyName.setFont(bigFont);
			calcButton.addActionListener(al);
			resetButton.addActionListener(al);
			eXit.addActionListener(al);
			frm.addWindowListener(wl);
			pnlN.setLayout(new FlowLayout());
			pnlS.setLayout(new FlowLayout());
			pnlE.setLayout(new GridLayout(2,1));
			pnlW.setLayout(new GridLayout(1,1));
			pnlC.setLayout(new GridLayout(3,2));
			pnlN.add(title);
			pnlE.add(eXit);
			pnlE.add(resetButton);
			pnlW.add(calcButton);
			pnlC.add(prompt);
			pnlC.add(nameIs);
			pnlC.add(prompt1);
			pnlC.add(taxVal);
			pnlC.add(prompt2);
			pnlC.add(dependYes);
			pnlS.add(taxBill);
			frm.add(pnlN,BorderLayout.NORTH);
			frm.add(pnlS,BorderLayout.SOUTH);
			frm.add(pnlC,BorderLayout.CENTER);
			frm.add(pnlE,BorderLayout.EAST);
			frm.add(pnlW,BorderLayout.WEST);
			frm.setSize(555,175);
			frm.setVisible(true);
		}
		public static void main(String[] args)
			{
				new Prihod();
			}
}