import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    static Scanner sc = new Scanner(System.in);
    static BDAlimento bdAlimento = new BDAlimento();
    static BDEletronico bdEletronico = new BDEletronico();
    static int contadorEletronicos = 0;
    static int contadorAlimentos = 0;

    public static void main(String[] args) {

        do {
            telaInicial();
        } while (true);
    }

    private static void telaInicial() {

        System.out.println("""
                Bem-vindo, o que deseja fazer?
                1 - Cadastrar
                2 - Procurar
                3 - Atualizar
                4 - Deletar
                5 - Mostrar Todos
                0 - Enecerrar aplicação
                                
                """);
        int opcao = sc.nextInt();
        switch (opcao) {
            case 1 -> cadastrar();
            case 2 -> procurar();
            case 3 -> atualizar();
            case 4 -> deletar();
            case 5 -> mostrarTodos();
            case 0 -> System.exit(0);

        }
    }

    private static void mostrarTodos() {
        int opcao = -1;
        do {
            System.out.println("""
                    Você deseja mostrar todos os alimentos ou os eletrônicos?
                    1 - Alimento
                    2 - Eletrônico
                    3 - Ambos
                    0 - Retornar a tela inicial
                    """);
            opcao = sc.nextInt();
            switch (opcao) {
                case 1 -> System.out.println(bdAlimento.read());
                case 2 -> System.out.println(bdEletronico.read());
                case 3 -> System.out.println("Alimentos\n" + bdAlimento.read() + "\n\nEletrônicos\n" + bdEletronico.read());
                case 0 -> System.out.println("Voltando...");
                default -> System.out.println("Informe um número válido.");
            }
        } while (opcao < 0 || opcao > 3);
    }

    private static void deletar() {
        int opcao = -1;
        do {
            System.out.println(" Você deseja deletar um alimento ou um eletrônico? ");
            options();
            opcao = sc.nextInt();

            switch (opcao) {
                case 1 -> deletarAlimento();
                case 2 -> deletarEletronico();
                case 0 -> System.out.println("Voltando...");
                default -> System.out.println("Informe um número válido.");
            }
        } while (opcao < 0 || opcao > 2);


    }

    private static void deletarEletronico() {
        System.out.println("Informe o ID do eletrônico que deseja remover.");
        int id = sc.nextInt();
        Eletronico eletronico = bdEletronico.read(id);
        if (eletronico != null) {
            if (bdEletronico.delete(eletronico)) {
                System.out.println("Eletrônico deletado com sucesso.");
            }
        } else {
            System.out.println("Eletrônico não encontrado.");
        }
    }

    private static void deletarAlimento() {
        System.out.println("Informe o ID do alimento que deseja remover.");
        int id = sc.nextInt();
        Alimento alimento = bdAlimento.read(id);
        if (alimento != null) {
            if (bdAlimento.delete(alimento)) {
                System.out.println("Alimento deletado com sucesso.");
            }
        } else {
            System.out.println("Alimento não encontrado.");
        }
    }

    private static void atualizar() {
        int opcao = -1;
        do {
            System.out.println(" Você deseja atualizar um alimento ou um eletrônico? ");
            options();
            opcao = sc.nextInt();

            switch (opcao) {
                case 1 -> atualizarAlimento();
                case 2 -> atualizarEletronico();
                case 0 -> System.out.println("Voltando...");
                default -> System.out.println("Informe um número válido.");
            }
        } while (opcao < 0 || opcao > 2);

    }

    private static void atualizarEletronico() {
        System.out.println("Informe o código desse eletrõnico:");
        Eletronico eletronico = bdEletronico.read(sc.nextInt());
        Eletronico eletronicoNovo = null;
        if (eletronico instanceof Ventilador) {
            eletronicoNovo = new Ventilador(pegarInfoEletronico(), pegarInfoEletronico2(),
                    eletronico.getId(), pegarInfoVentilador(), pegarInfoVentilador2());
        } else if (eletronico instanceof Computador) {
            eletronicoNovo = new Computador(pegarInfoEletronico(), pegarInfoEletronico2(),
                    eletronico.getId(), pegarInfoComputador(), pegarInfoComputador2());
        } else {
            eletronicoNovo = new Televisao(pegarInfoEletronico(), pegarInfoEletronico2(),
                    eletronico.getId(), pegarInfoTelevisao(), pegarInfoTelevisao2());
        }
        if (bdEletronico.update(eletronicoNovo) != null) {
            System.out.println("Eletronico atualizado.");
        }
    }

    private static void atualizarAlimento() {
        System.out.println("Informe o código desse alimento:");
        Alimento alimento = bdAlimento.read(sc.nextInt());
        Alimento alimentoNovo = null;
        if (alimento instanceof Hamburguer) {
            alimentoNovo = new Hamburguer(pegarInfoAlimento(), pegarInfoAlimento2(), pegarInfoAlimento3(),
                    alimento.getId(), pegarInfoHamburguer(), pegarInfoHamburguer2());
        } else if (alimento instanceof Pizza) {
            alimentoNovo = new Pizza(pegarInfoAlimento(), pegarInfoAlimento2(), pegarInfoAlimento3(),
                    alimento.getId(), pegarInfoPizza(), pegarInfoPizza2());
        } else {
            alimentoNovo = new Lasanha(pegarInfoAlimento(), pegarInfoAlimento2(), pegarInfoAlimento3(),
                    alimento.getId(), pegarInfoLasanha(), pegarInfoLasanha2());
        }
        if (bdAlimento.update(alimentoNovo) != null) {
            System.out.println("Alimento atualizado.");
        }

    }

    private static void options() {
        System.out.println("""
                1 - Alimento
                2 - Eletrônico
                0 - Retornar a tela inicial""");
    }

    private static void procurar() {
        int opcao = -1;
        do {
            System.out.println(" Você deseja procurar um alimento ou um eletrônico? ");
            options();
            opcao = sc.nextInt();

            switch (opcao) {
                case 1 -> procurarAlimento();
                case 2 -> procurarEletronico();
                case 0 -> System.out.println("Voltando...");
                default -> System.out.println("Informe um número válido.");
            }
        } while (opcao < 0 || opcao > 2);

    }

    private static void procurarEletronico() {

        System.out.println("Informe o ID do Eletrônico que deseja remover.");
        int id = sc.nextInt();
        Eletronico eletronico = bdEletronico.read(id);
        if (eletronico != null) {
            System.out.println(eletronico);
        } else {
            System.out.println("Alimento não encontrado.");
        }
    }

    private static void procurarAlimento() {
        System.out.println("Informe o ID do Alimento que deseja remover.");
        int id = sc.nextInt();
        Alimento alimento = bdAlimento.read(id);
        if (alimento != null) {
            System.out.println(alimento);
        } else {
            System.out.println("Alimento não encontrado.");
        }
    }

    private static void cadastrar() {
        int opcao = -1;
        do {
            System.out.println(" Você deseja cadastrar um alimento ou um eletrônico? ");
            options();
            opcao = sc.nextInt();

            switch (opcao) {
                case 1 -> cadastrarAlimento();
                case 2 -> cadastrarEletronico();
                case 0 -> System.out.println("Voltando...");
                default -> System.out.println("Informe um número válido.");
            }
        } while (opcao < 0 || opcao > 2);

    }

    private static void cadastrarEletronico() {

        System.out.println("Informe a voltagem do eletronico:");
        int voltagem = sc.nextInt();
        System.out.println("Informe o preço desse eletrônico:");
        double preco = sc.nextDouble();

        int opcao = 0;

        do {
            System.out.println("""
                    Que tipo de eletrônico esse eletrõnico é?
                    1 - Televisão
                    2 - Computador
                    3 - Ventilador
                    0 - Retornar ao menu inical
                    """);

            opcao = sc.nextInt();

            switch (opcao) {
                case 1 -> cadastrarTelevisão(voltagem, preco);
                case 2 -> cadastrarComputador(voltagem, preco);
                case 3 -> cadastrarVentilador(voltagem, preco);
                default -> System.out.println("Insira um número válido.");
            }
        } while (opcao < 1 || opcao > 3);

    }

    private static void cadastrarVentilador(int voltagem, double preco) {

        contadorEletronicos++;
        Eletronico eletronico = new Ventilador(voltagem, preco, contadorEletronicos, pegarInfoVentilador(), pegarInfoVentilador2());
        bdEletronico.create(eletronico);
        System.out.println("Ventilador cadastrado.");
    }

    private static void cadastrarComputador(int voltagem, double preco) {

        contadorEletronicos++;
        Eletronico eletronico = new Computador(voltagem, preco, contadorEletronicos, pegarInfoComputador(), pegarInfoComputador2());
        bdEletronico.create(eletronico);
        System.out.println("Computador cadastrado.");
    }

    private static void cadastrarTelevisão(int voltagem, double preco) {

        contadorEletronicos++;
        Eletronico eletronico = new Televisao(voltagem, preco, contadorEletronicos, pegarInfoTelevisao(), pegarInfoTelevisao2());
        bdEletronico.create(eletronico);
        System.out.println("Televisão cadastrada.");
    }


    private static void cadastrarAlimento() {

        int opcao = 0;

        do {
            System.out.println("""
                    Que tipo de alimento esse alimento é?
                    1 - Hamburguer
                    2 - Lasanha
                    3 - Pizza
                    0 - Retornar ao menu inical
                    """);

            opcao = sc.nextInt();

            switch (opcao) {
                case 1 -> cadastrarHamburguer(pegarInfoAlimento(), pegarInfoAlimento2(), pegarInfoAlimento3());
                case 2 -> cadastrarLasanha(pegarInfoAlimento(), pegarInfoAlimento2(), pegarInfoAlimento3());
                case 3 -> cadastrarPizza(pegarInfoAlimento(), pegarInfoAlimento2(), pegarInfoAlimento3());
                default -> System.out.println("Insira um número válido.");
            }
        } while (opcao < 1 || opcao > 3);


    }

    private static double pegarInfoAlimento3() {
        System.out.println("Informe quantas gramas tem esse alimento:");
        double gramas = sc.nextDouble();
        return gramas;
    }

    private static String pegarInfoAlimento() {
        System.out.println("Informe o nome do alimento:");
        String nome = sc.next();
        return nome;
    }

    private static double pegarInfoAlimento2() {
        System.out.println("Informe quantas calorias o alimento tem:");
        double calorias = sc.nextDouble();
        return calorias;
    }

    private static void cadastrarPizza(String nome, double calorias, double gramas) {
        contadorAlimentos++;
        Alimento alimento = new Pizza(nome, calorias, gramas, contadorAlimentos, pegarInfoPizza(), pegarInfoPizza2());
        bdAlimento.create(alimento);
        System.out.println("Pizza cadastrada.");
    }

    private static void cadastrarLasanha(String nome, double calorias, double gramas) {
        contadorAlimentos++;
        Alimento alimento = new Lasanha(nome, calorias, gramas, contadorAlimentos, pegarInfoLasanha(), pegarInfoLasanha2());
        bdAlimento.create(alimento);
        System.out.println("Lasanha cadastrada.");
    }

    private static void cadastrarHamburguer(String nome, double calorias, double gramas) {
        contadorAlimentos++;
        Alimento alimento = new Hamburguer(nome, calorias, gramas, contadorAlimentos, pegarInfoHamburguer(), pegarInfoHamburguer2());
        bdAlimento.create(alimento);
        System.out.println("Hamburguer cadastrado.");
    }


    private static int pegarInfoVentilador() {
        System.out.println("quantas velocidades o ventilador tem:");
        int velocidades = sc.nextInt();
        return velocidades;
    }

    private static int pegarInfoVentilador2() {
        System.out.println("Informe quantas pás tem esse ventilador:");
        int pas = sc.nextInt();
        return pas;
    }


    private static String pegarInfoPizza() {
        System.out.println("Informe sabor da pizza:");
        String sabor = sc.next();
        return sabor;
    }

    private static int pegarInfoPizza2() {
        System.out.println("Informe a quantidade de fatias:");
        int quantidadeDeFatias = sc.nextInt();
        return quantidadeDeFatias;
    }

    private static String pegarInfoHamburguer() {
        System.out.println("Informe o tipo de pão:");
        String tipoDePao = sc.next();
        return tipoDePao;
    }

    private static String pegarInfoHamburguer2() {
        System.out.println("Informe o tipo de carne:");
        String tipoDeCarne = sc.next();
        return tipoDeCarne;
    }

    private static String pegarInfoLasanha() {
        System.out.println("Informe o recheio:");
        String recheio = sc.next();
        return recheio;
    }

    private static boolean pegarInfoLasanha2() {
        int escolha = 0;
        boolean gluten = true;
        do {
            System.out.println("""
                    Informe se a Lasanha contém gluten:
                    1 - Sim
                    2 - Não
                    """);
            escolha = sc.nextInt();

            switch (escolha) {
                case 1 -> gluten = true;
                case 2 -> gluten = false;
                default -> System.out.println("Insira um número válido.");
            }

        } while (escolha < 1 && escolha > 2);
        return gluten;
    }

    private static int pegarInfoComputador() {
        System.out.println("Informe quantas entradas o computador tem:");
        int entradas = sc.nextInt();
        return entradas;
    }

    private static boolean pegarInfoComputador2() {
        int escolha = 0;
        boolean placaDeVideo = false;
        do {
            System.out.println("""
                    Informe se o pc possuí placa de vídeo:
                    1 - Sim
                    2 - Não
                    """);
            escolha = sc.nextInt();

            switch (escolha) {
                case 1 -> placaDeVideo = true;
                case 2 -> placaDeVideo = false;
                default -> System.out.println("Insira um número válido.");
            }

        } while (escolha < 1 && escolha > 2);

        return placaDeVideo;
    }


    private static boolean pegarInfoTelevisao2() {
        int escolha = 0;
        boolean smart = false;
        do {
            System.out.println("""
                    Informe se a TV é smart:
                    1 - Sim
                    2 - Não
                    """);
            escolha = sc.nextInt();

            switch (escolha) {
                case 1 -> smart = true;
                case 2 -> smart = false;
                default -> System.out.println("Insira um número válido.");
            }

        } while (escolha < 1 && escolha > 2);
        return smart;
    }

    private static double pegarInfoTelevisao() {
        System.out.println("Informe quantas polegadas a TV tem:");
        double polegadas = sc.nextDouble();
        return polegadas;
    }

    private static int pegarInfoEletronico() {
        System.out.println("Informe a voltagem do eletronico:");
        int voltagem = sc.nextInt();
        return voltagem;
    }

    private static double pegarInfoEletronico2() {
        System.out.println("Informe o preço desse eletrônico:");
        double preco = sc.nextDouble();
        return preco;
    }
}
