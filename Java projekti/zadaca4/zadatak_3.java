//U:niz[6] I: min element
public class zadatak_3 {
public static int min_element(int a[]) 
{ int i,min=a[0];
for(i=0;i<a.length;i++) 
{ if(a[i]<=min) min=a[i]; }
return min;} }
