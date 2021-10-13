//Se dispone de una lista de Empleados, de cada empleado se conoce:
//Nombre y Apellido
//DNI
//horasTrabajadas
//valorPorHora
//Todos los empleados están cargados en un Set (HashSet), se desea calcular el sueldo
//(horasTrabajadas x valorPorHora) de toda esa lista para luego almacenar en un Map (o Diccionario)
//donde la clave (key) es el dni y el valor (value) es el sueldo calculado.

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Ejercicio6 {
    public static void main(String[] args) {
    Set<Empleados> plantilla = new HashSet<>();
    Empleados emp1 = new Empleados("Homero Simpson", 1234,15,20);
    Empleados emp2 = new Empleados("Marge Simpson", 2344,13,12);
    Empleados emp3 = new Empleados("Lisa Simpson", 9813,17,50);
    Map<Integer,Integer> aPagar = new HashMap<>();
    plantilla.add(emp1);
    plantilla.add(emp2);
    plantilla.add(emp3);

        for (Empleados empleado:plantilla) {
            aPagar.put(empleado.getDni(),empleado.getSueldo());
        }

        for (Map.Entry<Integer,Integer> empleado: aPagar.entrySet()) {
            System.out.println("El sueldo a pagar al empleado con D.N.I.: " + empleado.getKey() +
                    " es de: " + empleado.getValue());
        }
    }

}
