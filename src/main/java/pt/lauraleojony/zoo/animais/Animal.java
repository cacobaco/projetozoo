package pt.lauraleojony.zoo.animais;

import java.util.Objects;
import pt.lauraleojony.zoo.animais.caracteristicas.Olhos;
import pt.lauraleojony.zoo.animais.mutacoes.Albinismo;
import pt.lauraleojony.zoo.animais.mutacoes.Heterocromia;

/**
 *
 * @author leo
 */
public abstract class Animal implements Olhos, Albinismo, Heterocromia {
    
    private static int count = 0;
    private final int id;
    private final int anoNascimento;
    private String nome;
    private int atratividade;
    private int apetiteReprodutivo;
    
    public Animal(int anoNascimento, String nome, int atratividade, int apetiteReprodutivo) {
        this.id = ++count;
        this.anoNascimento = anoNascimento;
        this.nome = nome;
        this.atratividade = atratividade;
        this.apetiteReprodutivo = apetiteReprodutivo;
    }
    
    public String determinarCorOlhoDireito() {
        int code = Objects.hash(id, anoNascimento) % CORES_OLHOS.length;
        return CORES_OLHOS[code];
    }
    
    public String determinarCorOlhoEsquerdo() {
        String direito = determinarCorOlhoDireito();
        
        if (determinarHeterocromia()) {
            int code = Objects.hash(id, anoNascimento, direito) % CORES_OLHOS.length;
            
            if (CORES_OLHOS[code].equals(direito)) {
                try {
                    return CORES_OLHOS[++code];
                } catch (ArrayIndexOutOfBoundsException ex) {
                    return CORES_OLHOS[0];
                }
            }
            
            return direito;
        }
        
        return direito;
    }
    
    public boolean determinarAlbinismo() {
        int hash = Objects.hash(id, anoNascimento);
        System.out.println(hash);
        return hash % 2 == 0;
    }
    
    public boolean determinarHeterocromia() {
        return false;
    }
    
    // getters & setters
    public static int getCount() {
        return count;
    }

    public int getId() {
        return id;
    }
    
    public int getAnoNascimento() {
        return anoNascimento;
    }
    
    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }
    
    public int getAtratividade() {
        return atratividade;
    }
    
    public int getApetiteReprodutivo() {
        return apetiteReprodutivo;
    }
    
}
