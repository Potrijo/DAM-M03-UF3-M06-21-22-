/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package FitxersAccesAleatori;

import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author marck
 */
public class Exercici2_SobrescrituraDePaisos {

	private static String readChars(RandomAccessFile fitxer, int nChars) throws IOException {
		StringBuilder b = new StringBuilder();
		char ch = ' ';
		for (int i=0; i<nChars; i++) {
			ch=fitxer.readChar();
			if (ch != '\0')
				b.append(ch);
		}
		return b.toString();
	}

	public static void main(String[] args) {
                Pais nouPais;
                Scanner input = new Scanner(System.in);
                ArrayList<Pais> paisos = new ArrayList<Pais>(); // Create an ArrayList object
		Pais p;
		String nom, capital, codiISO;
		int poblacio;
		try (RandomAccessFile fitxer = new RandomAccessFile("C:\\Users\\marck\\Desktop\\paisos.dat", "r");) {
			while (fitxer.getFilePointer() != fitxer.length()) {
				System.out.println("País: "+fitxer.readInt());
				nom = readChars(fitxer, 40);
				codiISO = readChars(fitxer, 3);
				capital = readChars(fitxer, 40);
				poblacio = fitxer.readInt();
				p = new Pais(nom, codiISO, capital);
				p.setPoblacio(poblacio);
                                paisos.add(p);
				System.out.println(p);
			}
                        System.out.println("Entra el número del registre:");
                        int num = input.nextInt();
                        System.out.println("Entra nom país, codi ISO (3 caracters) y la capital:");
                        nouPais = new Pais(input.nextLine(), "HVR", input.nextLine());
                        paisos.remove(num);
                        paisos.add(nouPais);

		} catch (IOException e) {
			System.err.println(e);
		}
                
                try (RandomAccessFile fitxer = new RandomAccessFile("C:\\Users\\marck\\Desktop\\paisos.dat", "rw");) {
                    StringBuilder b = null;
                    for (int i=0; i<paisos.size(); i++) {
                        b = new StringBuilder(paisos.get(i).getNom());
                        b.setLength(40); //Asigna mida de 40 caracters al contingut de StringBuilder
                        fitxer.writeInt(i+1);						//id  ------> int  (4 bytes)
                        fitxer.writeChars(b.toString());			//nom ------> char (2 bytes) * 40 caràcters
                        fitxer.writeChars(paisos.get(i).getCodiISO());	//Codi ISO -> char (2 bytes) * 3 caràcters
                        b = new StringBuilder(paisos.get(i).getCapital());
                        b.setLength(40);
                        fitxer.writeChars(b.toString());			//Capital --> char (2 bytes) * 40 caràcters
                        fitxer.writeInt(paisos.get(i).getPoblacio());	//població -> int  (4 bytes)
                                                                                                    //total per país: 174 bytes
                    } // Total: 174 bytes * 5 països = 870 bytes
		} catch (IOException e) {
			System.err.println(e);
		}
	}
}
