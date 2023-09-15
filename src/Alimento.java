public class Alimento {

    private double calorias;
    private String nome;
    private double gramas;
    private int id;

    public Alimento(String nome, double calorias, double gramas, int id) {
        this.calorias = calorias;
        this.nome = nome;
        this.gramas = gramas;
        this.id = id;
    }

    public int getId() {
        return id;
    }

    @Override
    public String toString() {
        return "Alimento: " +"\n"+
                "calorias - " + calorias + "\n"+
                "nome - " + nome  + "\n"+
                "gramas - " + gramas + "\n"+
                "id - " + id + "\n";
    }
}
