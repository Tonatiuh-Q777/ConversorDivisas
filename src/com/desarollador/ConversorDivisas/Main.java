package com.desarollador.ConversorDivisas;

import java.text.DecimalFormat;
import java.util.Locale;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        DecimalFormat decimal = new DecimalFormat("#.00");
        Scanner lectura = new Scanner(System.in);
        ConsultaDivisa consulta = new ConsultaDivisa();
        String linea = """
                ***********************************************************************
                """;
        String menu = """
                Elija una opcion valida para realizar la conversion: 
                1) Dólar =>> Peso Argentino
                2) Peso Argentino =>> Dólar
                3) Dólar =>> Real Brasileño
                4) Real Brasileño =>> Dólar
                5) Dólar =>> Peso Colombiano
                6) Peso Colombiano =>> Dólar
                7) Dólar =>> Peso Méxicano
                8) Peso Méxicano =>> Dólar
                9) Conversion libre (Requiere 3 letras por código de país)
                0) SALIR
                """;
        System.out.println(linea);
        System.out.println("BIENVENIDO/A AL SISTEMA DE CONVERSION DE DIVISAS DE BANCOMEX\n");
        System.out.println(menu);
        int seleccion = lectura.nextInt();
        while (seleccion!=0){
            double dinero;
            switch (seleccion){
                case 1:
                    System.out.println("Escriba la cantidad que quiere convertir:");
                    dinero = lectura.nextDouble();
                    Divisa divisa = consulta.buscaDivisa("USD","ARS");
                    dinero = dinero * divisa.conversion_rate();
                    System.out.println("El resultado de la conversion es: $"+decimal.format(dinero));
                    System.out.println(linea+menu);
                    seleccion = lectura.nextInt();
                    break;
                case 2:
                    System.out.println("Escriba la cantidad que quiere convertir:");
                    dinero = lectura.nextDouble();
                    divisa = consulta.buscaDivisa("ARS","USD");
                    dinero = dinero * divisa.conversion_rate();
                    System.out.println("El resultado de la conversion es: $"+decimal.format(dinero));
                    System.out.println(linea+menu);
                    seleccion = lectura.nextInt();
                    break;
                case 3:
                    System.out.println("Escriba la cantidad que quiere convertir:");
                    dinero = lectura.nextDouble();
                    divisa = consulta.buscaDivisa("USD","BRL");
                    dinero = dinero * divisa.conversion_rate();
                    System.out.println("El resultado de la conversion es: $"+decimal.format(dinero));
                    System.out.println(linea+menu);
                    seleccion = lectura.nextInt();
                    break;
                case 4:
                    System.out.println("Escriba la cantidad que quiere convertir:");
                    dinero = lectura.nextDouble();
                    divisa = consulta.buscaDivisa("BRL","USD");
                    dinero = dinero * divisa.conversion_rate();
                    System.out.println("El resultado de la conversion es: $"+decimal.format(dinero));
                    System.out.println(linea+menu);
                    seleccion = lectura.nextInt();
                    break;
                case 5:
                    System.out.println("Escriba la cantidad que quiere convertir:");
                    dinero = lectura.nextDouble();
                    divisa = consulta.buscaDivisa("USD","COP");
                    dinero = dinero * divisa.conversion_rate();
                    System.out.println("El resultado de la conversion es: $"+decimal.format(dinero));
                    System.out.println(linea+menu);
                    seleccion = lectura.nextInt();
                    break;
                case 6:
                    System.out.println("Escriba la cantidad que quiere convertir:");
                    dinero = lectura.nextDouble();
                    divisa = consulta.buscaDivisa("COP","USD");
                    dinero = dinero * divisa.conversion_rate();
                    System.out.println("El resultado de la conversion es: $"+decimal.format(dinero));
                    System.out.println(linea+menu);
                    seleccion = lectura.nextInt();
                    break;
                case 7:
                    System.out.println("Escriba la cantidad que quiere convertir:");
                    dinero = lectura.nextDouble();
                    divisa = consulta.buscaDivisa("USD","MXN");
                    dinero = dinero * divisa.conversion_rate();
                    System.out.println("El resultado de la conversion es: $"+decimal.format(dinero));
                    System.out.println(linea+menu);
                    seleccion = lectura.nextInt();
                    break;
                case 8:
                    System.out.println("Escriba la cantidad que quiere convertir:");
                    dinero = lectura.nextDouble();
                    divisa = consulta.buscaDivisa("MXN","USD");
                    dinero = dinero * divisa.conversion_rate();
                    System.out.println("El resultado de la conversion es: $"+decimal.format(dinero));
                    System.out.println(linea+menu);
                    seleccion = lectura.nextInt();
                    break;
                case 9:
                    System.out.println("Escriba las divisas que quiere convertir"+
                            "\n(debe de se de acuerdo con el codigo de moneda de 3 letras de ISO 4217)");
                    lectura.nextLine();
                    try{
                        var tipoDivisa1 = lectura.nextLine().toUpperCase();
                        var tipoDivisa2 = lectura.nextLine().toUpperCase();
                        divisa= consulta.buscaDivisa(tipoDivisa1, tipoDivisa2);
                        System.out.println("Escriba la cantidad que quiere convertir:");
                        dinero = lectura.nextDouble();
                        dinero = dinero * divisa.conversion_rate();
                        System.out.println("El resultado de la conversion es: $"+decimal.format(dinero));
                        System.out.println(linea+menu);
                        seleccion = lectura.nextInt();
                    } catch (Exception e) {
                        System.out.println("Error en la aplicacion");
                        System.out.println(linea+menu);
                        seleccion = lectura.nextInt();
                    }
                    break;
            }
        }
        System.out.println("GRACIAS POR USAR NUESTROS SERVICIOS :)");
    }
}
