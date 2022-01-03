/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package FitxersDeText;

import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 *
 * @author marck
 */
public class versioSimpleTee {
    public static void main(String[] args) {
        int n;
        char c;
        if (args.length == 1) {
            try (InputStreamReader lector = new InputStreamReader(System.in);
                            FileWriter escriptor = new FileWriter(args[0])) {
                    while ((n = lector.read()) != -1) {
                            c = (char) n;
                            System.out.print(c);
                            escriptor.write(n);
                    }
            } catch (IOException e) {
                    System.err.println("Error d'escriptura: " + e.getMessage());
            }
        } else {
            System.err.println("Sintaxi: Tee fitxer");
        }
    }

}
