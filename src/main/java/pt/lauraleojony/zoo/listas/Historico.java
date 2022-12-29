package pt.lauraleojony.zoo.listas;

import java.util.ArrayList;
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
    
    public void adicionarAquisicao(int ano, Animal animal, int custo) {
        historico.add("[" + ano + "] Novo animal adquirido por " + custo + "€ - " + animal);
    }
    
    public void adicionarConstrucao(int ano, Instalacao instalacao, int custo) {
        historico.add("[" + ano + "] Nova instalação #" + instalacao.getId() + " construida por " + custo + "€");
    }
    
    public void adicionarNascimento(int ano, Animal animal) {
        historico.add("[" + ano + "] Novo animal nasceu - " + animal);
    }
    
    public void adicionarObito(int ano, Animal animal) {
        historico.add("[" + ano + "] Animal morreu - " + animal);
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
