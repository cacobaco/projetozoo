package pt.lauraleojony.zoo;

import java.util.*;
import pt.lauraleojony.zoo.instalacoes.*;
import pt.lauraleojony.zoo.animais.*;

/**
 *
 * @author laura
 */
public class Menu {
    
    private static final String[] TIPOS_ANIMAIS = new String[]{"Chita", "Jaguar", "Leão", "Tigre"}; // nome de todos os tipos de animais
    private static final String[] GENOMAS_ANIMAIS = new String[]{"Panthera"}; // nome de todos os genomas
    private final Zoo zoo;
    private final Scanner scanner;
    private final Random random;
    
    public Menu(Zoo zoo){
        this.zoo = zoo;
        this.scanner = new Scanner(System.in);
        this.random = new Random();
    }
    
    // retorna true se o utilizador escolher sair da aplicação
    public boolean menuPrincipal() {
        escolhaOpcao();

        int opcao = scanner.nextInt();

        switch (opcao) {
            case 0: // sair da aplicação
                sair();
                return true;
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

        return false;
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
            return 15000;
        } else {
            return (int) (zoo.getDinheiro() * 0.05);
        }
    }
    
    public void criateRandomAnimal(){
        Animal[] animais = new Animal[3];

        System.out.println("Escolha uma opção: ");

        for (int i = 0; i < 3; i++) {
            Random rand = new Random();

            String tipo = TIPOS_ANIMAIS[rand.nextInt(TIPOS_ANIMAIS.length)];

            switch (tipo) {
                case "Chita":
                    animais[i] = new Chita(Zoo.getAno() - rand.nextInt((int) (Chita.VIDA_MEDIA * 0.5)), null);
                    break;
                case "Jaguar":
                    animais[i] = new Jaguar(Zoo.getAno() - rand.nextInt((int) (Jaguar.VIDA_MEDIA * 0.5)), null);
                    break;
                case "Leão":
                    animais[i] = new Leao(Zoo.getAno() - rand.nextInt((int) (Leao.VIDA_MEDIA * 0.5)), null);
                    break;
                case "Tigre":
                    animais[i] = new Tigre(Zoo.getAno() - rand.nextInt((int) (Tigre.VIDA_MEDIA * 0.5)), null);
                    break;
                default:
                    i--;
                    continue;
            }

            System.out.println((i + 1) + " - " + animais[i]);
        }

        int opcao;

        do {
            System.out.print("Digite o código da opção: ");
            opcao = scanner.nextInt();
        } while (opcao >= 0 && opcao <= 3); // [1,3]

        Animal animal = animais[opcao - 1];

        System.out.println("Escolheu: " + animal);

        System.out.print("Digite o nome do animal: ");

        String nome = scanner.nextLine();

        animal.setNome(nome);

        int custo = calcularCustoAquisicoes();

        zoo.removerDinheiro(custo);
        zoo.adicionarAnimal(animal);
        zoo.getHistorico().adicionarAquisicao(Zoo.getAno(), animal, custo);
    }
    
    public void caracAnimal(){
        boolean caracteristica = false;
        String nome = new String();
        String get = new String();
        while (caracteristica != true){ //o utilizador escrever a característica que quer desde que esteja na lista
            for (int i = 0; i<animalcaracteristica.size() ; i++){
                System.out.println( "Característica:"+animalcaracteristica.get(i)+"/n");
                animalcaracteristica.get(i) a = new animalcaracteristica.get(i);
                System.out.println("Preco: "+a.getPreco()+"/n");
            }
            get = scanner.nextLine();
            if(animalcaracteristica.contains(get)){
                caracteristica = true;
            }
            scanner.nextLine(); //limpar o scanner
        } 
        boolean id_possivel = false;
        int id;
            
        while (id_possivel != true){  //faz um random novo ate nao existir o random vefito na lista de ids ja colocados
            Integer rand_2 = random.nextInt();
            if (idAnimalSaidos.contains(rand_2) != true){  //verifica se o id ja existe nouto animal
                id = rand_2.intValue();
                id_possivel = true;
            }
        }
        int rand = random.nextInt();
        int idade = rand;
        rand = random.nextInt(100);
        int atratividade = rand;
        rand = random.nextInt(100);
        int apetiteReprodutivo = rand;
        rand = random.nextInt(animaisPossiveis.size());
        Animal a = new get(id, nome, idade, atratividade, apetiteReprodutivo);
        
        idAnimalSaidos.add(a.getId()); //adicionar aos id já saidos
        
        System.out.println("Qual é o nome que deseja dar ao animal?/n");
        nome = scanner.nextLine();
        a.setNome(nome);
        
        historico.setHistorico(a);
        zoo.addAnimal(a);   
    }
    
    public void construirInstalacao() {
        int[] tamanho = {random.nextInt(5)+1, random.nextInt(5)+1, random.nextInt(5)+1};
        int[] preco = {random.nextInt(9000)+1000, random.nextInt(9000)+1000, random.nextInt(9000)+1000};
        
        for(int i=0; i<tamanho.length; i++){
            System.out.println(i+": " + "Tamanho:" +tamanho[i]+ " " + "Preço:"+preco[i]);
        }
        
        System.out.println("4: Cancelar");
        System.out.println("Escreva a opção:");
        int opcao = scanner.nextInt();
        switch (opcao){
            case 1:
                mapa.put(null , new Instalacao(tamanho[0]));
                zoo.removerDinheiro(preco[0]);
                break;
            case 2:
                mapa.put(null , new Instalacao(tamanho[1]));
                zoo.removerDinheiro(preco[1]);
                break;
            case 3:
                mapa.put(null , new Instalacao(tamanho[2]));
                zoo.removerDinheiro(preco[2]);
                break;
            case 4:
                break;
            default:
                    System.out.println("O número não existe.");
                    break;
        }
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
