//Crear una aplicación que solicite de entrada los datos de una persona en este orden:
//Nombre y Apellido
//Edad
//Dirección
//Ciudad
//Luego imprimirá el siguiente mensaje:
//{Ciudad} - {Dirección} - {Edad} - {Nombre y Apellido}

import java.util.ArrayList;
import java.util.Scanner;

public class ejercicio8 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("Ingrese los datos de la persona: ");
        ArrayList<String> persona = new ArrayList<>();
        for (int i = 1; i <= 4; i++) {
            persona.add(scan.nextLine());
        }

        for (int i = 3; i>=0; i--){
            System.out.print(persona.get(i));
            if (i != 0) {
                System.out.print(" - ");
            }
        }
    }
}
