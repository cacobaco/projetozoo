package pt.lauraleojony.zoo;

import java.util.ArrayList;
import pt.lauraleojony.zoo.animais.Animal;
import pt.lauraleojony.zoo.instalacoes.*;
import pt.lauraleojony.zoo.listas.*;

/**
 *
 * @author leo
 */
public class Zoo {
    
    private static int ano = 2022;
    private double dinheiro;
    private int segurancas;
    private ArrayList<Instalacao> instalacoes;
    private ArrayList<Animal> animais;
    private Historico historico;
    private Obituario obituario;
    
    public Zoo(double dinheiro, int segurancas) {
        this.dinheiro = dinheiro;
        this.segurancas = segurancas;
    }
    
    public void adicionarDinheiro(int dinheiro) {
        this.dinheiro += dinheiro;
    }
    
    public void removerDinheiro(int dinheiro) {
        this.dinheiro -= dinheiro;
    }
    
    public void adicionarAnimal(Animal animal) {
        animais.add(animal);
    }
    
    // getters & setters
    public static void setAno(int ano) {
        Zoo.ano = ano;
    }
    
    public static int getAno() {
        return ano;
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
    
    public Historico getHistorico() {
        return historico;
    }
    
    public Obituario getObituario() {
        return obituario;
    }
    
}
