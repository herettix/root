/*U: paran broj n I:broj načina na koje se n
može prikazati kao zbroj dvaju prostih brojeva. */
public class zadaca_10 {
public static int brprost(int x) {
int bp=0,bp2=0,i,j,k,l,temp1=0,bg=0,temp2=0;
for(i=2;i<=x;i++) { 
for(j=2;j<=i;j++)
if(i%j==0) bp++;
if(bp<=2)
temp1=i;
bp=0;
for(k=2;k<=x;k++) { 
for(l=2;l<=k;l++)
if(k%l==0) bp2++;
if(bp2<=2)
temp2=k;
bp2=0; 
if((temp1+temp2)==x) { bg++; temp1=0; temp2=0; }}}
return Math.round((float)bg/2); }}