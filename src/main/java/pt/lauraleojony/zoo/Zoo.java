package pt.lauraleojony.zoo;

import java.util.ArrayList;
import java.util.Map;
import pt.lauraleojony.zoo.animais.Animal;
import pt.lauraleojony.zoo.instalacoes.Instalacao;

/**
 *
 * @author leo
 */
public class Zoo {
    
    private double dinheiro;
    private int segurancas;
    private ArrayList<Instalacao> instalacoes;
    private ArrayList<Animal> animais;
    
    public ArrayList<Animal> getAnimaisEmInstalacao(Instalacao instalacao) {
        ArrayList<Animal> arr = new ArrayList<>();
                
        for (Map.Entry<Animal, Instalacao> entry : animais.entrySet()) {
            if (entry.getValue().equals(instalacao)) arr.add(entry.getKey());
        }
        
        return arr;
    }
    
    public void setDinheiro(double dinheiro) {
        this.dinheiro = dinheiro;
    }
    
    public double getDinheiro() {
        return dinheiro;
    }
    
    public void setSegurancas(int segurancas) {
        this.segurancas = segurancas;
    }
    
    public int getSegurancas() {
        return segurancas;
    }
    
    public ArrayList<Instalacao> getInstalacoes() {
        return instalacoes;
    }
    
    public ArrayList<Animal> getAnimais() {
        return animais;
    }
    
}
