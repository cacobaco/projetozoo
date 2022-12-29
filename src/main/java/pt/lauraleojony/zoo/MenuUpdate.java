package pt.lauraleojony.zoo;

import java.util.*;
import pt.lauraleojony.zoo.instalacoes.*;
import pt.lauraleojony.zoo.animais.*;

/**
 *
 * @author laura
 */
public class MenuUpdate {
    
    private static final String[] TIPOS_ANIMAIS = new String[]{"Chita", "Jaguar", "Leão", "Tigre"}; // nome de todos os tipos de animais
    private final Zoo zoo;
    
    public MenuUpdate(Zoo zoo) {
        this.zoo = zoo;
    }
    
    // retorna true se o utilizador escolher sair da aplicação
    public boolean abrirMenu() {
        mostrarOpcoes();
        
        Scanner scanner = new Scanner(System.in);
        
        int opcao = scanner.nextInt();
        
        switch (opcao) {
            case 0: // sair da aplicação
                sair();
                return true;
            case 1: // adquirir animal aleatório
                adquirirAnimalAleatorio();
                break;
            case 2: // adquirir animal com característica genética
                adquirirAnimalCaracteristico();
                break;
            case 3: // construir instalação
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
                 getObitos();
                break;
            case 12: // histórico
                getHistorico();
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
    
    public void mostrarOpcoes() {
        System.out.println("Escolha uma opção:");
        System.out.println("1 - Adquirir animal aleatório (" + calcularCustoAquisicoes() + "€)");
        System.out.println("2 - Adquirir animal com caracteristica genética (" + calcularCustoAquisicoes() + "€)");
        System.out.println("3 - Construir instalação (" + calcularCustoInstalacao() + "€)");
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
        return 10000;
    }
    
    public int calcularCustoInstalacao() {
        return 50000;
    }
    
    public void adquirirAnimalAleatorio(){
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
        
        Scanner scanner = new Scanner(System.in);
        
        int opcao;
        
        do {
            System.out.print("Digite o código da opção: ");
            opcao = scanner.nextInt();
        } while (opcao > 0 && opcao < 4); // [1,3]
        
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
    
    public void adquirirAnimalCaracteristico(){
        boolean caracteristica = false;
        String nome = new String();
        String get = new String();
        while (caracteristica != true){ //o utilizador escrever a característica que quer desde que esteja na lista
            for (int i = 0; i<animalcaracteristica.size() ; i++){
                System.out.println( "Característica:"+animalcaracteristica.get(i)+"/n");
                animalcaracteristica.get(i) a = new animalcaracteristica.get(i)();
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
    
    public void calendárioChines() {
        
    }
    
    public void listarAnimais() {
        String str = "----- @ Animais @ -----\n";
        
        for (Instalacao instalacao : zoo.getInstalacoes()) {
            for (Animal animal : zoo.get)
        }
        
        for (Animal animal : zoo.getAnimais()) {
            
        }
    }
    
    public void listarAnimaisCarateristicos() s{
        Sysytem.out.println("Qual é a catacteristica que deseja procurar?/n");
        String catacteristica = scanner.nextLine();
        ArrayList<Animal> animal = new ArrayList<Animal>();
        for (Map.Entry m : zoo.getHashMap().entrySet()){ //não ter instalações repetidas
            animal.add(m.getValue());
            if (animal.catacteristica() == catacteristica){
                animal.toString();
            }
        }
    }
    
    public void listaAnimaisMutação(){
        Sysytem.out.println("Qual é a mutacao que deseja procurar?/n");
        String mutacao = scanner.nextLine();
        ArrayList<Animal> animal = new ArrayList<Animal>();
        for (Map.Entry m : zoo.getHashMap().entrySet()){ //não ter instalações repetidas
            animal.add(m.getValue());
            if (animal.mutacao() == mutacao){
                animal.toString();
            }
        }
    }
    
    public void listaInstalacao(){
        HashMap <Instalacao,Animal> mapa = new HashMap <Instalacao, Animal>();
        for (Map.Entry m : zoo.getHashMap().entrySet()){ //não ter instalações repetidas
            mapa.put(m.getValue(), m.getKey());
        }
        for (Map.Entry m : mapa.entrySet()){  //print tudas as instalações
            System.out.println("Instalação "+m.getKey().toString());
        }
    }
    
    public void retatoFamiliaAnimal(){
        
    }
    
    public void getObitos(){
        ArrayList<Animal> ob = obituario.getMorto();
        for (Animal a : ob){
            System.out.println("Animal: "+a.toString());
        }
    }
    
    public void getHistorico(){
        ArrayList<Animal> hist = historico.getHistorico();
        for (Animal a : hist){
            System.out.println("Animal: "+a.toString());
        }
        listaInstalacao();
    }
    
    public void períodoContabilistico(){
        
    }
    
    public void jumanji(){
        
    }
    
    public void sair(){
        
    }
    
}
