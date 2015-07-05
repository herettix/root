//16.U:rijec zapisana zamjenskim znakovima I: stvaran broj slova
//LJ,NJ=isto ć,đ=c-,d- č,š,ž,dž--> c=,s=,z=,dz=
public class zadatak_16 {
public static int zamjenski_znakovi(String  s) {
s=s.replaceAll("LJ","L");
s=s.replaceAll("NJ","N");
s=s.replaceAll("C-","C");
s=s.replaceAll("C=","C");
s=s.replaceAll("S=","S");
s=s.replaceAll("Z=","Z");
s=s.replaceAll("D-=","D");
s=s.replaceAll("DZ=","D");
return s.length(); }}


