/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Examples;

import java.io.FileWriter;
import java.io.IOException;

/**
 *
 * @author marck
 */
public class Escrifitxer {
    public static void main(String[] args) {
    String[] provincies = {"Barcelona", "Girona", "Lleida", "Tarragona"};
    String nomFitxer = "C:\\Users\\marck\\Desktop\\.dat";
    try (FileWriter escriptor =new FileWriter(nomFitxer);) {
            for (String provincia : provincies) {
                escriptor.append(provincia).write('\n');
            }
    } catch (IOException e) {
            System.err.println(e.getMessage());
    }
    }

}
