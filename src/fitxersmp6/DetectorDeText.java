/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fitxersmp6;

import static fitxersmp6.GeneraCodiSecret.NewFile;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 *
 * @author marck
 */
public class DetectorDeText {
    public static void main(String[] args) {
        CreateFile();
        readFile();
    }

    
    public static void CreateFile(){
        byte edat = 15;
        short segonsMinut = 60;
        int segonsHora = 3600;
        float pi = 3.14159F;
        double sqrtDos = 1.414;
        char metres = 'm';
        String acceleracio = "m/s^2";

        try (DataOutputStream escriptor = new DataOutputStream(new FileOutputStream("C:\\Users\\marck\\Desktop\\dadesLap.bin"));) {
                escriptor.writeByte(edat);
                escriptor.writeShort(segonsMinut);
                escriptor.writeInt(segonsHora);
                escriptor.writeFloat(pi);
                escriptor.writeDouble(sqrtDos);
                escriptor.writeChar(metres);
                escriptor.writeChars(acceleracio);
        } catch (FileNotFoundException ex) {
                System.err.println(ex);
        } catch (IOException ex) {
                System.err.println(ex);
        }
    }
    
    public static void readFile(){
        byte edat;
        short segonsMinut;
        int segonsHora;
        float pi;
        double sqrtDos;
        char metres;
        char[] acceleracio = new char[5];
 
        try (DataInputStream lector = new DataInputStream(new FileInputStream("C:\\Users\\marck\\Desktop\\dadesLap.bin"));) {
                edat = lector.readByte();
                segonsMinut = lector.readShort();
                segonsHora = lector.readInt();
                pi = lector.readFloat();
                sqrtDos = lector.readDouble();
                metres = lector.readChar();
                for (int i=0;i<5;i++)
                        acceleracio[i]=lector.readChar();

                System.out.format("%s", new String(acceleracio));
        } catch (FileNotFoundException ex) {
                System.err.println(ex);
        } catch (IOException ex) {
                System.err.println(ex);
        }

    }
}
