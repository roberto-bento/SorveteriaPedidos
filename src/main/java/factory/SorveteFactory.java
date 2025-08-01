package factory;

import model.Sorvete;
import model.impl.Massa;
import model.impl.Milkshake;
import model.impl.Picole;

public class SorveteFactory {
    public static Sorvete criarSorvete(String tipo) {
        return switch (tipo.toLowerCase()) {
            case "massa" -> new Massa();
            case "milkshake" -> new Milkshake();
            case "picole" -> new Picole();
            default -> throw new IllegalArgumentException("Tipo inválido");
        };
    }
}