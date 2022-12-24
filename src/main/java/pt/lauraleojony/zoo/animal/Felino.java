package pt.lauraleojony.zoo.animal;

public abstract class Felino extends Animal {
    
    private final double avgLife; 
    
    public Felino(String nome, int idade, int atratividade, int apetiteReprodutivo) {
        super(nome, idade, atratividade, apetiteReprodutivo);
        this.avgLife = 100;
    }
        
    public double getAvgLife() {
        return this.avgLife;
    }
    
}
