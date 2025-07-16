package factory;

import model.Sorvete;

public class SorveteFactory {
    public static Sorvete criarSorvete(String tipo) {
        return switch (tipo.toLowerCase()) {
            case "picolé" -> new Picole();
            case "massa" -> new Massa();
            case "milkshake" -> new Milkshake();
            default -> throw new IllegalArgumentException("Tipo inválido");
        };
    }
}