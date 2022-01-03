/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package FitxersDeText;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.DirectoryIteratorException;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;

/**
 *
 * @author marck
 */
public class MiniShell {
    	private Path workingDirectory = Paths.get(System.getProperty("user.dir"));

	public static void main(String[] args) {
		(new MiniShell()).shell();
	}

	public void shell() {
		String command = "";
		String[] parts;
		Scanner sc = new Scanner(System.in);

		while (!command.equals("exit")) {
			System.out.println(workingDirectory.normalize() + "> ");
			command = sc.nextLine();
			parts = command.split("\\s+", 2); // separem el primer espai
			if (parts.length > 0) {
				if (parts[0].equals("ls")) {
					ls();
				} else if (parts[0].equals("cd")) {
					if (parts.length == 2)
						cd(parts[1]);
					else
						System.err.println("cd: falta el directori");
				} else if (parts[0].equals("cat")) {
					if (parts.length == 2)
						cat(parts[1]);
					else
						System.err.println("cat: falta el nom del fitxer a mostrar");
				} else
					System.err.println("No s'entén la comanda");
			}
		}
		sc.close();
	}

	public void ls() {
		try (DirectoryStream<Path> stream = Files.newDirectoryStream(workingDirectory)) {
			for (Path fitxer : stream) {
				System.out.println(fitxer.getFileName() + (Files.isDirectory(fitxer) ? "/" : ""));
			}
		} catch (IOException | DirectoryIteratorException ex) {
			System.err.println(ex);
		}
		System.out.println();
	}

	public void cd(String nomDir) {
		Path path = workingDirectory.resolve(nomDir);
		if (Files.isDirectory(path))
			workingDirectory = path.toAbsolutePath().normalize();
		else
			System.err.println("No es troba el directori");

	}

	public void cat(String nomFitxer) {
		String s;
		Path path = workingDirectory.resolve(nomFitxer);
		try (BufferedReader lector = new BufferedReader(new FileReader(path.toString()))) {
			while ((s = lector.readLine()) != null)
				System.out.println(s);
			System.out.println();
		} catch (FileNotFoundException e) {
			System.err.println("No s'ha trobat el fitxer");
		} catch (IOException e) {
			System.err.println("No es pot llegir el fitxer: " + e.getMessage());
		}
	}
}


