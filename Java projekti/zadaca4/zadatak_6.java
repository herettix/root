//6.U: matrica I: zbr svih pozitzivnih el. u matrici
public class zadatak_6 {
public static int zbr_poz_matrica(int a[][]) {
int i,j,zbr=0; 
for(i=0;i<a.length;i++)
  for(j=0;j<a.length;j++) 
{ if(a[i][j]>0) zbr=zbr+a[i][j]; }
return zbr; }}