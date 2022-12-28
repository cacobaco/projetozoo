package pt.lauraleojony.zoo;

/**
 *
 * @author leo
 */
public class Main {
    
    private static Zoo zoo;
    
    public static void main(String[] args) {
        zoo = new Zoo();
    }
    
    public static Zoo getZoo() {
        return zoo;
    }
    
}
