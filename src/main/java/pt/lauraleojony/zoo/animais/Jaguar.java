package pt.lauraleojony.zoo.animais;

public class Jaguar extends Panthera {
    
    public Jaguar(String nome) {
        super(nome, 0, 100, 100);
    }
    
    public void rugir() {
        System.out.println("roar sou um jaguar");
    }
    
}
