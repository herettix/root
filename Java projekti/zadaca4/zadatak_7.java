//7. Ukvadratna matrica I: a) zbr glavne dijagonale b) umno sporedne
public class zadatak_7 {
static int i,j,zbr=0,umn=1;
public static int gl_a(int a[][]) { 
for(i=0;i<a.length;i++)
  for(j=0;j<a.length;j++)
  { if(i==j) zbr=zbr+a[i][j]; }
  return zbr; }
public static int sp_b(int b[][]) { 
for(i=0;i<b.length;i++)
  for(j=0;j<b.length;j++)
{ if((i+j)==(b.length-1)) umn=umn*b[i][j]; }
return umn; } }