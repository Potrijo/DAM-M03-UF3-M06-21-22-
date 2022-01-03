/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package FitxersDeText;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.LineNumberReader;
import java.nio.file.DirectoryIteratorException;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 *
 * @author marck
 */
public class VersioNoTanSimpleGrep {
    public static void main(String[] args) {
        boolean correcte;
        int i;
        Path path;

        if (args.length >= 2) {
                // Separem casos
                path = Paths.get(args[1]);
                if (Files.isDirectory(path) && args.length == 2) {
                        // primera sintaxi
                        try (DirectoryStream<Path> stream = Files.newDirectoryStream(path)) {
                                for (Path file: stream) {
                                        if (Files.isRegularFile(file))
                                                grep(args[0], file);
                                }
                        } catch (IOException | DirectoryIteratorException ex) {		    
                                System.err.println(ex);
                        }
                } else {
                        correcte = true;
                        i = 1;
                        while (i < args.length && correcte) {
                                path = Paths.get(args[i]);
                                if (!Files.isRegularFile(path))
                                        correcte = false;
                                i++;
                        }
                        if (correcte) {
                                // segona sintaxi
                                for (i = 1; i < args.length; i++) {
                                        path = Paths.get(args[i]);
                                        grep(args[0], path);
                                }
                        } else {
                                System.err.println("Sintaxi: GrepNoTanSimple cadena directori");
                                System.err.println("Sintaxi: GrepNoTanSimple cadena fitxer...");
                        }
                }
        } else {
                System.err.println("Sintaxi: GrepNoTanSimple cadena directori");
                System.err.println("Sintaxi: GrepNoTanSimple cadena fitxer...");
        }

    }

    public static void grep(String cadena, Path path) {
            String linia;
            try (LineNumberReader lector = new LineNumberReader(new FileReader(path.toString()))) {
                    while ((linia = lector.readLine()) != null) {
                            if (linia.contains(cadena))
                                    System.out.println(path.getFileName() + ":" + (lector.getLineNumber() + 1) + ":" + linia);
                    }
            } catch (FileNotFoundException e) {
                    System.err.println("No s'ha pogut accedir al fitxer: " + e.getMessage());
            } catch (IOException e) {
                    System.err.println("Error en la lectura: " + e.getMessage());
                    e.printStackTrace();
            }
    }

}
