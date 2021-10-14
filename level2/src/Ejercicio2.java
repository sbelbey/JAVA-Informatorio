//Crear un ArrayList, agregar 5 números enteros.
//Luego, agregar un número entero al principio de la lista y otro al final.
// Por último, iterar e imprimir los elementos de la lista y el tamaño de la misma
// (antes y después de agregar a en la primera y última posición).

import java.util.List;
import java.util.ArrayList;
import java.util.Scanner;

public class Ejercicio2 {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        List<Integer> listaNum = new ArrayList<>();
        agregarElementos(listaNum, scan);
        imprimirElementos(listaNum);
        agregarInicioFinal(listaNum, scan);
        imprimirElementos(listaNum);
        scan.close();
    }

    public static void agregarElementos(List<Integer> listaNum, Scanner scan) {
        for (int i = 1; i <= 5; i++) {
            System.out.println("Ingrese un número entero: ");
            listaNum.add(Integer.valueOf(scan.nextLine()));
        }
    }

    public static void imprimirElementos(List<Integer> numerosImprimir) {
        for (Integer numero: numerosImprimir) {
            System.out.println(numero);
        }
    }

    public static void agregarInicioFinal(List<Integer> listaNum, Scanner scan){
        System.out.println("Ingrese el elemento que quiere agregar al inicio:");
        listaNum.add(0, Integer.valueOf(scan.nextLine()));
        System.out.println("Ingrese el elemento que quiere agregar al final: ");
        listaNum.add(Integer.valueOf(scan.nextLine()));
    }

}
