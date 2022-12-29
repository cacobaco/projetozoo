package pt.lauraleojony.zoo.animais.caracteristicas;

/**
 *
 * @author leo
 */
public interface Olhos {
    
    public static final String[] CORES_OLHOS = new String[]{"Castanho", "Azul", "Verde", "Cinza"}; 
    
    public String determinarCorOlhoDireito();
    public String determinarCorOlhoEsquerdo();
    
}
