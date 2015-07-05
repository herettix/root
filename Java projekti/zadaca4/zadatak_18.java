////18.U: string od slova i znamenaka, i: najmanji broj u stringu
public class zadatak_18
{ public static int minbrstring(String a) {
int i=0,br=0,j=0,zbrm=0;
int poc[]=new int[10];
int kraj[]=new int[10];
char x,y=' ';
String z1="1000000",z2="1000000",z3="1000000",zu="";
a=a+" a";
for(i=0;i<a.length()-1;i++) {
x=a.charAt(i); 
if((int)x>=45 && (int)x<=57) { poc[br]=i; 
for(j=i+1;j<a.length()-1;j++)
{ y=a.charAt(j); 
if((int)y<48 || (int)y>57)
{ kraj[br]=j;  br++; break;}i=j; } } } 
if(poc[0]>=0 && kraj[0]>=0)
z1=a.substring(poc[0],kraj[0]);
if(z1.equals(zu)==true) z1="100000";
if(poc[1]>=0 && kraj[1]>=0)
z2=a.substring(poc[1],kraj[1]);
if(z2.equals(zu)==true) z2="100000";
if(poc[2]>=0 && kraj[2]>=0)
z3=a.substring(poc[2],kraj[2]);
if(z3.equals(zu)==true) z3="100000";
zbrm=Integer.parseInt(z1);
if(Integer.parseInt(z2)<zbrm) zbrm=Integer.parseInt(z2);
if(Integer.parseInt(z3)<zbrm) zbrm=Integer.parseInt(z3);
return zbrm; }}