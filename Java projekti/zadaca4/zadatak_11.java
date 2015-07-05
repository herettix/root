//11.U: riječ I: ta ista riječ sa razmakom nakon svakog slova
public class zadatak_11 {
public static String razmaci_rijec(String a) {
String r=" ",k="";  
for(int i=0;i<a.length();i++)
{ String t=a.substring(i,i+1);
k=k+t+r;}
return k; }}
