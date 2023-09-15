public class Ventilador extends Eletronico {
    private int velocidades;
    private int quantidadeDePas;

    public Ventilador(int voltagem, double preco, int id, int velocidades, int pas) {
        super(voltagem, preco, id);
        this.velocidades = velocidades;
        this.quantidadeDePas = pas;
    }

    @Override
    public String toString() {
        return super.toString() + "Ventilador" + "\n" +
                "velocidades - " + velocidades + "\n" +
                "quantidade de pás - " + quantidadeDePas;
    }


}
