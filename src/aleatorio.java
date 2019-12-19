
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.Scanner;

/**
 *
 * @author Shalc
 */
public class aleatorio {

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int opcion = -1;
        do {
            System.out.print("=== Menú principal===\n1. Insertar nota\n2. Ver número de registros\n0. Salir\nElige una opción:");
            opcion = sc.nextInt();
            switch (opcion) {
                case 1:
                    System.out.print("Inserte nota 1:");
                    int nota1 = sc.nextInt();
                    System.out.print("Inserte nota 2:");
                    int nota2 = sc.nextInt();
                    System.out.print("Inserte nota 3:");
                    int nota3 = sc.nextInt();
                    insertaRegistro(nota1, nota2, nota3);
                    break;
                case 2:
                    System.out.println("El número de registros es: " + vernreg());
                default:
                    sc.close();
                    System.exit(0);
                    break;
            }

        } while (opcion != 0);

    }

    static int insertaRegistro(int nota1, int nota2, int nota3) throws IOException {
        RandomAccessFile f = new RandomAccessFile("sharonAleatorio.txt", "rw");
        //colocamos el puntero al final del archivo para no reescribir
        f.seek(f.length());
        //grabamos los datos al archivo
        f.write(nota1);
        f.write(nota2);
        f.write(nota3);
        int tamaño = 3;
        int numReg = (int) (f.length() / tamaño);
        System.out.println("Tamaño del archivo: " + f.length());
//		System.out.println("el numero de registros es: "+numReg);
        f.close();
        return numReg;

    }

    static int vernreg() throws IOException {
        RandomAccessFile f = new RandomAccessFile("sharonAleatorio.txt", "r");
        int tamaño = 3;
        int numReg = (int) (f.length() / tamaño);
//		System.out.println("el numero de registros es: "+numReg);
        f.close();
        return numReg;
    }

}
