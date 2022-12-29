package pt.lauraleojony.zoo;

import java.util.*;
import pt.lauraleojony.zoo.instalacoes.*;
import pt.lauraleojony.zoo.animais.Animal;
import pt.lauraleojony.zoo.listas.Historico;
import pt.lauraleojony.zoo.listas.Obituario;
/**
 *
 * @author laura
 */
public class Menu {
    
    private final Zoo zoo;
    private final Scanner scanner;
    private final Random random;
    private ArrayList<String> animaisPossiveis; //ter o nome de todos os animais possiveis
    private ArrayList<String> animalcaracteristica; //ter todas as características possíveis
    private ArrayList<Integer> idAnimalSaidos; //ter o id de tudos os animais tirados
    
    public Menu(Zoo zoo){
        this.zoo = zoo;
        this.scanner = new Scanner(System.in);
        this.random = new Random();
        this.animaisPossiveis = new ArrayList<>();
        this.animalcaracteristica = new ArrayList<>();
        this.idAnimalSaidos = new ArrayList<>();
    }
    
    public void menuPrincipal() {    
        escolhaOpcao();
        int escolha = scanner.nextInt();
        switch (escolha){
            case 1:
                criateRandomAnimal();
                break;
            case 2:
                caracAnimal();
                break;
            case 3:
                break;
            case 4:
                break;
            case 5:
                break;
            case 6: 
                listaAnimais();
                break;
            case 7:
                listaAnimaisCarateristica();
                break;
            case 8:
                listaAnimaisMutação();
                break;
            case 9:
                listaInstalacao();
                break;
            case 10:
                break;
            case 11:
                 getObitos();
                break;
            case 12:
                getHistorico();
                break;
            case 13:
                break;
            case 14:
                break;
            case 15:
                break;
            default:
                System.out.println("O número não existe.");
                break;
        }
      
        
    }
    
    public void escolhaOpcao(){
        System.out.println("Escolha uma opcao:/n");
        System.out.println("Adquirir animal aleatório - 1/n");
        System.out.println("Adquirir animal com característica genética - 2/n");
        System.out.println("Construir instalação - 3/n");
        System.out.println("Colocar animal em instalação - 4/n");
        System.out.println("Calendário chinês - 5/n");
        System.out.println("Listar animais - 6/n");
        System.out.println("Listar animais com dada característica genética - 7/n");
        System.out.println("Listar animais com dada mutação - 8/n");
        System.out.println("Listar Instalações - 9/n");
        System.out.println("Retrato de família animal - 10/n");
        System.out.println("Obituário - 11/n");
        System.out.println("Histórico - 12/n");
        System.out.println("Período contabilístico - 13/n");
        System.out.println("Jumanji - 14/n");
        System.out.println("Sair da aplicação - 15/n");
        System.out.println("/nEscreva a opção:");
    }
    
    public static ArrayList<String> getAnimaisPossiveis(){
        return animaisPossiveis;
    }
    public static void addAnimal(String a){
        animaisPossiveis.add(a);
    }
    public static void remuveAnimal (String a){
        animaisPossiveis.remove(a);
    }
    public static int animaisPossiveisSize(){
        return animaisPossiveis.size();
    }
    
    public void criateRandomAnimal(){
        Animal[] animalEscolhido = new Animal[3];
        for(int i=0;i<3;i++){  //cria tres animais random
            System.out.println("Animal " + i+1 + ": /n");
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
            Animal a = new animaisPossiveis[rand](id, nome, idade, atratividade, apetiteReprodutivo);
            animalEscolhido[i] = a;
            a.toString();
        }
        
        int esc = scanner.nextInt();
        Integer esc_2 = esc-1;
        
        idAnimalSaidos.add(animalEscolhido[esc-1].getId());
        
        System.out.println("Qual é o nome que deseja dar ao animal?/n");
        String nome = scanner.nextLine();
        animalEscolhido[esc-1].setNome(nome);
        
        historico.setHistorico(animalEscolhido[esc-1]);
        zoo.addAnimal(animalEscolhido[esc-1]);
    }
    
    public void caracAnimal(){
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
    
    //duas do jhonny
    
    public void calendárioChines(){
        
    }
    
    public void listaAnimais(){
        ArrayList<Animal> animal = new ArrayList<Animal>();
        for (Map.Entry m : zoo.getHashMap().entrySet()){ //não ter instalações repetidas
            animal.add(m.getValue());
            animal.toString();
        }
        
    }
    
    public void listaAnimaisCarateristica(){
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
