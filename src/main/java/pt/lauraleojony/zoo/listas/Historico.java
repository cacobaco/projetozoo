package pt.lauraleojony.zoo.listas;

import java.util.ArrayList;
import pt.lauraleojony.zoo.Zoo;
import pt.lauraleojony.zoo.instalacoes.*;
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
    
    public void adicionarAquisicao(Animal animal, double custo) {
        historico.add("[" + Zoo.getAno() + "] Novo animal adquirido por " + custo + "€ - " + animal);
    }
    
    public void adicionarConstrucao(Instalacao instalacao, double custo) {
        historico.add("[" + Zoo.getAno() + "] Nova instalação #" + instalacao.getId() + " construida por " + custo + "€");
    }
    
    public void adicionarNascimento(Animal animal) {
        historico.add("[" + Zoo.getAno() + "] Novo animal nasceu - " + animal);
    }
    
    public void adicionarObito(Animal animal) {
        historico.add("[" + Zoo.getAno() + "] Animal morreu - " + animal);
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
