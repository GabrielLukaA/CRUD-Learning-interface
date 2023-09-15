public class Computador extends Eletronico {
    private boolean placaDeVideoDedicada;
    private int quantidadeDeEntradas;

    public Computador(int voltagem, double preco, int id, int entradas, boolean placaDeVideo) {
        super(voltagem, preco, id);
        this.placaDeVideoDedicada = placaDeVideo;
        this.quantidadeDeEntradas = entradas;
    }

    @Override
    public String toString() {
        return super.toString() + "Computador" + "\n" +
                "placa de vídeo dedicada - " + placaDeVideoDedicada + "\n" +
                "quantidade de entradas - " + quantidadeDeEntradas;
    }

}
