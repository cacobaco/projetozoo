package pt.lauraleojony.zoo;

/**
 *
 * @author leo
 */
public class Main {
    
    private static int ano;
    private static Zoo zoo;
    private static Menu menu;
    
    public static void main(String[] args) {
        ano = 2022;
        zoo = new Zoo(50000, 5);
        menu = new Menu();
    }
    
    // getters & setters
    public static void setAno(int ano) {
        Main.ano = ano;
    }
    
    public static int getAno() {
        return ano;
    }
    
    public static Zoo getZoo() {
        return zoo;
    }
    
    public static Menu getMenu() {
        return menu;
    }
    
}
