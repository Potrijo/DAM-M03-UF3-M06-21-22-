package jardi;

/**
 * Aquesta interfície defineix els mètodes mínims que ha de tenir qualsevol
 * element del jardí. Fixeu-vos com gràcies a l'ús d'aquesta interfície
 * hem aconseguit que Jardi no depengui de cap classe, com Planta o Llavor.
 */
public interface ElementJardi {
	/**
	 * Aquest mètode retorna el caràcter que s'ha de printar per aquest element
	 * a l'altura especificada. Per exemple, per una planta, es retornaria el
	 * caràcter corresponent a la flor si es demana la mateixa altura que
	 * l'alçada de la planta. Si l'altura demanada és menor, es retornaria el
	 * caràcter corresponent a la tija, i si és major, es retornaria un espai.
	 * 
	 * @param altura  Altura per la qual es vol saber el caràcter a escriure.
	 * @return  El caràcter que s'ha d'escriu a l'altura especificada per aquest
	 * element del jardí.
	 */
	public char getChar(int altura);
	/**
	 * El mètode temps es crida cada vegada que es necessita que aquest element
	 * actuï en el jardí. En general, en aquest mètode les plantes creixeran,
	 * i potser moriran. Si l'element genera un altre element, aquest s'haurà
	 * de retornar.
	 * 
	 * @return  Un nou element que s'hagi creat, o null si no s'ha creat cap
	 * element.
	 */
	public ElementJardi temps();
	/**
	 * Retorna si aquest element ha de seguir al jardí o no.
	 * 
	 * @return  true si es vol que aquest element segueixi al jardí, false si
	 * s'ha de retirar.
	 */
	public boolean isViva();
	/**
	 * Si aquest element en crea un altre, es pot cridar aquest mètode per saber
	 * a quina posició s'hauria de situar, respecte a la posició que ocupa aquest
	 * element. Per exemple, si el nou element ha d'anar a la mateixa posició,
	 * aquest mètode retornaria 0. Si retorna 1, significa que el nou element va
	 * una posició cap a la dreta d'aquest.
	 * 
	 * @return  La quantitat d'espais on situar un nou element al jardí respecte
	 * a la posició d'aquest element.
	 */
	public int escampa();
}
