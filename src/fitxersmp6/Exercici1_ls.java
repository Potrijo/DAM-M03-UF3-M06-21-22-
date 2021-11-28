/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fitxersmp6;

//import java.io.File;

import java.io.File;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 *
 * @author marck
 */
public class Exercici1_ls {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        String[] paths;
            try{
                if(args.length==1){
                    Path path = Paths.get(args[0]);
                System.out.println("Enter Path direction: ");
                String pathName = "C:\\Users\\marck\\"+path; // keeping  the path name with inserted as argument
                File directory = new File(pathName);
                paths = directory.list();// Directory created by File instance, which assigns a path name
                    for(String file: paths){
                        File d = new File(pathName+"\\"+file);
                            if(d.isDirectory()) System.out.print("d-");                    
                            else    System.out.print("-");
                            if(d.canRead()) System.out.print("-r");
                            else    System.out.print("-");
                            if(d.canWrite())    System.out.print("-w");
                            else    System.out.print("-");
                            if(d.canExecute())  System.out.print("-x");
                            else    System.out.print("-");
                            
                            System.out.println(" "+file);
                    }
                }
            }
            catch (NullPointerException e){                     // In case file doesn't find any file
                System.out.println("Incorrect path, try again");
            }       
    }
    
}
