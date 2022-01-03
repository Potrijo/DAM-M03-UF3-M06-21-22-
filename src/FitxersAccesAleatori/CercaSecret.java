/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package FitxersAccesAleatori;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.Scanner;
/**
 *
 * @author marck
 */
public class CercaSecret {

	public static void trobaCodi(String nomFitxer, int codi) {
		int nRegistres;
		int regBaix;
		int regAlt;
		int regMitja;
		int codiLlegit;
		String secret;
		boolean trobat = false;

		try (RandomAccessFile raf = new RandomAccessFile(nomFitxer, "rw")) {
			nRegistres = (int) raf.length();
			regBaix = 0;    // Inici l'arxiu
			regAlt = nRegistres - 1; // final del l'arxiu 
			// calculem registre a accedir
			while (regBaix <= regAlt && !trobat) {
				regMitja = regAlt/2;
				// comprovem registre
				raf.seek(regMitja);
				codiLlegit = raf.readInt();
				if (codiLlegit == codi) {
					secret = "" + raf.readChar() + raf.readChar() + raf.readChar();
					trobat = true;
					System.out.println("El secret corresponent al codi " + codi + " és " + secret);
				} else if (codiLlegit > codi) {
					regAlt = regMitja - 1;
				} else { // codiLlegit en cas de ser < que codi
					regBaix = regMitja + 1;
				}
			}
			if (!trobat)
				System.out.println("Code not found " + codi);
		} catch (FileNotFoundException e) {
			System.err.println("File not found" + e.getMessage());
		} catch (IOException e) {
			System.err.println("Log into Error" + e.getMessage());
		}
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Codi a cercar?");
		try {
			String sNum = sc.nextLine();
			trobaCodi("C:\\Users\\marck\\Desktop\\dades.bin", Integer.parseInt(sNum));
		} catch (NumberFormatException e) {
			System.err.println("Introdueix un nom");
		}
		sc.close();
	}
}
