package pt.lauraleojony.zoo.animais;

/**
 *
 * @author leo
 */
public abstract class Felino extends Animal {
    
    public static final double VIDA_MEDIA = 12.5;
    
    public Felino(int anoNascimento, String nome, int atratividade, int apetiteReprodutivo) {
        super(anoNascimento, nome, atratividade, apetiteReprodutivo);
    }
    
}
