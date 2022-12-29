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
    
    public ArrayList<Animal> getAnimais() {
        return animais;
    }
    
    @Override
    public String toString() {
        String str = "----- @ Instalação #" + id + " @ -----\n";
        str += "Capacidade: " + animais.size() + "/" + capacidade + "\n";
        str += "Empregados: " + empregados + "\n";
        str += "Animais: \n";
        
        int i = 0;
        for (Animal a : animais) {
            str  += ++i + ". " + a + "\n";
        }
        
        str += "-------------------------\n";
        
        return str;
    }
    
    @Override
    public boolean equals(Object obj) {
        if (obj == this) return true;
        if (obj == null) return false;
        if (obj.getClass() != this.getClass()) return false;
        
        Instalacao i = (Instalacao) obj;
        
        return this.id == i.getId() && this.capacidade == i.getCapacidade() && this.empregados == i.getEmpregados() && this.animais.equals(i.getAnimais());
    }
    
}