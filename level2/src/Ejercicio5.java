//Dados 2 ArrayList que contienen horas-trabajadas (array1) y valor-por-hora(array2) del resumen de
//carga de horas semanal de un empleado. Se debe generar otra lista que contenga
// los totales y luego imprimir el total final a cobrar.

//[6, 7, 8, 4, 5]
//[350, 345, 550, 600, 320]
//
//## Los arrays son iguales y corresponden a los días trabajados de una semana Lun-Vie.

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Ejercicio5 {
    public static void main(String[] args) {
        List<Integer> horasTrabajadas = new ArrayList<>();
        List<Integer> valorPorHora = new ArrayList<>();
        List<Integer> aCobrar = new ArrayList<>();
        Integer totalACobrar = 0;
        horasTrabajadas.addAll(Arrays.asList(
            6,7,8,4,5
        ));
        valorPorHora.addAll(Arrays.asList(
                350,345,550,600,320
        ));

        for (int i=0; i<=horasTrabajadas.size()-1; i++) {
            aCobrar.add(horasTrabajadas.get(i)* valorPorHora.get(i));
            totalACobrar = totalACobrar + aCobrar.get(i);
        }
        System.out.println(aCobrar);
        System.out.println("Total Final: $ " + totalACobrar);
    }

}

