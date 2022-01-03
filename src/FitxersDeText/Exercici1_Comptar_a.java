package FitxersDeText;


import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author marck
 */
public class Exercici1_Comptar_a {

	public static void main(String[] args) {
            int count = 0;
            String nomFitxer = "C:\\Users\\marck\\Desktop\\provincies.txt";
            int lectura;
            char ch;
            StringBuilder s = new StringBuilder();
            List<String> provincies = new ArrayList<String>();
            try (FileReader lector = new FileReader(nomFitxer);) {
                    while ((lectura = lector.read())!=-1) {
                            ch = (char) lectura;
                            if (ch == '\n') {
                                    provincies.add(s.toString());
                                    s.setLength(0);
                            } else {
                                if(ch == 'a'){
                                    count++;
                                    System.out.println(count);
                                }
                                    s.append(ch);
                            }
                    }
                    for (String paco : provincies){
                        System.out.println(paco);
                    }
            } catch (IOException e) {
                    System.err.println(e.getMessage());
            }
	}
}
