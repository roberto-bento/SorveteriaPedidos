package model;

public class sabores {
    public static class Massa implements Sorvete {
        private final String sabor;

        public Massa(String sabor) {
            this.sabor = sabor;
        }

        @Override
        public String getDescricao() {
            return "Sorvete de massa sabor " + sabor;
        }

        @Override
        public double getPreco() {
            return 5.0;
        }
    }

    public static class Milkshake implements Sorvete {
        private final String sabor;

        public Milkshake(String sabor) {
            this.sabor = sabor;
        }

        @Override
        public String getDescricao() {
            return "Milkshake sabor " + sabor;
        }

        @Override
        public double getPreco() {
            return 6.0;
        }
    }

    public static class Picole implements Sorvete {
        private final String sabor;

        public Picole(String sabor) {
            this.sabor = sabor;
        }

        @Override
        public String getDescricao() {
            return "Picolé sabor " + sabor;
        }

        @Override
        public double getPreco() {
            return 4.0;
        }
    }
}
