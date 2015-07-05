//sifriranje texta po pomaku U:text,pomak I:sifrirana rijec
public class zadatak_15 {
public static String sifre(String a,int x) {
int i,j=0,tem,p=0;
char [] c= new char [26];
String t,s="";
for(i=65;i<91;i++) 
{ c[j]=(char) i; j++; }
for(i=0;i<a.length();i++)
{ char t2=a.charAt(i);
for(j=0;j<26;j++)
{ if(t2==c[j]) { p=j+x; if(p>26) p%=26; t2=(char) c[p]; break; } }
s=s+t2; }  return s;}}