/*U: a i b(prva 2 člana niza) te n br članova niza
I:a) zbroj n članova aritmetičkog B) geometrijskog niza*/
public class zadaca_7 {
static double sn,an;
public static double arniz(int a1,int a2,int n)
{ int d=a2-a1;
an=a1+(n-1)*d;
sn=(double)n/2*(a1+an);
return sn;}
public static double geoniz(int x,int y,int n)
{ int q=y/x;
an=x*(double)(Math.pow(q,n-1));
sn=x*((Math.pow(q,n)-1)/(q-1));
return sn;}}