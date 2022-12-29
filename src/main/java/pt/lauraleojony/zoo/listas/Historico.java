package pt.lauraleojony.zoo.listas;

import java.util.ArrayList;
import pt.lauraleojony.zoo.animais.Animal;

/**
 *
 * @author leo
 */
public class Historico {
    
    private ArrayList<String> historico;
    
    public Historico() {
        historico = new ArrayList<>();
    }
    
    public void adicionarAquisicao(int ano, Animal animal, int custo) {
        historico.add("[" + ano + "] Nova aquisição por " + custo + "€ - " + animal);
    }
    
    @Override
    public String toString() {
        String str = "----- @ Histórico @ -----\n";
        
        for (String s : historico) {
            str  += s + "\n";
        }
        
        str += "-------------------------\n";
        
        return str;
    }
    
}
