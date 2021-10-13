//Crear una función que dado 2 argumentos (int, siendo el primero menor al segundo),
// nos devuelva un array de Strings. Con la secuencia de números enteros de principio a final.
// Pero si el número es multiplo de 2 colocara el valor “Fizz”, si es múltiplo de 3 “Buzz” y
// si es a la vez múltiplo de ambos colocara “FizzBuzz”.
//Observacion: Los 2 argumentos indican con que valor se arranca a calcular y el segundo con qué valor debe frenar
// (no se incluye en el cálculo)
//Ejemplo: (1, 5) ----> calculará valores de 1, 2, 3, 4
//Input (Entrada):
//fizzBuzzFuncion(1,6)
// 6 si marca el límite y no se lo incluye
//fizzBuzzFuncion(1,8)
//
//Output (Salida):

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Ejercicio7 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("Ingrese el primer valor: ");
        Integer num1 = Integer.valueOf(scan.nextLine());
        System.out.println("Ingrese el segundo valor:");
        Integer num2 = Integer.valueOf(scan.nextLine());
        List<String> listaNum = new ArrayList<>();
        scan.close();
        fizzBuzzFuncion(num1, num2, listaNum);

        System.out.println(listaNum);

    }

    public static void fizzBuzzFuncion(Integer num1, Integer num2, List<String> lisaNum){
        for (int i = num1; i< num2; i++){
            if ((i%2)==0 && (i%3)==0){
                lisaNum.add("FizzBuzz");
            }else if ((i%2)==0){
                lisaNum.add("Fizz");
            }else if ((i%3)==0){
                lisaNum.add("Buzz");
            }else {
                lisaNum.add(String.valueOf(i));
            }
        }
    }
}
