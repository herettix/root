/*u: p(pov. pravokutnika)
i: najmanji mogući opseg pravokutnika*/
public class zadaca_8 {
public static int mino(int p) 
{ int a,b,i,o=10000,tempo;
for(i=2;i<p;i++)
{ if(p%i==0)
{ a=i; b=p/i; tempo=2*a+2*b; 
if(tempo<=o) o=tempo; } }
return o; }}

