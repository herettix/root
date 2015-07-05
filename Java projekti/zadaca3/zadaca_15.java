/*U: 2 prirodna broja N i M
I: mjera pomocu euklidovog algoritma Primjerice
ako su zadani brojevi 24 i 18, budući da brojevi nisu 
jednaki, njihova je mjera jednaka mjeri brojeva 6 (24 - 18) 
i 18. Budući da brojevi i dalje nisu jednaki, mjera je 
jednaka mjeri brojeva 6 i 12 (18 - 6)*/
public class zadaca_15
{ public static int euklid(int x, int y) {
int temp1=Math.abs(x-y),temp2=y;
if(x==y)
return x;
while(temp1!=temp2) {
if(temp1==temp2)
return temp1;
temp2=temp2-temp1; } 
return temp1; } }