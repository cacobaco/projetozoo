package pt.lauraleojony.zoo.animais;

public abstract class Panthera extends Felino {
    
    public Panthera(String nome, int idade, int atratividade, int apetiteReprodutivo) {
        super(nome, idade, atratividade, apetiteReprodutivo);
    }
    
    public abstract void rugir();
    
}