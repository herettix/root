//17.tezina rijeci
public class zadatak_17 {
public static int tezina(String a) {
int i,j=0,zbr=0;
char [] c= new char [26];
int [] br= new int [26];
for(i=65;i<91;i++) 
{ c[j]=(char) i; j++; }
for(i=0;i<a.length();i++)
 for(j=0;j<26;j++) 
{ if(c[j]==a.charAt(i)) br[j]++; if(br[j]>1) br[j]=br[j]*br[j];}
 for(j=0;j<26;j++) 
zbr=zbr+br[j];
return zbr; }}