//Dado un String de entrada (frase, texto, etc) calcular la cantidad de veces que aparece una letra dada.

import java.util.Scanner;

public class ejercicio9 {
    public static void main(String[] args) {
        Integer acumulador = 0;
        Scanner scan = new Scanner(System.in);
        System.out.print("Ingrese el texto a analizar: ");
        String texto = String.valueOf(scan.nextLine());
        System.out.print("Ingrese la letra a contar: ");
        char letraBuscada = scan.next().charAt(0);
        scan.close();

        for (int i = 0; i <texto.length(); i++){

            char letraTexto = texto.charAt(i);
            if (letraTexto==letraBuscada){
                acumulador ++ ;
            }
        }

        System.out.println(acumulador);

    }

}
