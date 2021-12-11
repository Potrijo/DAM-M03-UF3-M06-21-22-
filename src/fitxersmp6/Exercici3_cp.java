/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fitxersmp6;

import java.io.File;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 *
 * @author Jefe Maestro
 */
public class Exercici3_cp {
    public static void main(String[] args) {
            if(args.length==2){
                Path path = Paths.get(args[0]);
                Path pathDestiny = Paths.get(args[1]);
                System.out.println(path);
                File savedFile = new File(path.toString());
                File newFile = new File(pathDestiny.toString());
                savedFile.renameTo(newFile);
                savedFile.deleteOnExit();
            }
    }

}
