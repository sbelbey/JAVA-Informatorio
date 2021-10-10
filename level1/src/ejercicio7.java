//Realizar un programa que dado un String de entrada en minúsculas lo convierta por completo a mayúsculas.
// Sin uso de métodos o librerías que realicen toUppercase().

import java.util.Scanner;

public class ejercicio7 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("Ingrese el texto a cambiar: ");
        String texto = String.valueOf(scan.nextLine());
        scan.close();

        for (int i = 0; i<texto.length(); i++){
            char letra = texto.charAt(i);
            if (letra >= 97 && letra <= 122){
                letra = (char)( (letra - 32));
            }
            System.out.print(letra);
        }
    }
}
