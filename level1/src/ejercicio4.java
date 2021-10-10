//Realizar un programa que calcule el factorial de un número:
//n! = 1 x 2 x 3 x 4 x 5 x … x (n-1) x n.
//Sin hacer uso de librerías.

import java.util.Scanner;

public class ejercicio4 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("Ingrese el número a factorializar: ");
        Integer num = Integer.valueOf(scan.nextInt());

        System.out.println("El factorial de " + num + " es: " + factorializar(num));
    }

    public static Integer factorializar(Integer numero){
        if (numero==1){
            return numero;
        } else {
            return (numero*factorializar(numero-1));
        }
    }
}
