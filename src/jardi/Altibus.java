package jardi;

/**
 * La classe Altibus defineix un tipus de planta.
 */
public class Altibus extends Planta {
	/**
	 * L'altibus funciona com qualsevol altra planta, amb l'excepció
	 * que produeix llavors quan la seva alçada és superior a 7.
	 * 
	 * @return  null si l'alçada de la planta és 7 o menys. Una nova llavor
	 * d'altibus si l'alçada és superior a 7.
	 */
	@Override
	public Llavor temps() {
		Llavor l = null;
		
		super.temps(); // així reciclem el comportament implementat a Planta.
		if (getAltura() > 7)
			l = new Llavor(new Altibus()); // creem una llavor d'altibus
		return l;
	}

	/**
	 * La flor de l'altibus es representa amb O, i la tija amb |.
	 */
	@Override
	public char getChar(int altura) {
		char c = '|';
		
		if (altura >= getAltura())
			c=' ';
		if (altura == getAltura() - 1)
			c='O';
		return c;
	}

}
