package pt.lauraleojony.zoo.animais;

import pt.lauraleojony.zoo.mutacoes.Albinismo;
import pt.lauraleojony.zoo.mutacoes.Heterocromia;

public abstract class Animal implements Albinismo, Heterocromia {
    
    private static int count = 0;
    private final int id;
    private String nome;
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
    
    public boolean determinarAlbinismo() {
        return false;
    }
    
    public boolean determinarHeterocromia() {
        return false;
    }

    public static int getCount() {
        return count;
    }

    public int getId() {
        return id;
    }
    
    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }
    
    public void setIdade(int idade) {
        this.idade = idade;
    }
    
    public int getIdade() {
        return idade;
    }
    
    public int getAtratividade() {
        return atratividade;
    }
    
    public int getApetiteReprodutivo() {
        return apetiteReprodutivo;
    }
    
}
