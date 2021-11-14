import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class Ejercicio1 {
    public static void main(String[] args) {
        List<String> palabras = new ArrayList<>();
        palabras.add("Hola");
        palabras.add(null);
        palabras.add("Informatorio");
        palabras.add("");
        List<String> listaFiltrada = palabras.stream()
                                     .filter(Objects::nonNull)
                                     .filter(p -> !p.equals(""))
                                     .collect(Collectors.toList());
        System.out.println(listaFiltrada);
    }
}
