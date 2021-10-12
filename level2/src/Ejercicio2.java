//Crear un ArrayList, agregar 5 números enteros.
//Luego, agregar un número entero al principio de la lista y otro al final.
// Por último, iterar e imprimir los elementos de la lista y el tamaño de la misma
// (antes y después de agregar a en la primera y última posición).

import java.util.ArrayList;
import java.util.Scanner;

public class Ejercicio2 {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        ArrayList<Integer> listaNum = new ArrayList<>();
        listaNum = agregarElementos(listaNum, scan);
        imprimirElementos(listaNum);
        listaNum = agregarInicioFinal(listaNum, scan);
        imprimirElementos(listaNum);
        scan.close();
    }

    public static ArrayList agregarElementos(ArrayList numeros, Scanner scan) {
        for (int i = 1; i <= 5; i++) {
            System.out.println("Ingrese un número entero: ");
            numeros.add(Integer.valueOf(scan.nextLine()));
        }
        return numeros;
    }

    public static void imprimirElementos(ArrayList<Integer> numerosImprimir) {
        for (Integer numero: numerosImprimir) {
            System.out.println(numero);
        }
    }

    public static ArrayList agregarInicioFinal(ArrayList<Integer> listaAAgregar, Scanner scan){
        System.out.println("Ingrese el elemento que quiere agregar al inicio:");
        listaAAgregar.add(0, Integer.valueOf(scan.nextLine()));
        System.out.println("Ingrese el elemento que quiere agregar al final: ");
        listaAAgregar.add(Integer.valueOf(scan.nextLine()));
        return listaAAgregar;
    }

}
