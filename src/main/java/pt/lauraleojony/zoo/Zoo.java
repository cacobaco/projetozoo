package pt.lauraleojony.zoo;

import java.util.ArrayList;
import pt.lauraleojony.zoo.animais.Animal;
import pt.lauraleojony.zoo.exceptions.DinheiroInsuficienteException;
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
        this.instalacoes = new ArrayList<>();
        this.animais = new ArrayList<>();
        this.historico = new Historico();
        this.obituario = new Obituario();
    }
    
    public void adicionarDinheiro(double dinheiro) {
        this.dinheiro += dinheiro;
    }
    
    // método para compras do zoo
    public void gastarDinheiro(double dinheiro) throws DinheiroInsuficienteException {
        if (this.dinheiro - dinheiro < 0) {
            throw new DinheiroInsuficienteException("O Zoo não tem dinheiro suficiente para essa operação.");
        } else {
            this.dinheiro -= dinheiro;
        }
    }
    
    // método para ações fiscais etc, que podem deixar divida
    public void removerDinheiro(double dinheiro) {
        this.dinheiro -= dinheiro;
    }
    
    public void adicionarInstalacao(Instalacao instalacao) {
        instalacoes.add(instalacao);
    }
    
    public void removerInstalacao(Instalacao instalacao) {
        instalacoes.remove(instalacao);
    }
    
    public void adicionarAnimal(Animal animal) {
        animais.add(animal);
    }
    
    public void removerAnimal(Animal animal) {
        for (Instalacao instalacao : instalacoes) {
            instalacao.removerAnimal(animal);
        }
        animais.remove(animal);
    }
    
    // retorna o animal que tem o id ou null caso não exista
    public Animal getAnimal(int id) {
        for (Animal animal : animais) {
            if (animal.getId() == id) return animal;
        }
        return null;
    }
    
    public ArrayList<Animal> getAnimaisComInstalacao() {
        ArrayList<Animal> arr = new ArrayList<>();
        
        for (Instalacao instalacao : instalacoes) {
            arr.addAll(instalacao.getAnimais());
        }
        
        return arr;
    }
    
    public ArrayList<Animal> getAnimaisComMutacao() {
        ArrayList<Animal> arr = new ArrayList<>();
        
        for (Animal animal : animais) {
            if (animal.determinarAlbinismo() || animal.determinarHeterocromia()) arr.add(animal);
        }
        
        return arr;
    }
    
    public ArrayList<Animal> getAnimaisComAlbinismo() {
        ArrayList<Animal> arr = new ArrayList<>();
        
        for (Animal animal : animais) {
            if (animal.determinarAlbinismo()) arr.add(animal);
        }
        
        return arr;
    }
    
    public ArrayList<Animal> getAnimaisComHeterocromia() {
        ArrayList<Animal> arr = new ArrayList<>();
        
        for (Animal animal : animais) {
            if (animal.determinarHeterocromia()) arr.add(animal);
        }
        
        return arr;
    }
    
    // retorna a instalação de um animal ou null caso este não esteja numa instalação
    public Instalacao getInstalacao(Animal animal) {
        for (Instalacao instalacao : instalacoes) {
            if (instalacao.getAnimais().contains(animal)) return instalacao;
        }
        return null;
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
