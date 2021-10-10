//Se desea una aplicación que solicite 2 números enteros y
//realice la operación de multiplicación por sumas sucesivas (sin uso de librerías).

import java.util.Scanner;

public class ejercicio5 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("Ingrese el mutiplicando: ");
        Integer num1 = Integer.valueOf(scan.nextLine());
        System.out.println("Ingrese el mutiplicador: ");
        Integer num2 = Integer.valueOf(scan.nextLine());
        scan.close();

        System.out.println(num1 + " x " + num2 + " = " + multiplicacion(num1, num2));
    }

    public static Integer multiplicacion(Integer multiplicando, Integer multiplicador){
        Integer acumulador = 0;
        for (int i = 1; i <= multiplicador; i++){
            acumulador += multiplicando;
        }
        return acumulador;
    }
}
