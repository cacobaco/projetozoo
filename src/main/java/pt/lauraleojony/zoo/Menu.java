package pt.lauraleojony.zoo;

import java.util.*;
import pt.lauraleojony.zoo.instalacoes.*;
import pt.lauraleojony.zoo.animais.*;
import pt.lauraleojony.zoo.exceptions.*;

/**
 *
 * @author laura
 */
public class Menu {
    
    private static final String[] TIPOS_ANIMAIS = new String[]{"Chita", "Jaguar", "Leão", "Tigre"}; // nome de todos os tipos de animais
    private static final Map<String, Integer> GENOMAS_PRECOS = Map.of("Panthera", Panthera.PRECO);
    private static final Map<String, String[]> GENOMAS_ANIMAIS = Map.of("Panthera", new String[]{"Jaguar", "Leão", "Tigre"});
    private final Zoo zoo;
    private final Scanner scanner;
    private final Random random;
    
    public Menu(Zoo zoo) {
        this.zoo = zoo;
        this.scanner = new Scanner(System.in);
        this.random = new Random();
    }
    
    public void menuPrincipal() {
        boolean sair = false;
        
        while (!sair) {
            escolhaOpcao();
        
            int opcao = scanner.nextInt();

            switch (opcao) {
                case 0: // sair da aplicação
                    sair = true;
                    sair();
                    break;
                case 1: // adquirir animal aleatório
                    criateRandomAnimal();
                    break;
                case 2: // adquirir animal com característica genética
                    caracAnimal();
                    break;
                case 3: // construir instalação
                    construirInstalacao();
                    break;
                case 4: // colocar animal em instalação
                    break;
                case 5: // calendário chinês
                    break;
                case 6: // listar animais
                    listaAnimais();
                    break;
                case 7: // listar animais com dada característica genética
                    listaAnimaisCarateristica();
                    break;
                case 8: // listar animais com dada mutação
                    listaAnimaisMutação();
                    break;
                case 9: // listar instalações
                    listaInstalacao();
                    break;
                case 10: // retrato de família animal
                    break;
                case 11: // obituário
                    System.out.println(zoo.getObituario());
                    break;
                case 12: // histórico
                    System.out.println(zoo.getHistorico());
                    break;
                case 13: // periodo contabilistico
                    break;
                case 14: // jumanji
                    break;
                default:
                    System.out.println("Opção inválida.");
                    break;
            }
        }
    }
    
    public void escolhaOpcao() {
        System.out.println("Escolha uma opção:");
        System.out.println("1 - Adquirir animal aleatório (" + calcularCustoAquisicoes() + "€)");
        System.out.println("2 - Adquirir animal com caracteristica genética");
        System.out.println("3 - Construir instalação");
        System.out.println("4 - Colocar animal em instalação");
        System.out.println("5 - Calendário chinês");
        System.out.println("6 - Listar animais");
        System.out.println("7 - Listar animais com dada característica genética");
        System.out.println("8 - Listar animais com dada mutação");
        System.out.println("9 - Listar instalações");
        System.out.println("10 - Retrato de família animal");
        System.out.println("11 - Obituário");
        System.out.println("12 - Histórico");
        System.out.println("13 - Período contabilístico");
        System.out.println("14 - Jumanji");
        System.out.println("0 - Sair da aplicação");
        System.out.print("Digite o código da opção: ");
     }
    
    public int calcularCustoAquisicoes() {
        if (zoo.getDinheiro() * 0.05 < 5000) {
            return 5000;
        } else {
            return (int) (zoo.getDinheiro() * 0.05);
        }
    }
    
    public void criateRandomAnimal(){
        int custo = calcularCustoAquisicoes();
        
        try {
            zoo.gastarDinheiro(custo);
        } catch (DinheiroInsuficienteException ex) {
            System.out.println("Não tem dinheiro suficiente para esta aquisição. Aquisição cancelada.");
            return;
        }
        
        Animal[] animais = new Animal[3];
        
        System.out.println("Escolha uma opção: ");
        
        for (int i = 0; i < 3; i++) {
            String tipo = TIPOS_ANIMAIS[random.nextInt(TIPOS_ANIMAIS.length)];

            switch (tipo) {
                case "Chita":
                    animais[i] = new Chita(Zoo.getAno() - random.nextInt((int) (Chita.VIDA_MEDIA * 0.5)), null, random.nextInt(101), random.nextInt(101));
                    break;
                case "Jaguar":
                    animais[i] = new Jaguar(Zoo.getAno() - random.nextInt((int) (Jaguar.VIDA_MEDIA * 0.5)), null, random.nextInt(101), random.nextInt(101));
                    break;
                case "Leão":
                    animais[i] = new Leao(Zoo.getAno() - random.nextInt((int) (Leao.VIDA_MEDIA * 0.5)), null, random.nextInt(101), random.nextInt(101));
                    break;
                case "Tigre":
                    animais[i] = new Tigre(Zoo.getAno() - random.nextInt((int) (Tigre.VIDA_MEDIA * 0.5)), null, random.nextInt(101), random.nextInt(101));
                    break;
                default:
                    i--;
                    continue;
            }

            System.out.println((i + 1) + " - " + animais[i]);
        }
        
        System.out.println("0 - Cancelar");

        int opcao;

        do {
            System.out.print("Digite o código da opção: ");
            opcao = scanner.nextInt();
        } while (opcao >= 0 && opcao <= 3); // [1,3]
        
        if (opcao == 0) {
            zoo.adicionarDinheiro(custo);
            System.out.println("Cancelou a aquisição.");
            return;
        }

        Animal animal = animais[opcao - 1];

        System.out.println("Escolheu: " + animal);

        System.out.print("Digite o nome do animal: ");

        String nome = scanner.nextLine();

        animal.setNome(nome);
        
        zoo.adicionarAnimal(animal);
        zoo.getHistorico().adicionarAquisicao(animal, custo);
    }
    
    public void caracAnimal(){
        System.out.println("Escolha uma opção: ");
        
        String[] genomas = (String[]) GENOMAS_ANIMAIS.keySet().toArray();
        
        int i = 0;
        for (String genoma : genomas) {
            System.out.println(++i + " - " + genoma + " (" + GENOMAS_PRECOS.get(genoma) + "€)");
        }
        
        System.out.println("0 - Cancelar");
        
        int opcao;
        
        do {
            System.out.print("Digite o código da opção: ");
            opcao = scanner.nextInt();
        } while (opcao >= 0 && opcao <= GENOMAS_ANIMAIS.size());
        
        if (opcao == 0) {
            System.out.println("Cancelou a aquisição.");
            return;
        }
        
        String genoma = genomas[opcao - 1];
        
        double custo = GENOMAS_PRECOS.get(genoma);
        
        try {
            zoo.gastarDinheiro(custo);
        } catch (DinheiroInsuficienteException ex) {
            System.out.println("Não tem dinheiro suficiente para esta aquisição. Aquisição cancelada.");
            return;
        }
        
        String[] animais = GENOMAS_ANIMAIS.get(genoma);
        
        String tipo = animais[random.nextInt(animais.length)];
        
        Animal animal;
        
        switch (tipo) {
            case "Chita":
                animal = new Chita(Zoo.getAno() - random.nextInt((int) (Chita.VIDA_MEDIA * 0.5)), null, random.nextInt(101), random.nextInt(101));
                break;
            case "Jaguar":
                animal = new Jaguar(Zoo.getAno() - random.nextInt((int) (Jaguar.VIDA_MEDIA * 0.5)), null, random.nextInt(101), random.nextInt(101));
                break;
            case "Leão":
                animal = new Leao(Zoo.getAno() - random.nextInt((int) (Leao.VIDA_MEDIA * 0.5)), null, random.nextInt(101), random.nextInt(101));
                break;
            case "Tigre":
                animal = new Tigre(Zoo.getAno() - random.nextInt((int) (Tigre.VIDA_MEDIA * 0.5)), null, random.nextInt(101), random.nextInt(101));
                break;
            default:
                zoo.adicionarDinheiro(custo);
                System.out.println("Ocorreu um erro, a aquisição foi cancelada.");
                return;
        }
        
        System.out.println("Adquiriu " + animal + ".");
        
        System.out.print("Digite o nome do animal: ");

        String nome = scanner.nextLine();

        animal.setNome(nome);
        
        zoo.adicionarAnimal(animal);
        zoo.getHistorico().adicionarAquisicao(animal, custo);
    }
    
    public void construirInstalacao() {
        int[] capacidades = {random.nextInt(5) + 1, random.nextInt(5) + 1, random.nextInt(5) + 1};
        int[] precos = {random.nextInt(10001) + 25000, random.nextInt(10001) + 25000, random.nextInt(10001) + 25000};
        
        for(int i = 0; i < capacidades.length; i++) {
            System.out.println((i + 1) + " - Capacidade: " + capacidades[i] + " (" + precos[i] + "€)");
        }
        
        System.out.println("0 - Cancelar");
        
        int opcao;
        
        do {
            System.out.print("Digite o código da opção: ");
            opcao = scanner.nextInt();
        } while (opcao >= 0 && opcao <= capacidades.length);
        
        if (opcao == 0) {
            System.out.println("Cancelou a construção.");
            return;
        }
        
        int capacidade = capacidades[opcao - 1];
        int preco = precos[opcao - 1];
        
        try {
            zoo.gastarDinheiro(preco);
        } catch (DinheiroInsuficienteException ex) {
            System.out.println("Ocorreu um erro, a construção foi cancelada.");
            return;
        }
        
        Instalacao instalacao = new Instalacao(capacidade);
        zoo.adicionarInstalacao(instalacao);
        zoo.getHistorico().adicionarConstrucao(instalacao, preco);
        System.out.println("Construi uma nova instalação de capacidade " + capacidade + " com o id " + instalacao.getId() + ".");
    }
    
    public void calendárioChines() {
    }
    
    public void listaAnimais() {
        String str = "----- @ Animais @ -----\n";
        
        int i = 0;
        for (Animal a : zoo.getAnimais()) {
            str  += ++i + ". " + a + "\n";
        }
        
        str += "-------------------------\n";
        
        System.out.println(str);
    }
    
    public void listaAnimaisCarateristica(){
        System.out.print("Digite a característica genética que deseja procurar: ");
        
        String caracteristica = scanner.nextLine();
        
        switch (caracteristica.toLowerCase()) {
            case "panthera": {
                String str = "----- @ Panthera @ -----\n";
        
                int i = 0;
                for (Animal a : zoo.getAnimais()) {
                    if (a instanceof Panthera) str  += ++i + ". " + a + "\n";
                }

                str += "-------------------------\n";

                System.out.println(str);
                break;
            }
            default: {
                System.out.println("Característica genética inexistente.");
                break;
            }
        }
    }
    
    public void listaAnimaisMutação(){
        System.out.print("Digite a mutação que deseja procurar: ");
        
        String mutacao = scanner.nextLine();
        
        switch (mutacao.toLowerCase()) {
            case "albinismo": {
                String str = "----- @ Albinismo @ -----\n";
        
                int i = 0;
                for (Animal a : zoo.getAnimais()) {
                    if (a.determinarAlbinismo()) str  += ++i + ". " + a + "\n";
                }

                str += "-------------------------\n";

                System.out.println(str);
                break;
            }
            case "heterocromia": {
                String str = "----- @ Heterocromia @ -----\n";
        
                int i = 0;
                for (Animal a : zoo.getAnimais()) {
                    if (a.determinarHeterocromia()) str  += ++i + ". " + a + "\n";
                }

                str += "-------------------------\n";

                System.out.println(str);
                break;
            }
            default: {
                System.out.println("Característica genética inexistente.");
                break;
            }
        }
    }
    
    public void listaInstalacao(){
        System.out.println("----- @ Instalações @ -----");
        for (Instalacao instalacao : zoo.getInstalacoes()) {
            System.out.println(instalacao);
        }
        System.out.println("-------------------------");
    }
    
    public void retatoFamiliaAnimal(){
        
    }
    
    public void períodoContabilistico(){
        
    }
    
    public void jumanji(){
        
    }
    
    public void sair(){
        
    }
}
