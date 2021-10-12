//Cargar un arrayList con 12 nombres de estudiantes (String),
// luego separarlos en 3 cursos (3 arrayList)
// e imprimir dichos cursos.
import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.List;
import java.util.ArrayList;


public class Ejercicio4 {
    public static void main(String[] args) {
        List<String> alumnos = new ArrayList<String>();
        alumnos.addAll(Arrays.asList("Saúl", "Juan", "Pepe",
                "Luciana", "Ricardo", "Gianina", "Emmanuel",
                "Leandro", "Nancy", "Nestor", "Iris", "Pablo",
                "Gustavo"));

        List<List<String>> cursos = new ArrayList<>();

        for(int i=0; i<3; i++){
            cursos.add(alumnos.subList(4*i, 3+4*i));
        }

        System.out.println(cursos);

        Integer contador = 1;
        for (List<String>curso: cursos) {
            System.out.print("Curso #" + (contador++) + ": ");
            for (String nombre: curso) {
                System.out.print(nombre + " ");
            }
            System.out.println("");
            
        }

    }
}
