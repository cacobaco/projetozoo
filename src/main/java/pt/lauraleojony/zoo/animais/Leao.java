package pt.lauraleojony.zoo.animais;

/**
 *
 * @author leo
 */
public class Leao extends Panthera {
    
    public Leao(String nome) {
        super(nome, 0, 100, 100);
    }
    
    public void rugir() {
        System.out.println("roar sou um leão");
    }
    
}
