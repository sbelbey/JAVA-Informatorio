//Realizar un programa que solicite por consola 2 números enteros.
// Para luego imprimir el resultado de la suma, resta, multiplicación, división y módulo (resto de la división)
// de ambos números.

//5 + 4 = 9
//5 - 4 = 1
//5 * 4 = 20
//5 / 4 = 1
//5 % 4 = 1

import java.util.Scanner;

public class ejercicio2 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        Integer num1 = Integer.parseInt(scan.nextLine());
        Integer num2 = Integer.parseInt(scan.nextLine());

        System.out.println(num1 + " + " + num2 + " = " + (num1+num2));
        System.out.println(num1 + " - " + num2 + " = " + (num1-num2));
        System.out.println(num1 + " * " + num2 + " = " + (num1*num2));
        System.out.println(num1 + " / " + num2 + " = " + (num1/num2));
        System.out.println(num1 + " % " + num2 + " = " + (num1%num2));


    }
}
