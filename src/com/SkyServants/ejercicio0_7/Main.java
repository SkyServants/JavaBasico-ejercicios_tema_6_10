package com.SkyServants.ejercicio0_7;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Vector;

public class Main {

    public static void main (String[] args){

        //Desarrollo del taller del ejercicio 6-9 (clases 7-10)

        //0. dada la funcion reverse, escribe el codigo que devuelva una cadena de texto al reves

        String palabraInicial =  "Alexander Mendivelo Peñaranda";
        String palabraReverse = reverse(palabraInicial);
        System.out.println("Palabra invetida con la funcion reverse: " + palabraReverse);
        System.out.println("Palabra invetida con la funcion reverse2: " + reverse2(palabraInicial));


        //1.Array unidimensional de Strings, recorrerlo y mostrar sus valores

        String[] nombres = {"Alexandra","Karime","Marcela","Laura","Karina","Maria"};

        for(String nombre: nombres)
        {
            System.out.println(nombre);
        }

        //2.Array bidimensional de enteros, recorrerlo, mostrar sus valores y posicion en ambas dimensiones

        int[][] enteros = {
                {1,10,15,12,1,25},
                {22,23,24,25,26,31}
        };

        for(int i = 0; i < enteros.length; i++ )
        {
            for(int k=0; k < enteros[i].length; k ++){


                System.out.println("número de fila: " + i +" " + "número de columna: " + k);
                System.out.println( "valor: " + enteros[i][k]);
            }
        }


        //3. Crear vector de 5 elementos, eliminar el 2do y 3er valor e imprimir

        Vector<Integer> vectorNumeros =  new Vector<>();

        vectorNumeros.add(1);
        vectorNumeros.add(2);
        vectorNumeros.add(3);
        vectorNumeros.add(4);
        vectorNumeros.add(5);

        vectorNumeros.remove(1);
        vectorNumeros.remove(1);

        System.out.println("Vector: " + vectorNumeros + " " +"Capacidad: "+vectorNumeros.capacity());

        /*
        //4.Indica cual es el problema de utilizar un vector con la capacidad por defecto
        //Si tuvieramos 1000 elementos para añadir al mismo.

        //Teniendo un vector "vacio" obtenemos que la capacidad por defecto es igual a 10
        */
        Vector<Integer> datos = new Vector<>();

         System.out.println("Capacidad por defecto: " + datos.capacity());
         /*
        El problema de trabajar directamente con esta capacidad es cuando el vector sobrepase
        el valor por defecto, (en su numero de elementos) de manera automatica este se duplica.
        esto lleva a consumir muchos recursos porque durante el proceso se crea una copia
        temporal del vector. por lo tanto se tendria un vector con la capacidad inicial y
        otro con la nueva capacidad mientras los datos se cargan de uno a otro.
        (Esto evidenciaria en vectores de gran tamaño), los programadores con mas experiancia
        sugieren que la capacidad del vector tienda a poseer un valor aproximado al la cantidad de datos
        con la que se va a trabajar, a su vez definir el parametro de incremento del vector.
        si la cantidad de datos tuviera que llegar a 1000 el vector deberia modificar su capacidad
        varias veces antes de llegar a 1000.

        Ejemplo:
        */

        for(int i=0; i < 11; i++)
        {
            datos.add(i);
        }

        System.out.println("Capacidad inicial 10 sobrepasada: " + datos.capacity() +" -Vector "+ datos);


        Vector<Integer> datos2 = new Vector<>(10, 2);

        for(int i=0; i < 1000; i++)
        {
            datos2.add(i);
        }
        System.out.println("vector con 15 datos y una capacidad de: " + datos2.capacity() +" -Vector "+ datos2);


        //5. ArrayList tipo String 4 elementos, copiarlo en un linkedList, recorrer ambos mostrando sus valores.

        ArrayList<String> listaArray = new ArrayList<>();

        listaArray.add("Johanna");
        listaArray.add("Angela");
        listaArray.add("Sandra");
        listaArray.add("Danna");

        System.out.println(listaArray);

        LinkedList<String> listaEntrelazada= new LinkedList<>(listaArray);

        System.out.println(listaEntrelazada);

        System.out.println("ArrayList");

        for (String valor : listaArray) {

            System.out.println(valor);

        }

        System.out.println("LinkedList");
        for(int i= 0; i< listaEntrelazada.size();i++){ //El IDE me aconseja cambiar el for por un "ForEach"

            System.out.println(listaEntrelazada.get(i));
        }

        //6. ArrayList tipo int/ bucle para rellenar 10 elementos/recorrer y eliminar pares/ mostrar resultado

        ArrayList<Integer> listaArray2 = new ArrayList<>();


        for(int i = 0; i < 10; i++)
        {
            listaArray2.add(i+1);
            System.out.println(listaArray2.get(i));


        }

        for(int i = 0; i < listaArray2.size(); i++)
        {


            if(listaArray2.get(i) % 2 == 0)
            {
                System.out.println("Se eliminan los numeros pares: "+ listaArray2.get(i));

                listaArray2.remove(listaArray2.get(i));

            }

        }

        System.out.println("ArrayList final " + listaArray2);

        for(Integer valor: listaArray2){

            System.out.println(valor);
        }


        // 7. Funcion DividePorCero/ generar una excepcion con throws con ArithmeticException

        int resultado;

        try{
            resultado = DividePorCero(10,10);
           System.out.println("Resultado de realizar la divison: "+ resultado);
       } catch(ArithmeticException e)
        {
            System.out.println("Se debe modificar el valor del divisor por un numero valido");
        }




    }

    //0. funcion reverse ("Solucion" a la que llegue )

    public static String reverse(String texto){

       char[]  palabraInicial =  texto.toCharArray();

              String palabraInvertida = "";
        //bucle ue recorre el Array de caracteres de menor a mayor.
        for(int i = texto.length() - 1 ; i >= 0; i--){

            //System.out.println("palabra invertida: " + palabraInicial[i]);
            palabraInvertida += palabraInicial[i]; //El IDE me recomienda crear un StringBuilder y no hacer esto;

        }

        return palabraInvertida;
    }


    //0.1. Solucion propuesta por el IDE al corregir los Warnings de mi codigo.
    public static String reverse2(String texto){

        char[]  palabraInicial =  texto.toCharArray();
        StringBuilder palabraInvertida = new StringBuilder();//El IDE me recomienda StringBuilder.

        for(int i = texto.length() - 1 ; i >= 0; i--){

            palabraInvertida.append(palabraInicial[i]); //y aplicar este metodo

        }
        return palabraInvertida.toString();
    }

    // 7. Funcion DividePorCero/ generar una excepcion con throws con ArithmeticException

    public static int DividePorCero (int dividendo, int divisor) throws ArithmeticException
    {
        int resultado;

        try{
            resultado = dividendo/divisor;

        }catch(ArithmeticException e)
        {
            System.out.println("El parametro divisor no puede ser cero");
            throw new ArithmeticException();
        }
        finally
        {
            System.out.println("Codigo ejecutado: funcion: DividirPorCero");
        }

        return resultado;
    }

    //8.funcion recibirficheros



}

