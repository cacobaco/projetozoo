package pt.lauraleojony.zoo.animais;

import java.util.*;
import pt.lauraleojony.zoo.Zoo;
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
    
    @Override
    public String determinarCorOlhoDireito() {
        int code = Objects.hash(id, anoNascimento) % CORES_OLHOS.length;
        return CORES_OLHOS[code];
    }
    
    @Override
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
            
            return CORES_OLHOS[code];
        }
        
        return direito;
    }
    
    @Override
    public boolean determinarAlbinismo() {
        int hash = Objects.hash(id, anoNascimento);
        System.out.println(hash);
        return hash % 101 > 90;
    }
    
    @Override
    public boolean determinarHeterocromia() {
        int hash = Objects.hash(id, anoNascimento, determinarAlbinismo());
        System.out.println(hash);
        return hash % 101 > 90;
    }
    
    // retorna true se o animal quiser reproduzir
    public boolean tentarReproduzir() {
        Random rand = new Random();
        return rand.nextInt(101) < apetiteReprodutivo;
    }
    
    @Override
    public String toString() {
        String str = "Id: " + id + " / Nome: " + nome + " / Nasceu em: " + anoNascimento + " / Idade: " + (Zoo.getAno() - anoNascimento) + " / Atratividade: " + atratividade + " / Apetite reprodutivo: " + apetiteReprodutivo;
        return str;
    }
    
    @Override
    public boolean equals(Object obj) {
        if (obj == this) return true;
        if (obj == null) return false;
        if (obj.getClass() != this.getClass()) return false;
        
        Animal a = (Animal) obj;
        
        return this.id == a.getId() && this.anoNascimento == a.getAnoNascimento() && this.nome.equals(a.getNome()) && this.atratividade == a.getAtratividade() && this.apetiteReprodutivo == a.getApetiteReprodutivo();
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
