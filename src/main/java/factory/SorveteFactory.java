package factory;

import model.sabores;
import model.Sorvete;

public class SorveteFactory {

    public static Sorvete criarSorvete(String tipo, String sabor) {
        return switch (tipo.toLowerCase()) {
            case "massa"     -> new sabores.Massa(sabor);
            case "milkshake" -> new sabores.Milkshake(sabor);
            case "picolé"    -> new sabores.Picole(sabor);
            default          -> throw new IllegalArgumentException("Tipo de sorvete inválido: " + tipo);
        };
    }
}
