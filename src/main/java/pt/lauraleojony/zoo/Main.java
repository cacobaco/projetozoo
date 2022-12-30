package pt.lauraleojony.zoo;

/**
 *
 * @author leo
 */
public class Main {
    
    public static void main(String[] args) {
        Zoo zoo = new Zoo(500000, 5);
        Menu menu = new Menu(zoo);
        menu.menuPrincipal();
    }
    
}
