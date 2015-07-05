//4.U: koef. polinoma, točka I: rezultat u toj točki
public class zadatak_4 {
public static double polinom(int a[],int x) {
double rje=0;
for(int i=0;i<a.length;i++)
{ rje=rje + (double)a[i]*Math.pow(x,i); }
return (int)rje; }}

