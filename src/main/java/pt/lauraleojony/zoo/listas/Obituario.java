package pt.lauraleojony.zoo.listas;

import java.util.ArrayList;
import pt.lauraleojony.zoo.animais.Animal;

/**
 *
 * @author lcjmonizf09
 */
public class Obituario {
    
    private ArrayList<String> obituario;
    
    public Obituario() {
        obituario = new ArrayList<>();
    }
    
    public void adicionarObito(int ano, Animal animal) {
        obituario.add("[" + ano + "] " + animal);
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
