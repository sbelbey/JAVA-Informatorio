//Solicitar por consola el nombre del usuario e
// imprimir por pantalla el siguiente mensaje “HOLA {USUARIO}!!!”

import java.util.Scanner;

public class ejercicio1 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String nombre = scan.nextLine();
        scan.close();

        imprimirNombre(nombre);
    }

    public static void imprimirNombre(String nombreIngresado){
        System.out.println("HOLA " + nombreIngresado);
    }
}
