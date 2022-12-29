package pt.lauraleojony.zoo.animais;

/**
 *
 * @author leo
 */
public abstract class Panthera extends Felino {
    
    public static final int PRECO = 7500;
    
    public Panthera(int anoNascimento, String nome, int atratividade, int apetiteReprodutivo) {
        super(anoNascimento, nome, atratividade, apetiteReprodutivo);
    }
    
    public abstract void rugir();
    
}
