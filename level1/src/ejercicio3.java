import java.util.Scanner;

//Confeccionar un programa que dado un número entero como dato de entrada,
// imprima la secuencia de números (incrementos de 1) de la siguiente forma:
//1
//1 2
//1 2 3
//1 2 3 4
//1 2 3 4 5
public class ejercicio3 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        Integer numero = Integer.parseInt(scan.nextLine());

        for (int i = 1; i <= numero; i++){
            for (int j = 1; j<=i; j++) {
                System.out.print(j + " ");
            }
            System.out.println();
        }
    }
}
