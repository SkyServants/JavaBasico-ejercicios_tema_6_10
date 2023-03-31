package com.SkyServants.ejercicio9;


import java.io.PrintStream;
import java.util.*;


public class Main {

    public static void main(String[] args) {

        System.out.println("Bienvenido a su solicitud de prestamo con Sky Servants por favor: ");

        double prestamo = 0;
        int tiempo = 0;
        double interesEa = 0;

        try {
            Scanner scanerPrestamo = new Scanner(System.in);
            System.out.println("Ingrese el Valor del prestamo");
             prestamo = Double.parseDouble (scanerPrestamo.next());

            System.out.println("Ingrese el tiempo del prestamo en meses");
             tiempo = Integer.parseInt (scanerPrestamo.next());

            //EA -> efectivo anual
            System.out.println("Ingrese la tasa de interes Efectivo anual en %");
             interesEa = Double.parseDouble(scanerPrestamo.next());
            System.out.println(interesEa);

        }catch (Exception e){

            System.out.println("datos ingresados no son correctos: " + e.getMessage());
        }finally
        {
            System.out.println("Proceso de toma de datos finalizado");
        }

        double valiInteresMensual = tasaInteresMesual(interesEa);
       //valiInteresMensual = 3.21;

        System.out.println("Tasa de interes mensual: "+ valiInteresMensual +"%");

        double cuota = cuotaMensual(valiInteresMensual,prestamo,tiempo);
        System.out.println("Cuota mensual: " +  cuota);



        //mapaPrestamo.put("Mes",0d);

        ArrayList<String>  mes =  new ArrayList<>();
        ArrayList<Double>  valor =  new ArrayList<>();

        for (int i= 0; i < tiempo; i++)
        {

            mes.add("Mes: " + i);
            valor.add(cuota);
        }


        //Collections.sort(valor);
        Collections.sort(mes);


        System.out.println(valor);
        System.out.println(mes);



        double interesCompleto = interesesTotales(cuota,tiempo,prestamo);

        System.out.println("Interes total del prestamo: " + interesCompleto);

        TarjetaCredito(tiempo,prestamo);

        HashMap<String, Double > mapaPrestamo = new HashMap<>();

        mapaPrestamo.put("Monto del prestamo",prestamo);
        mapaPrestamo.put("Duracion del prestamo en meses",(double)tiempo);
        mapaPrestamo.put(" Tasa Interes Efectivo Anual",interesEa);
        mapaPrestamo.put("Tasa Interes Mensual",valiInteresMensual);
        mapaPrestamo.put("Cuota mensual",cuota);
        mapaPrestamo.put("Interes Total",interesCompleto);



        System.out.println(mapaPrestamo.entrySet());


        crearFicheroPrestamo(mapaPrestamo,"DocumentoPrestamo.txt");

    }

    public static double tasaInteresMesual(double interesEa){

        double interesMensual;

        //Formula: TIM = [(1 + TEA/100)^(1/tiempo)] - 1

        double a = (1 + (interesEa/100));

        double b = ((double)1/ 12);

        double c = Math.pow(a,b);

        interesMensual = (c - 1) * 100;

        return interesMensual;
    }

    public static double cuotaMensual (double valInteresMensual, double prestamo, int tiempo){

        double cuota;

        //FORMULA
        //Cuota = [(interes Mensual/100) * prestamo]/[1-((1+(interes Mensual/100)^ -tiempo)]

        double a = ((valInteresMensual)/100);
        double b = ((a) * (prestamo));
        double c = ((1.0+ a));
        double d = Math.pow(c,(-tiempo));

        double e = 1-d;

       cuota = ((b)/(e));


        return cuota;
    }

    public static double interesesTotales(double cuota, int tiempo, double prestamo)
    {
        double interesTotal;

        interesTotal = (cuota * tiempo) - prestamo;

        return interesTotal;
    }

    public static void TarjetaCredito(int tiempo, double prestamo)
    {
       ArrayList<Double> amortizacion = new ArrayList<>();

       double deuda = prestamo;
        double abonoFijoCapital = (deuda/tiempo);

        for(int i= 0; i<tiempo; i++){

            amortizacion.add(deuda -= abonoFijoCapital);
        }

        System.out.println("CON AMORTIZACION: " + amortizacion);

    }

    public static void crearFicheroPrestamo(HashMap<String,Double>fileIn, String fileOut)
    {
        try{

            PrintStream file2 = new PrintStream(fileOut);
            file2.print("Datos del Prestamo:" + " " +  fileIn.entrySet());
            file2.close();
            System.out.println("Se han copiado los datos del fichero In al fichero out: ");

        }catch (Exception e){

            System.out.println("Error del programa revisar parametros: " +  e.getMessage());

        }
    }

}
