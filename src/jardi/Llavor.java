package jardi;

/**
 * Aquesta classe modelitza la llavor de qualsevol planta.
 * 
 * Per evitar haver de crear una classe de llavor diferent per a cada tipus de planta,
 * s'ha fet que una llavor guardi una referència a un objecte Planta del tipus concret
 * a què pertany aquesta llavor. Aquest objecte Planta serà la planta que germinarà
 * de la llavor quan aquesta maduri, i també ens permet delegar alguna operació
 * que depèn del tipus de planta. D'aquesta manera només caldrà crear classes
 * per llavors específiques quan tinguin un comportament diferent a la major part
 * de llavors.
 * 
 */
public class Llavor implements ElementJardi {
	/**
	 * Aquesta planta serà la que germinarà d'aquesta llavor.
	 */
	private Planta planta;
	/**
	 * Temps de vida de la llavor. Quan arriba a 5, la llavor germina.
	 */
	private int temps = 0;
	/**
	 * Indica si la llavor és viva o no. La llavor està viva fins que germina.
	 */
	private boolean viva = true;
	/**
	 * El constructor de llavor rep una planta, que serà la nova planta que
	 * germinarà quan la llavor maduri.
	 * 
	 * @param p  Planta que ha de sorgir d'aquesta llavor.
	 */
	public Llavor(Planta p) {
		planta = p;
	}
	/**
	 * La llavor romandrà viva durant cinc torns. Després, naixerà la
	 * planta que té a dins (la retornarà) i la llavor morirà.
	 * 
	 * @return  null mentre la llavor segueixi viva, la planta que ha
	 * de nèixer quan la llavor mor.
	 */
	@Override
	public Planta temps() {
		Planta p = null;
		temps++;
		if (temps == 5) {
			p = planta;
			viva = false;
		}
		return p;
	}
	/**
	 * La llavor sempre té alçada 0. Retorna '.' si es demana l'alçada 0
	 * i espai si es demana qualsevol altra alçada.
	 * 
	 * @param altura  l'alçada per la qual es vol conèixer el caràcter que
	 * s'ha d'escriure per la llavor.
	 */
	@Override
	public char getChar(int altura) {
		char c = ' ';
		if (altura == 0)
			c = '.';
		return c;
	}

	@Override
	public boolean isViva() {
		return viva;
	}
	
	@Override
	public int escampa() {
		return 0;
	}
}
