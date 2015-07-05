#include <stdio.h>
#include <reg51.h>

sbit grijalica = P1^3;

void ispis (unsigned char, unsigned char);
void PisiControl (unsigned char);
void PisiKomandu (unsigned char);
int CitajTemp (void);

main() {
	bit bdata kvar=0; 
	volatile unsigned char xdata *mem; 
	unsigned char vtest; 
	int temp;

	TMOD = 0x20; 
	TH1 = 0xF4; 
	TL1 = 0xF4;
	TR1 = 1;
	SCON = 0x52; 
	
	printf("Zadatak 3 uspjesno napravljen.\n\n");

	for (mem = 0x0000; mem <= 0x7FFF; mem++) { 
		*mem = 0xAA; 
		vtest = *mem; 
		if (vtest != 0xAA) {
			kvar=1;
			break; 
		}
	}

	if (kvar == 0) {
		printf("Memorija je ispravna.\n\n");
	} else {
		printf("Memorija nije ispravna.\n\n");
	}

	//ispis('l','4');
	//ispis('d','5');

	PisiControl(0x02);
	PisiKomandu(0xEE);

	TMOD = 0x21;
	TL0  = 0x00;
	TH0  = 0x00;
	PT0  = 0;
	ET0  = 1;
	EA   = 1;
	TR0  = 1;

	while(1) {		
		temp = CitajTemp() / 2;	 
		printf("Izmjerena je temperatura od %d stupnjeva.\n\n",temp);
		if(temp < 30) { 
			grijalica = 0; 
		}
		if(temp > 32) { 
			grijalica = 1; 
		}
	}
}

void ispis (unsigned char izbor, unsigned char broj) {
	unsigned char xdata *pok;

	if (izbor == 'l') { 
		pok = 0x8000; 
	}	
	else if (izbor == 'd') { 
		pok = 0x8001; 
	} 

	switch (broj) {						   
		case '0': *pok = 0x77; break;	
		case '1': *pok = 0x14; break;
		case '2': *pok = 0xB3; break;
		case '3': *pok = 0xB6; break;
		case '4': *pok = 0xD4; break;
		case '5': *pok = 0xE6; break;
		case '6': *pok = 0xE7; break;
		case '7': *pok = 0x34; break;
		case '8': *pok = 0xF7; break;
		case '9': *pok = 0xF6;
	}
}