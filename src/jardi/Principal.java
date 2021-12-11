package jardi;

import java.util.Scanner;

/**
 * A la classe Principal creem un jardí, hi posem alguna planta,
 * i fem passar un torn cada cop que l'usuari introdueix una línia
 * de text.
 */
public class Principal {
	/**
	 * El jardí que es crea, de mida 40.
	 */
	private Jardi jardi = new Jardi(40);

	/**
	 * El main es limita a crear un objecte de tipus Principal. El
	 * constructor d'aquest objecte fa la resta. Això és habitual, com
	 * que treballem amb un objecte, evita haver de declarar la resta de
	 * propietats i mètodes de la classe com static.
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		new Principal();
	}

	/**
	 * S'inicialitza el jardí, i es demana entrada a l'usuari. Cada línia que
	 * s'introdueix avança un torn el jardí. Si l'usuari introdueix la cadena
	 * "surt" s'acaba el programa.
	 */
	public Principal() {
		Scanner sc = new Scanner(System.in);
		String ordre = "";
		jardi.posaElement(new Altibus(), 10);
		jardi.posaElement(new Declinus(), 30);
		
		while (!ordre.equals("surt")) {
			jardi.temps();
			System.out.println(jardi.toString());
			ordre = sc.nextLine();
		}
		sc.close();
	}

}
