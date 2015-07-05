//5.Ivica i igra lovca
public class zadatak_5 {
public static int ivica(int n,int m) {
int i=0,izb=0,temp=n-1;
int [] a = new  int[n];
for(i=0;i<n;i++)
{ a[i]=i+1; }
while(n>1){ 
for(i=1;i<=m;i++){
if(izb>temp) izb=1;
if(a[izb]!=0) { izb++; if(izb>temp) izb=1;  } 
else{ while(a[izb]==0) { izb++; if(izb>temp) izb=1; } } }
a[izb]=0;
izb++;
n--; }
int max=a[0];
for(i=0;i<temp;i++) 
{ if(a[i]>=max) max=a[i]; }
return max; }}