package pt.lauraleojony.zoo.instalacoes;

import java.util.ArrayList;
import pt.lauraleojony.zoo.interfaces.Limpavel;
import pt.lauraleojony.zoo.animais.Animal;
import pt.lauraleojony.zoo.exceptions.InstalacaoCheiaException;

/**
 *
 * @author jony
 */
public class Instalacao implements Limpavel {
    
    private static int count = 1;
    private final int id;
    private final int capacidade;
    private int empregados;
    private ArrayList<Animal> animais;
    
    public Instalacao(int capacidade) {
        count++;
        this.id = count;
        this.capacidade = capacidade;
        this.empregados = capacidade * 2;
        this.animais = new ArrayList<>();
    }
    
    public int calcularCustoLimpeza() {
        return empregados * 40000;
    }
    
    public void adicionarAnimal(Animal animal) throws InstalacaoCheiaException {
        if (animais.size() < capacidade) {
            animais.add(animal);
        } else {
            throw new InstalacaoCheiaException("A instalação está cheia.");
        }
    }
    
    public void removerAnimal(Animal animal) {
        animais.remove(animal);
    }
    
    // getters & setters
    public int getId(){
        return id;
    }
    
    public int getCapacidade() {
        return capacidade;
    }
    
    public void setEmpregados(int empregados) {
        this.empregados = empregados;
    }
    
    public int getEmpregados() {
        return empregados;
    }
    
}