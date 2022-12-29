package pt.lauraleojony.zoo.animais;

/**
 *
 * @author leo
 */
public class Jaguar extends Panthera {
    
    public Jaguar(int anoNascimento, String nome, int atratividade, int apetiteReprodutivo) {
        super(anoNascimento, nome, atratividade, apetiteReprodutivo);
    }
    
    public void rugir() {
        System.out.println("roar sou um jaguar");
    }
    
}
