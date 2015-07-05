// U: n(clan fibonac. niza) I: koji je to broj
public class zadaca_9 {
public static int fibo(int n) {
int br=3,a1=1,a2=1,temp=0;
while(br<=n) {
temp=a1+a2;
a1=a2;
a2=temp;
br++; }
return temp;} }