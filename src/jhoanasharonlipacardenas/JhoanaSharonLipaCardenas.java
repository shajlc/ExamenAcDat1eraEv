/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jhoanasharonlipacardenas;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.Scanner;

/**
 *
 * @author Shalc
 */
public class JhoanaSharonLipaCardenas {

    public static void grabarDatos(String archivo, String datos, boolean modo) {//Creo un metodo
        try {
            FileWriter fw = new FileWriter(archivo, modo);//Me escribe, el true sig que se sobreescriba o se escriba al final
            //Con el true te escribe al final de el archivo y con el false se borra los datos previos
            //append agregar
            BufferedWriter bw = new BufferedWriter(fw);
            bw.write(datos + "\n");
            bw.close();
        } catch (java.io.IOException ioex) {
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Scanner sc2 = new Scanner(System.in);
        int opcion = -1;
        do {
            System.out.print("=== Menú principal===\n1. Leer datos\n2. Insertar datos\n0. Salir\nElige una opción:");
            opcion = sc.nextInt();
            switch (opcion) {
                case 2:
                    boolean modo;
                    System.out.print("¿Quiere escribir al final o sobrescribir?(f/s)");
                    String smodo = sc.next();
                    if (smodo.equals("f")) {
                        modo = true;
                    } else {
                        modo = false;
                    }
                    System.out.print("Introduce el texto a escribir:");
                    String texto = sc2.nextLine();
                    grabarDatos("SecuencialJhoanaSharonLipaCardenas.txt", texto, modo);
                    break;
                case 1:
                    leerDatos("SecuencialJhoanaSharonLipaCardenas.txt");
                default:
                    sc.close();
                    System.exit(0);
                    break;
            }

        } while (opcion != 0);

    }

    public static void leerDatos(String archivo) {
//en archivo almacenamos el nombre del fichero

        String texto = new String();
//texto va a ser la variable donde vamos a ir almacenando el
//contenido del fichero

        try {
            FileReader fr = new FileReader(archivo);
            BufferedReader entrada = new BufferedReader(fr);
            String s;//variable temporal para ir leyendo cadenas de texto
//leemos de manera secuencial línea a línea el contenido del
//fichero, almacenando la línea que se lee en cada pasada del
//bucle en la variable s.
            while ((s = entrada.readLine()) != null) {
                texto += s + "\n";
            }

//mostramos por pantalla el contenido de la variable texto junto
//a su longitud (texto.lenght())
            System.out.println("\nDatos leidos:\n"
                    + texto + "Tamaño del fichero: \n"
                    + +texto.length());
//cerramos la conexión al fichero.
            entrada.close();
        } catch (java.io.FileNotFoundException fnfex) {
            System.out.println("Archivo no encontrado!!!" + fnfex);
        } catch (java.io.IOException ioex) {
        }
    }
}
