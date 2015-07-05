/*u: M i N, I:   mjera brojeva n i m, najveći 
zajednički djelitelj brojeva n i m.*/ 
public class zadaca_6 { 
public static int maxdije(int x,int y)
{ int i,max=Math.max(x,y),dije=0;
for(i=1;i<=max;i++)
{ if(x%i==0 && y%i==0)
 dije=i; }
return dije; }}