//Se desea una aplicación que solicite 2 números enteros y realice la operación de potencia (sin uso de librerías).

import java.util.Scanner;

public class ejercicio6 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("Ingrese el numero base: ");
        Integer num1 = Integer.valueOf(scan.nextLine());
        System.out.println("Ingrese el exponente: ");
        Integer num2 = Integer.valueOf(scan.nextLine());
        scan.close();
        System.out.println(num1 + " elevado a " + num2 + " = " + elevar(num1, num2));
    }

    public static Integer elevar (Integer base, Integer exponente){
        Integer acumulador = 1;
        for (int i = 1; i<=(exponente); i++){
            acumulador = acumulador*base;
        }
        return acumulador;
    }
}
