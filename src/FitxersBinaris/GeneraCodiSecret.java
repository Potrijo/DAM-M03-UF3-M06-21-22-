/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FitxersBinaris;

import java.io.DataOutputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Random;
/**
 *
 * @author marck
 */
public class GeneraCodiSecret {
    public static void main(String[] args) {
        DataOutputStream file_bin = NewFile();
        NewFile();

    }
    /**
     * Crea Archivo.bin
     */
    public static DataOutputStream NewFile(){
        Random random = new Random();
        int previousNum = 0;
        int currentNum = 0;

        try (DataOutputStream escriptor = new DataOutputStream(new FileOutputStream("C:\\Users\\marck\\Desktop\\dades.bin"));) {
                generarNuevoNum(previousNum, currentNum, escriptor);
                return escriptor;
        } catch (FileNotFoundException ex) {
                System.err.println(ex);
        } catch (IOException ex) {
                System.err.println(ex);
        }
        return null;
    }
    
    public static void generarNuevoNum(int previousNum, int currentNum, DataOutputStream escriptor) throws IOException{
            Random random = new Random();
            for(int i=0; i< 1000; i++){
            currentNum = random.nextInt(3)+1;
            escriptor.writeInt(currentNum + previousNum);
            previousNum = currentNum;                                        
        }
    }
}
