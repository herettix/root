/*Napiši metodu koja će unositi datum roñenja neke osobe te današnji datum (datum se unosi
kao tri broja – dan, mjesec, godina). Metoda treba vračati točnu starost te osobe (u danima).*/
public class zadaca_9 {
public static int operacija(int x,int y,int z,int a,int b,int c)
{
int p=(c-z)/4;
if(c>=2000 && z<=2000) p--;
int g=(c-z)*365;
int m=(b-y)*30;
int d=(a-x);
int u=p+g+m+d;
return u; }}