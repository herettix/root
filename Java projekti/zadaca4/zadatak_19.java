/*19. U: 2 prirodna broja(200 znamenaka) I: njihov zbr,
 napomena tehinčko ograničenje jave je 20 znakova */
public class zadatak_19 {
public static String broja2(String a,String b) {
int i,j,brznakova,br=0,t1=0,t2=0,k=0,l=0;
String s="";
int [] x= new int [251];
int [] y= new int [251];
int [] zbr= new int [201];
brznakova=Math.max(a.length(),b.length());
for(i=0;i<a.length();i++)
{ x[i]=(Integer.parseInt(a.substring(i,i+1))); }
for(i=0;i<b.length();i++)
{ y[i]=(Integer.parseInt(b.substring(i,i+1))); }
for(i=200;i>=0;i--)
{ if(t1==0 && x[i]==0) k=i; else  t1++;  
if(t2==0 && y[i]==0) l=i; else  t2++;   }
for(i=brznakova;i>=0;i--)
{ zbr[i]=x[k]+y[l]; k--; if(k<0) k=250; l--; if(l<0) l=250;}
for(i=0;i<=brznakova-1;i++)
s=s+Integer.toString(zbr[i]); 
return s; }}


