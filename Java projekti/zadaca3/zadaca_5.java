/*U:n. I: a)true ako je broj prost inače false
b) true ako je broj savrsen inace false*/
public class zadaca_5 {
public static boolean prost(int x) {
double k=(double)Math.sqrt(x);
for(int i=2;i<=(int)k;i++) 
{ if(x%i==0)
return false; }
return true; }

public static boolean savrseni_skugor(int y) {
int zbr=0;
for(int i=1;i<y;i++) 
{ if(y%i==0)
zbr=zbr+i; }
if(y==zbr)
return true;
else return false; }}