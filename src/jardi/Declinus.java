package jardi;

import java.io.Serializable;

/**
 * La classe Declinus defineix un tipus concret de planta.
 */
public class Declinus extends Planta implements Serializable{
	/**
	 * Pel funcionament de la Declinus és important saber si la planta
	 * es troba en el seu cicle de creixement o de decreixement. Aquest
	 * atribut informa d'aquesta circumstància.
	 */
	private boolean ascendeix = true;
	/**
	 * La declinus creix un cop cada dos torns. Aquest atribut val true
	 * quan és el torn de crèixer i false quan no.
	 */
	private boolean tocaCreixer = false;
	/**
	 * La declinus ascendeix fins a alçada 4 i després torna de decrèixer.
	 * El creixement/decreixement es produeix un cop cada dos torns. I
	 * produeix dues llavors, una cada torn en què està a alçada 4.
	 * 
	 * @return  una llavor de declinus si l'alçada de la planta és 4. null en
	 * cas contrari.
	 */
	@Override
	public Llavor temps() {
		Llavor l = null;
		
		if (tocaCreixer) {
			if (ascendeix) {
				if (getAltura() < 4)
					altura++;
				else
					ascendeix = false;
			} else {
				if (getAltura() >= 0)
					altura--;
				else
					viva = false;
			}
		}
		tocaCreixer = !tocaCreixer; // creix un de cada dos torns

		if (getAltura() == 4)
			l = new Llavor(new Declinus()); // creem una llavor de declinus
		return l;
	}

	/**
	 * La flor de la declinus es representa amb el caràcter * i la tija amb :
	 */
	@Override
	public char getChar(int altura) {
		char c = ':';
		
		if (altura >= getAltura())
			c = ' ';
		if (altura == getAltura() - 1)
			c = '*';
		return c;
	}

}
