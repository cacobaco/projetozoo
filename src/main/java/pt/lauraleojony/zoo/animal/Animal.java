package pt.lauraleojony.zoo.animal;

public abstract class Animal {
    
    private static int count = 0;
    private final int id;
    private final String nome;
    private int idade;
    private final int atratividade;
    private final int apetiteReprodutivo;
    
    public Animal(String nome, int idade, int atratividade, int apetiteReprodutivo) {
        count++;
        this.id = count;
        this.nome = nome;
        this.idade = idade;
        this.atratividade = atratividade;
        this.apetiteReprodutivo = apetiteReprodutivo;
    }
    
    public void alimentar() {
    }

    public static int getCount() {
        return count;
    }

    public int getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public int getIdade() {
        return idade;
    }
    
    public void setIdade(int idade) {
        this.idade = idade;
    }
    
    public int getAtratividade() {
        return atratividade;
    }
    
    public int getApetiteReprodutivo() {
        return apetiteReprodutivo;
    }
    
}
