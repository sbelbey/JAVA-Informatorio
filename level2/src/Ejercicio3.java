//Crear una lista que contenga como elementos la numeración de cartas de una baraja francesa
// (solo los valores, no figuras).
// Se deberá cargar el ArrayList (en orden), imprimir, imprimir en orden inverso (reverse),
// desordenar (mezclar) el arrayList y volver a imprimir.

//Ayuda: ArrayList implementa la interface Collection, existe algún método que me permita hacer
// la operación sort (mezclar) aleatoriamente? Idem para el reverso

import java.util.Collections;
import java.util.ArrayList;
import java.util.Scanner;

public class Ejercicio3 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        ArrayList<String> baraja = new ArrayList<>();

        baraja = agregarCartas(baraja, scan);
        imprimir(baraja);
        imprimirInverso(baraja);
        baraja = mezclar(baraja);
        imprimir(baraja);
        scan.close();
    }

    public static ArrayList agregarCartas(ArrayList<String> barajas, Scanner scan){
        for (int i=0; i<=12; i++){
            System.out.print("Ingrese el valor de la carta: ");
            barajas.add(String.valueOf(scan.nextLine()));
        }
        return barajas;
    }

    public static void imprimir(ArrayList<String> baraja){
        for (String carta: baraja){
            System.out.print(carta + " ");
        }
        System.out.println("");
    }

    public static void imprimirInverso(ArrayList<String> baraja){
        Collections.reverse(baraja);
        for (String carta: (baraja)){
            System.out.print(carta + " ");
        }
        System.out.println("");
    }

    public static ArrayList mezclar(ArrayList<String> baraja){
        Collections.shuffle(baraja);
        return baraja;
    }
}
