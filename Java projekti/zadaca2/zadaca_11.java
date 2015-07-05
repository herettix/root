/*U: 2 cijela broja, char sa racunskom operacijom 
'+' '-' '*' '/' I: rezultat određene rač. operacije */
public class zadaca_11 {
public static int operacija(int x,int y,char a)
{ int z=0;
switch(a) {
case '+': z=x+y; break;
case '-': z=x-y; break;
case '*': z=x*y; break;
case '/': z=x/y; break;} 
return z; }}