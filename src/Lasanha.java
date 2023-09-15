public class Lasanha extends Alimento{

    private String recheio;
    private boolean gluten;

    public Lasanha(String nome, double calorias, double gramas, int id, String recheio, boolean gluten) {
        super(nome, calorias, gramas, id);
        this.recheio = recheio;
        this.gluten = gluten;
    }

    @Override
    public String toString() {
        return super.toString() + "Lasanha" + "\n" +
                "recheio - " + recheio + "\n" +
                "gluten - " + gluten;
    }



}
