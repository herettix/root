#include <reg51.h>

void ispis (unsigned char,unsigned char);

void sat(void) interrupt 1 using 1 {
	static int br_ulaza=0;
	static int sekundi=0;

	br_ulaza++;	

	if(br_ulaza == 14) {
		sekundi++;
		if (sekundi > 99) { 
			sekundi = 0;
		}
		ispis('l', (sekundi / 10) + 48);
		ispis('d', (sekundi % 10) + 48);
		br_ulaza=0;
	}
}