package com.SkyServants.ejercicio8;

import java.io.*;

public class Main {
    public static void main(String[] args) {

        //8. Funcion que reciba parametros fileIn, fileOut /realice copia del fichero in al fichero out.

        //Parametros de la funcion
        String fileIn = "C:/Users/Alexander/IdeaProjects/JavaBasico_ejercicios_tema_6_10/fileIn.txt"; //Modificable
        String fileOut = "fileOut.txt";

        recibirDatos(fileIn,fileOut);

        //TERMINA EL JERCICIO NUMERO 8


        //Codigo para leer los datos del fichero fileOut (No hace parte de la solucion del ejercio)
        try{
            InputStream file = new FileInputStream(
                    "C:/Users/Alexander/IdeaProjects/JavaBasico_ejercicios_tema_6_10/fileOut.txt");

            BufferedInputStream fileBuffer = new BufferedInputStream(file);

            try{
                int  fileDatosIn = fileBuffer.read();

                while(fileDatosIn != -1){

                    System.out.print((char)fileDatosIn);
                    fileDatosIn = fileBuffer.read();
                }

            }catch(Exception e){

                System.out.println("No se peude leer el fichero: " + e.getMessage());
            }
        }catch (FileNotFoundException e){

            System.out.println("Error del programa: "+  e.getMessage());
        }



    }

    public static void recibirDatos(String fileIn, String fileOut)
    {
        try{

            InputStream file1 = new FileInputStream(fileIn);
            byte[] datosFile1 = file1.readAllBytes();
            file1.close();

            PrintStream file2 = new PrintStream(fileOut);
            file2.write(datosFile1);
            file2.close();
            System.out.println("Se han copiado los datos del fichero In al fichero out: ");

        }catch (Exception e){

            System.out.println("Error del programa revisar parametros: " +  e.getMessage());

        }


    }
}
