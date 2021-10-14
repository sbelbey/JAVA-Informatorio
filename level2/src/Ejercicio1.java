//Crear un ArrayList y cargarlo con tus ciudades favoritas de Argentina,
// luego imprimir por pantalla el ranking
//Input (Entrada):
//Bariloche
//Córdoba
//Resistencia
//
//Output (Salida):
//#1 - Bariloche
//#2 - Córdoba
//#3 - Resistencia

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Ejercicio1 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        Integer control = 0;
        List<String> ciudades = new ArrayList<>();

        do {
            System.out.println("Ingresá de a una tus ciudades argentinas favoritas:");
            ciudades.add(String.valueOf(scan.nextLine()));
            System.out.println("Para salir ingresá 1, para continuar seleccioná cualquier otro número.");
            control = Integer.valueOf(scan.nextLine());
        }while (control != 1);

        scan.close();

        System.out.println("La el ranking de ciudades es: ");
        for (int i = 0; i< ciudades.size(); i++){
            System.out.println("#" + (i+1) + " - " + ciudades.get(i));
        }
    }
}
