package jardi;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Scanner;

/**
 * A la classe Principal creem un jardí, hi posem alguna planta,
 * i fem passar un torn cada cop que l'usuari introdueix una línia
 * de text.
 */
public class Principal implements Serializable{
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
	public static void main(String[] args) throws IOException, FileNotFoundException {
		try{
                    new Principal();
                }
                catch(ClassNotFoundException e){
                    System.out.println("Class not found");
                }
	}

	/**
	 * S'inicialitza el jardí, i es demana entrada a l'usuari. Cada línia que
	 * s'introdueix avança un torn el jardí. Si l'usuari introdueix la cadena
	 * "surt" s'acaba el programa.
	 */
	public Principal() throws IOException, FileNotFoundException, ClassNotFoundException {
            Jardi j = (Jardi) carregaJardi();
		Scanner sc = new Scanner(System.in);
		String ordre = "";
		j.posaElement(new Altibus(), 10);
		j.posaElement(new Declinus(), 30);
		String nomFitxer = "C:\\Users\\marck\\Desktop\\provincies.dat";
		while (!ordre.equals("surt")) {
			j.temps();
			System.out.println(j.toString());
			ordre = sc.nextLine();
                        
                        guardarPartidaAnterior(j);
		}
		sc.close();
	}
        
        public static void guardarPartidaAnterior(Object jardi) throws ClassNotFoundException{
        try {
            FileOutputStream file = new FileOutputStream("C:\\Users\\marck\\Desktop\\file.dat");
            ObjectOutputStream output = new ObjectOutputStream(file);

            // Writing to the file using ObjectOutputStream
            output.writeObject(jardi);

            FileInputStream fileStream = new FileInputStream("C:\\Users\\marck\\Desktop\\file.dat");
            // Creating an object input stream
            ObjectInputStream objStream = new ObjectInputStream(fileStream);

            // Using the readObject() method
            System.out.println("String data: " + objStream.readObject());

            output.close();
            objStream.close();
        }
        catch (Exception e) {
            e.getStackTrace();
        }
        }
        
        public static Object carregaJardi() throws FileNotFoundException, IOException, ClassNotFoundException{
            FileInputStream fileStream = new FileInputStream("C:\\Users\\marck\\Desktop\\file.dat");
            // Creating an object input stream
            ObjectInputStream objStream = new ObjectInputStream(fileStream);
            Object obj = objStream.readObject();
            return obj;
        }

}
