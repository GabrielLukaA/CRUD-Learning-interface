public class Televisao extends Eletronico {
    private double polegadas;
    private boolean smart;

    public Televisao(int voltagem, double preco, int id, double polegadas, boolean smart) {
        super(voltagem, preco, id);
    }

    @Override
    public String toString() {
        return super.toString() + "Televisão" + "\n" +
                "polegadas - " + polegadas + "\n" +
                "smart - " + smart;
    }
}
