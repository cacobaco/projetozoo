package pt.lauraleojony.zoo.animais;

/**
 *
 * @author leo
 */
public class Tigre extends Panthera {
    
    public Tigre(int anoNascimento, String nome, int atratividade, int apetiteReprodutivo) {
        super(anoNascimento, nome, atratividade, apetiteReprodutivo);
    }
    
    public void rugir() {
        System.out.println("roar sou um tigre");
    }
    
    @Override
    public String toString() {
        String str = "Animal: Tigre / " + super.toString();
        return str;
    }
    
}
