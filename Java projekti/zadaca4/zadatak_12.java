//U:rijec,I:(palidrom?) true ili false
public class zadatak_12 {
public static boolean palindrom(String a) {
String pal="";
for(int i=a.length();i>0;i--)
{ String temp=a.substring(i-1,i);
pal=pal+temp; }
return a.equals(pal); }}