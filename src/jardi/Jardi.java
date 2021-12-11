package jardi;

/**
 * La classe Jardi gestiona els elements d'un jardí i permet
 * veure'n l'evolució a mida que passa el temps.
 */
public class Jardi {
	/**
	 * Constant que defineix l'alçada màxima d'un jardí
	 */
	private static final int ALTURA_JARDI = 10;
	/**
	 * Vector amb tots els elements del jardí
	 */
	private ElementJardi[] elements;
	/**
	 * Per facilitar passar el jardí a cadena, aquí es guarda
	 * la línia de terra del jardí.
	 */
	private String terra = "";
	/**
	 * Constructor sense paràmetres. Crea un jardí de mida 10.
	 */
	public Jardi() {
		this(10);
	}
	/**
	 * Constructor amb un paràmetre. Crea un jardí amb la mida especificada.
	 * 
	 * @param mida  Mida que ha de tenir el jardí. Ha de ser un nombre positiu.
	 */
	public Jardi(int mida) {
		/*
		 * Si la mida és incorrecta, creem un jardí de mida 10 i mostrem un error
		 * per pantalla. Més endavant veurem com és millor tractar aquestes
		 * situacions utilitzant excepcions.
		 */
		if (mida <= 0) {
			System.err.println("Jardi: mida incorrecta");
			mida = 10;
		}
		elements = new ElementJardi[mida];
		for (int i = 0; i < mida; i++)
			terra += "_";
	}

	/**
	 * Fa passar el temps per aquest jardí.
	 */
	public void temps() {
		ElementJardi nouElement;
        ElementJardi element;
		int i;
		int lloc;
		
		for (i = 0; i < elements.length; i++) {
			if (elements[i] != null) {
                element = elements[i];
				// fem passar el temps per tots els elements
				nouElement = element.temps();
				// esborrem els elements morts
				if (!element.isViva())
					elements[i] = null;
				// si s'ha creat un nou element, l'intentem posar
				if (nouElement != null) {
					lloc = i + element.escampa();
					posaElement(nouElement, lloc);
				}
			}
		}
	}

	/**
	 * Retorna una cadena multilínia amb una representació del jardí.
	 * 
	 * @return  Una cadena que representa tot el jardí.
	 */
	@Override
	public String toString() {
		int altura, posicio;
		String s = "";
		
		// per crear la cadena comencem per l'alçada màxim i anem baixant
		for (altura = ALTURA_JARDI - 1; altura >= 0; altura--) {
			// per a cada element del jardí...
			for (posicio = 0; posicio < elements.length; posicio++) {
				if (elements[posicio] == null)
					s += ' ';
				else
					// ... afegim el caràcter que correspon a l'alçada actual.
					s += elements[posicio].getChar(altura);
			}
			// salta de línia al final de cada alçada
			s += "\n";
		}
		// a baix de tot afegim la línia de terra
		s += terra;
		return s;
	}

	/**
	 * Intenta posar un nou element al jardí.
	 * 
	 * @param nouElement  Element que es vol posar al jardí
	 * @param pos  Posició en la qual es vol posar el nou element.
	 * @return  true si s'ha pogut posar l'element, false si no. Un element no
	 * es pot posar si la posició indicada no existia al jardí, o si existia però
	 * ja estava ocupada per un altre element.
	 */
	public boolean posaElement(ElementJardi nouElement, int pos) {
		boolean hiHaLloc = false;
		if (pos >= 0 && pos < elements.length && elements[pos] == null) {
			hiHaLloc = true;
			elements[pos] = nouElement;
		}
		return hiHaLloc;
	}
}
