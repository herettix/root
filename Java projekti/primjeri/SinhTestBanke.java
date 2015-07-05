import java.text.*;

public class SinhTestBanke
{
    public static void main(String[] args)
    {
        Banka b = new Banka(BrRACUNA, INICIJALNI_SALDO);

        for(int i=0; i<BrRACUNA; ++i)
        {
            RandomTransfer r = new RandomTransfer(b,i,INICIJALNI_SALDO);
          //  RandomTransfer r = new RandomTransfer(b,i,2000); 
            Thread         t = new Thread(r);
            t.start();
        }
    }
    // Ukupan broj računa u Banci
    public static final int    BrRACUNA         = 20;
    // Inicijalni saldo svakog pojedinog računa
    public static final double INICIJALNI_SALDO = 1000;
}
       
class Banka
{
    public Banka(int brRacuna, double inicijalniSaldo)
    {
        racun = new double[brRacuna];
        for(int i=0; i<racun.length; ++i) racun[i] = inicijalniSaldo;
    }

    public synchronized void transfer(int from, int to, double iznos) 
                             throws InterruptedException
    {
        while (racun[from] < iznos) wait();

        NumberFormat nf = NumberFormat.getCurrencyInstance();
        
        System.out.print(Thread.currentThread()+" ");
        racun[from] -= iznos;
        System.out.print(nf.format(iznos) + " s "+from+" na "+to);
        racun[to] += iznos;
        System.out.println(": Ukupni saldo = "+ nf.format(ukupniSaldo()));
        notifyAll();
    }

    public synchronized double ukupniSaldo()
    {
        double suma = 0.0;
        for(int i=0; i<racun.length; ++i) suma += racun[i];
        return suma;
    }
    
    public int size() { return racun.length; }
    
    // racun[i] = saldo i-tog racuna
    private final double[] racun;
}

class RandomTransfer implements Runnable
{
    public RandomTransfer(Banka b, int from, double max)
    {
        banka     = b;
        this.from = from;
        maxIznos  = max;
    }

    public void run()
    {
        try
        {
            while(true)
            {
                int to = (int)(banka.size() * Math.random());
                double iznos = maxIznos * Math.random();
                banka.transfer(from, to, iznos);
                Thread.sleep((int) (10*Math.random()));
            }
        }
        catch(InterruptedException e) {}
    }
            
    private Banka banka;
    private int from;
    private double maxIznos;
}
