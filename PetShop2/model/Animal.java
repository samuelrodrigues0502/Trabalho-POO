package model;

import java.util.Objects;

public abstract class Animal implements Comparable<Animal>{

    private int codigo;
    private String nome;
    private String endereco;
    private String cidade;

    /**
     * Construtor da classe animal
     */
    public Animal() {
        // TODO Auto-generated constructor stub
    }

    /**
     * Construtor da classe animal com parâmetros
     *
     * @param codigo Código do animal
     * @param nome Nome do animal
     * @param endereco Endereço do animal
     * @param cidade Cidade do animal
     */
    public Animal(int codigo, String nome, String endereco, String cidade) {
        this.codigo = codigo;
        this.nome = nome;
        this.endereco = endereco;
        this.cidade = cidade;
    }

    /**
     * Obtém código do animal
     *
     * @return Retorna código do animal
     */
    public int getCodigo() {
        return this.codigo;
    }

    /**
     * Seta código do animal
     *
     * @param codigo Código a ser inserido
     */
    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    /**
     * Obtém nome do animal
     *
     * @return Retorna nome do animal
     */
    public String getNome() {
        return this.nome;
    }

    /**
     * Seta nome do animal
     *
     * @param nome Nome a ser inserido
     */
    public void setNome(String nome) {
        this.nome = nome;
    }

    /**
     * Obtém endereço do animal
     *
     * @return Retorna endereço do animal
     */
    public String getEndereco() {
        return this.endereco;
    }

    /**
     * Seta endereço do animal
     *
     * @param endereco Endereço a ser inserido
     */
    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    /**
     * Obtém cidade do animal
     *
     * @return Retorna cidade do animal
     */
    public String getCidade() {
        return this.cidade;
    }

    
    
    /**
     * Seta cidade do animal
     *
     * @param cidade Cidade a ser inserida
     * 
     */
    public void setCidade(String cidade) {
        this.cidade = cidade;
    }
    
    public abstract float getTaxa();

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 59 * hash + this.codigo;
        hash = 59 * hash + Objects.hashCode(this.nome);
        hash = 59 * hash + Objects.hashCode(this.endereco);
        hash = 59 * hash + Objects.hashCode(this.cidade);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Animal other = (Animal) obj;
        if (this.codigo != other.codigo) {
            return false;
        }
        if (!Objects.equals(this.nome, other.nome)) {
            return false;
        }
        if (!Objects.equals(this.endereco, other.endereco)) {
            return false;
        }
        return Objects.equals(this.cidade, other.cidade);
    }

    @Override
    public int compareTo(Animal o) {
        if(o.codigo == codigo){
            return 0;
        }
        return -1;
    }
    
    
    
    
    @Override
    public String toString() {

        return "Código do Animal: " + this.codigo + "\nNome: " + this.nome
                + "\nEndereço: " + this.endereco + "\nCidade: " + this.cidade;
    }
}
