/*Za godinu ćemo reći da je prijestupna 
ako je djeljiva s 4 i nije djeljiva sa 
100 ili je djeljiva s 400. Napiši metodu 
čiji će ulazni parametar biti godina n, a 
metoda će vračati odgovarajuću poruku 
("Godina je prijestupna" odnosno "Godina 
nije prijestupna").*/
public class zadaca_6 {
public static String godina(int x)
{ if((x%4==0 && x%100!=0) || x%400==0)
 return "Godina je prijestupna";
 else
 return "Godina nije prijestupna"; }}
