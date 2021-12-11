package jardi;

import java.util.Random;

/**
 * La classe Planta és la superclasse per a tots aquells elements del jardí
 * que són plantes. La classe Planta treballa conjuntament amb la classe Llavor
 * per aconseguir simular la dinàmica de les plantes: les plantes generen llavors
 * i les llavors tornen a generar plantes del mateix tipus.
 * 
 * Aquesta classe defineix comportaments per defecte de les plantes, que poden
 * ser sobreescrits per les classes derivades per adaptar els comportaments de
 * cada espècie.
 *
 */
public abstract class Planta implements ElementJardi {
	/**
	 * Aquest objecte random es comparteix entre totes les plantes i
	 * permet generar els nombres aleatoris necessaris.
	 */
	private static final Random random = new Random();
	/**
	 * Indica si la planta està viva o morta. Quan la planta estigui morta
	 * es traurà del jardí.
	 */
	protected boolean viva = true;
	/**
	 * L'alçada actual de la planta.
	 */
	protected int altura;

	/**
	 * Comportament per defecte de les plantes a mida que passa el temps.
	 * Una planta assoleix un d'alçada cada vegada que es crida aquest mètode, fins
	 * a un màxim de 10. Quan s'intenta sobrepassar aquest màxim, la planta mor.
	 * 
	 * No es retorna mai cap llavor, sinó que cada subclasse ha de decidir en quines
	 * circumstàncies ho farà.
	 * 
	 * @return  Retorna sempre null. Fixeu-vos en com és vàlid posar com a valor de
	 * retorn Llavor en comptes d'ElementJardi. Això és lògic perquè una planta només
	 * pot crear llavors, i és legal a nivell de llenguatge perquè totes les Llavors
	 * són sempre ElementJardi (ja que Llavor implementa ElementJardi).
	 */
	@Override
	public Llavor temps() {
		if (altura < 10)
			altura++;
		else
			viva = false;
		return null;
	}
	
	/**
	 * Per defecte, una planta llançarà les seves llavors a distància 1 o 2, 
	 * cap a la dreta o cap a l'esquerra.
	 * 
	 * @return  Un nombre aleatori entre -2, -1, 1 i 2.
	 */
	@Override
	public int escampa() {
		int signe = 2 * random.nextInt(2) - 1;
		int lloc = random.nextInt(2) + 1;
		return signe * lloc;
	}
	/**
	 * Retorna l'alçada actual de la planta.
	 * 
	 * @return  l'alçada actual de la planta.
	 */
	public int getAltura() {
		return altura;
	}

	@Override
	public boolean isViva() {
		return viva;
	}
}
