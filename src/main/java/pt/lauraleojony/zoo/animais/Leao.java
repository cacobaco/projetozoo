package pt.lauraleojony.zoo.animais;

/**
 *
 * @author leo
 */
public class Leao extends Panthera {
    
    public Leao(int anoNascimento, String nome, int atratividade, int apetiteReprodutivo) {
        super(anoNascimento, nome, atratividade, apetiteReprodutivo);
    }
    
    public void rugir() {
        System.out.println("roar sou um leão");
    }
    
}
