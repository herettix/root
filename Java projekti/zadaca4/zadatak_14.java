/*kompresirani text=uzastopno ponavljanje zamjenimo znakom i brojkom ponavljanja 
a)U:komp. text I:nekomp. text b)U:nekomp text I:komp. text*/
public class zadatak_14 {
static int i,br=1;
static String t1="",t2,s="";
public static String nekomp(String a) { 
a=a+" ";
for(i=0;i<a.length()-1;i++)
{ t1=a.substring(i,i+1);
t2=a.substring(i+1,i+2);
switch (t2) {
case "1": br=1; break; case "2": br=2; break;
case "3": br=3; break; case "4": br=4; break;
case "5": br=5; break; case "6": br=6; break;
case "7": br=7; break; case "8": br=8; break; 
case "9": br=9; break; }
while(br>0) 
{ s=s+t1; br--; } } return s; }
public static String komp(String b) {
b=b+" ";
for(i=0;i<b.length()-1;i++)
{  t1=b.substring(i,i+1);
t2=b.substring(i+1,i+2);
if(t2.equals(t1)==true) br++; 
else { s=s+t1+br; br=1; }} 
return s;}}