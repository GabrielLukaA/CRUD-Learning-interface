public class Eletronico {
    private int voltagem;
    private double preco;
    private int id;

    public Eletronico(int voltagem, double preco, int id) {
        this.voltagem = voltagem;
        this.preco = preco;
        this.id = id;
    }

    public int getId() {
        return id;
    }


    @Override
    public String toString() {
        return "Eletrônico:" + "\n"+
                "voltagem - " + voltagem +"\n"+
                "preço - " + preco +"\n"+
                "id - " + id +"\n";
    }
}
