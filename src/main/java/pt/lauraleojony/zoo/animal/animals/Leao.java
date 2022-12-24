package pt.lauraleojony.zoo.animal.animals;

import pt.lauraleojony.zoo.animal.Panthera;

public class Leao extends Panthera {
    
    public Leao(String nome) {
        super(nome, 0, 100, 100);
    }
    
    public void rugir() {
        System.out.println("roar sou um leão");
    }
    
}
