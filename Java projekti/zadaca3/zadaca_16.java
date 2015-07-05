//U: broj n I:a)zbr. svih znamenaka b) max. znamenka
public class zadaca_16 {
public static String znamenke(int x) {
int i,y=x,zbr=0,max=0,temp;
while(y>0) {
temp=y%10;
if(temp>=max)
max=temp;
zbr=zbr+temp;
y/=10; }
return "zbroj znamenaka je "+zbr+", a najveca znamenka je "+max; }}