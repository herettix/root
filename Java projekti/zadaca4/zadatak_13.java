//U: recenica(vise razmaka izmedu rijeci) I: koliko rijeci ima 
public class zadatak_13 {
public static int razmaci(String s) {
int i,br=0;
String t="",k=" ",t2;
for(i=0;i<s.length();i++) {
t2=t;
t=s.substring(i,i+1);
if(t.equals(k)==true)
br++;  
if(t.equals(t2)==true)
br--; }
return br+1; }}