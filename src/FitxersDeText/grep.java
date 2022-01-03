/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package FitxersDeText;

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author marck
 */
public class grep {
    public static void main(String[] args) {
        int count = 0;
        String param = args[0];
        System.out.println(param);
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
