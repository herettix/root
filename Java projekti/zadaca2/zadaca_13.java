/*Napiši metodu čiji će ulazni parametri biti dvoznamenkasti prirodan broj n. Metoda treba
vratiti broj n ispisan riječima.*/
public class zadaca_13
{ public static String dvo(int x)
{ 
  int d=x%10;
  int p=x/10;
  String a,b;
  
  switch(d) {
      case 1: a="jedan";
              break;
      case 2: a="dva";
              break;
      case 3: a="tri";
              break;
      case 4: a="cetri";
              break;
      case 5: a="pet";
              break;
      case 6: a="sest";
              break;
      case 7: a="sedam";
              break;
      case 8: a="osam";
              break;
      case 9: a="devet";
              break;
      default: a="";
              break; }
       
      switch(p) {
      case 1: b="deset";
              break;
      case 2: b="dvadeset";
              break;
      case 3: b="trideset";
              break;
      case 4: b="cetrdeset";
              break;
      case 5: b="pedeset";
              break;
      case 6: b="sesdeset";
              break;
      case 7: b="sedamdeset";
              break;
      case 8: b="osamdeset";
              break;
      case 9: b="devedeset";
              break;
      default: b="";
              break; }
if(x>11 && x<20)
{ b="naest"; return a+b; }
if(x==11)
return "jedanaest";
else
return b +" "+ a;}}              
              