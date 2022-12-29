package pt.lauraleojony.zoo.animais;

/**
 *
 * @author leo
 */
public class Leao extends Panthera {
    
    public Leao(int anoNascimento, String nome) {
        super(anoNascimento, nome, 100, 100);
    }
    
    public void rugir() {
        System.out.println("roar sou um leão");
    }
    
}
