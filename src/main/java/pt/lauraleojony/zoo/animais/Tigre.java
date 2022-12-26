package pt.lauraleojony.zoo.animais;

public class Tigre extends Panthera {
    
    public Tigre(String nome) {
        super(nome, 0, 100, 100);
    }
    
    public void rugir() {
        System.out.println("roar sou um tigre");
    }
    
}
