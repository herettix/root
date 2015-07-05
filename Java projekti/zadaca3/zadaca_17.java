//U: br. zapisan u (2), I: vr. zapisan u (10)
public class zadaca_17 {
public static double binarni_u_dekadski(int n) {
int i=0;
double broj=0;
while(n>0) {
broj=broj+n%10*Math.pow(2,i);
n/=10; i++; }
return broj; }
public static String dekadski_u_binarni(int x) {
String by=Integer.toBinaryString(x);
return by; }} 
