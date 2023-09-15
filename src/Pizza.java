public class Pizza extends Alimento {
    private String sabor;
    private int quantidadeDeFatias;

    public Pizza(String nome, double calorias, double gramas, int id, String sabor, int quantidadeDeFatias) {
        super(nome, calorias, gramas, id);
        this.sabor = sabor;
        this.quantidadeDeFatias = quantidadeDeFatias;
    }

    @Override
    public String toString() {
        return super.toString() + "Pizza" + "\n" +
                "sabor - " + sabor + "\n" +
                "quantidadeDeFatias - " + quantidadeDeFatias;
    }
}
