package pt.lauraleojony.zoo.listas;

import java.util.ArrayList;
import pt.lauraleojony.zoo.Zoo;
import pt.lauraleojony.zoo.animais.Animal;

/**
 *
 * @author leo
 */
public class Obituario {
    
    private ArrayList<String> obituario;
    
    public Obituario() {
        obituario = new ArrayList<>();
    }
    
    public void adicionarObito(Animal animal) {
        obituario.add("[" + Zoo.getAno() + "] " + animal);
    }
    
    @Override
    public String toString() {
        String str = "----- @ Obituário @ -----\n";
        
        for (String s : obituario) {
            str  += s + "\n";
        }
        
        str += "-------------------------\n";
        
        return str;
    }
    
}
