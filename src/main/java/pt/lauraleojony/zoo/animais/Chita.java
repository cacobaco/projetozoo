package pt.lauraleojony.zoo.animais;

/**
 *
 * @author leo
 */
public class Chita extends Felino {
    
    public Chita(int anoNascimento, String nome, int atratividade, int apetiteReprodutivo) {
        super(anoNascimento, nome, atratividade, apetiteReprodutivo);
    }
    
    @Override
    public String toString() {
        String str = "Animal: Chita / " + super.toString();
        return str;
    }
    
}
