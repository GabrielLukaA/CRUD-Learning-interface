public class Hamburguer extends Alimento {
    private String tipoDePao;
    private String tipoDeCarne;

    public Hamburguer(String nome, double calorias, double gramas, int id, String tipoDePao, String tipoDeCarne) {
        super(nome, calorias,gramas, id);
        this.tipoDePao = tipoDePao;
        this.tipoDeCarne = tipoDeCarne;
    }

    @Override
    public String toString() {
        return super.toString() + "Hambuerguer" + "\n" +
                "tipo de pão - " + tipoDePao + "\n" +
                "tipo de carne - " + tipoDeCarne;
    }

}
